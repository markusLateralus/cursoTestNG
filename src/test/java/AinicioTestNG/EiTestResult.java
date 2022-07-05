package AinicioTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/*      interface ITestResult
 * 
 * se utiliza para ver más claro los resultados de las pruebas
 * 
 * se utiliza en @AfterMethod, pasado por parámetro
 * 
 * 
 * */



public class EiTestResult {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ; 
    
    //precondicion
    @BeforeClass
    public void beforeClass() {
  	  System.out.println("launching firefox browser"); 
  	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  		driver= new ChromeDriver(); 
        driver.get(baseUrl);
    }
    
    
  @Test (enabled=false)    //deshabilidato
  public void test1() {
	
      String expectedTitle = "Welcome: Mercury Tour";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle, "deben tener el mismo título");
  }
  
  @Test(description="Verifica que el nombre del titulo es el correcto.")
  public void test2() {
	
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle, "deben tener el mismo título");
  }
  
  @Test(description="Verifica que es un metodo igual que el test2.")
  public void test3() {
	
      String expectedTitle = "Welcome: Mercury Tour";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle, "deben tener el mismo título");
  }
  //poscondiciones
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @BeforeMethod
  public void beforeMethod(ITestResult result) {
	  System.out.println("resultado: " + result.getMethod().getDescription() + "obtuvo como resultado final " +result.getStatus());
  }

  @AfterMethod
  public void afterMethod() {
  }




  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
