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

/*      
 * 
 * 
 * */



public class FejecutarVariasClases2 {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ; 
    
    //precondicion
    
    @BeforeMethod
    public void beforeMethod(ITestResult result) {
  	  System.out.println("metodo: " + result.getMethod().getMethodName() + ", " + result.getMethod().getDescription() + ", el estado es: " +result.getStatus()+
  			  ", tiempo en ser invocado: "+ result.getMethod().getInvocationTimeOut() + ", prioridad: " + result.getMethod().getPriority() +
  			   ", esta enabled?: " + result.getMethod().getEnabled() + ", total de veces invocado: " + result.getMethod().getInvocationCount()+
  			   ", porcentaje éxito: " + result.getMethod().getSuccessPercentage() + "%.");
    }

    @BeforeClass
    public void beforeClass() {

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
