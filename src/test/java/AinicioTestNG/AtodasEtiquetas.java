package AinicioTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/*       NUEVAS ETIQUETAS   (ayuda a no repetir código)
 *    Este es el órden de ejecución de TestNG
 *    
 *    son Precondiciones y Postcondiciones
 * 
 * @BeforeSuite  ->   Antes de que se hayan ejecutado todos los tests de la suit(conjunto de pruebas que sirven para verificar que cierto comportamiento de un software funcione)
 * @AfterSuite   ->   Después..
 * 
 * @BeforeTest ->   Este método se ejecutará antes de que se declare cada sección de prueba en la suite.
 * @AfterTest  ->   Después..
 * 
 * @BeforeClass ->   Este método se ejecutará antes que el primer método de prueba en la clase actual. Antes de invocar al primer método TEST en la clase actual
 * @AfterClass  ->   Después...
 *  
 * @BeforeMethod ->  Se ejecuta Antes de que se ejecuten cada método TEST
 * @AfterMethod  ->   Después..
 * 
 * 
 * @DataProvider -> Tiene un atributo de tipo String que es su nombre. Si no lo declaramos tomará como nombre, el nombre del método.
 * 
 * */



public class AtodasEtiquetas {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ; 
    
    @BeforeClass
    public void beforeClass() {
  	  System.out.println("soy @BeforeClass"); 
  	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  		driver= new ChromeDriver(); 
        driver.get(baseUrl);
    }
  @Test
  public void f() {
	
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("soy @AfterSuite");
	  driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("soy @BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("soy @AfterMethod");
  }




  @BeforeTest
  public void beforeTest() {
	  System.out.println("soy @BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("soy @BAfterTest");
  }

  //
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("soy @BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("soy @AfterSuite");
  }

}
