package AinicioTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/*
 * creamos el archivo testng.xml,boton derecho en el paquete, TestNG-> Convert to TestNG
 * configuramos el archivo  "testng.xml" para que de forma más óptima podamos poner timeout a muchos más métodos de una sola vez
 * 
 * 
 *             <?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
				<suite name="Grupo de casos de tests que voy a ejecutar" time-out="2000">
				<test name="subGrupo del grupo ">
				<classes>
				<class name="AinicioTestNG.FejecutarVariasClases"/>
				<class name="AinicioTestNG.FejecutarVariasClases2"/>
				</classes>
				</test>
				</suite>
 * 
 * */



public class DsuiteTimeout {
	
	public String baseUrl = "https://www.demoblaze.com/";
    public WebDriver driver ; 
    By localizadorEnlaceSignUp=By.id("signin2");
    By localizadorInputUsername=By.id("sign-username");
    By localizadorInputPassword=By.id("sign-password");
    By localizadorBotonSignUp=By.xpath("(//div[@class=\"modal-footer\"]/descendant::button[@class=\"btn btn-primary\"])[2]");
    By localizadorBotonCrux=By.xpath("(//div[@class=\"modal-header\"]/descendant::button[@class=\"close\"])[2]");
    
    @BeforeMethod
    public void beforeMethod(ITestResult result) {
  	  System.out.println("metodo: " + result.getMethod().getMethodName() + ", " + result.getMethod().getDescription() + ", el estado es: " +result.getStatus()+
  			  ", tiempo en ser invocado: "+ result.getMethod().getInvocationTimeOut() + ", prioridad: " + result.getMethod().getPriority() +
  			   ", esta enabled?: " + result.getMethod().getEnabled() + ", total de veces invocado: " + result.getMethod().getInvocationCount()+
  			   ", porcentaje éxito: " + result.getMethod().getSuccessPercentage() + "%.");
    }
    //precondicion
    @BeforeClass
    public void beforeClass() {
  	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  		driver= new ChromeDriver(); 
        driver.get(baseUrl);
      
    }
    
    
  @Test (enabled=false)    //deshabilidato
  public void login() {
	  driver.findElement(localizadorEnlaceSignUp).click();
	  driver.findElement(localizadorInputUsername).sendKeys("marcosArronres135");
	  driver.findElement(localizadorInputPassword).sendKeys("123");
	  driver.findElement(localizadorBotonSignUp).click();
	  
	  
  }
  
  @Test(description="Verifica que el nombre del titulo es el correcto.", priority=1)
  public void login2() {
	  driver.findElement(localizadorEnlaceSignUp).click();
	  driver.findElement(localizadorInputUsername).sendKeys("marcosArronres135");
	  driver.findElement(localizadorInputPassword).sendKeys("123");
	  driver.findElement(localizadorBotonSignUp).click();
	  WebDriverWait waitExplicito =new WebDriverWait(driver,10);
		//2º hay que preguntar si el ALERT está presente:
		Alert alert=waitExplicito.until(ExpectedConditions.alertIsPresent());
		//3º pulsamos el botón aceptar del alert
		alert.accept();
		driver.findElement(localizadorBotonCrux).click();
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
