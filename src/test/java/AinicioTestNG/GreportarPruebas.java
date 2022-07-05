package AinicioTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Herramientas.BrowserManager;
import Herramientas.ResultManager;

/*    Generar  Reportes de Pruebas.
 * 
 *
 * 1º paso: tener creado el archivo testNG.xml  
 *   - pulsamos en el paquete y botón derecho->TestNG->Convert to TestNG y se nos genera el archivo testNG.xml
 *   - ejecutamos la prueba.
 *   
 * 2º nos vamos a la carpeta del proyecto /test-output/emailable-report.html y lo abrimos.
 *    Obtenemos la información de los test, tanto si han sido OK como si han sido KO.
 *    
 *  
 *   
 *   
 * 
 *    
 *    este ejemplo de prueba es de como utilizar múltiples navegadores
 *    
 * 
 * 
 * 
 * */

public class GreportarPruebas {
	
	//public String baseUrl = "https://www.demoblaze.com/";
    public WebDriver driver ; 
    By localizadorEnlaceSignUp=By.id("signin2");
    By localizadorInputUsername=By.id("sign-username");
    By localizadorInputPassword=By.id("sign-password");
    By localizadorBotonSignUp=By.xpath("(//div[@class=\"modal-footer\"]/descendant::button[@class=\"btn btn-primary\"])[2]");
    By localizadorBotonCruz=By.xpath("(//div[@class=\"modal-header\"]/descendant::button[@class=\"close\"])[2]");
    
    @BeforeMethod
    public void beforeMethod(ITestResult result) {
    	ResultManager.mostrarResultado(result);
    }

    @BeforeClass
    @Parameters({"URL", "TipoNavegador"})//aqui ponemos el valor de NAME de los parameters del archivo testng.xml
    public void beforeClass(String url, String tipoNavegador) { //aquí le agregamos los parámetros, tantos como parameters tenga el archivo testng.xml
    	driver=BrowserManager.setDriverNavegador(tipoNavegador);
    	driver.manage().window().maximize();
    	   driver.get(url);
      
    }
    
    
  @Test (enabled=false)    //deshabilidato
  public void login() {
	  driver.findElement(localizadorEnlaceSignUp).click();
	  driver.findElement(localizadorInputUsername).sendKeys("marcosArronres135");
	  driver.findElement(localizadorInputPassword).sendKeys("123");
	  driver.findElement(localizadorBotonSignUp).click();
	  
	  
  }
  
  @Test(description="Verifica el login correcto desde 2 navegadores.", priority=1)
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
		driver.findElement(localizadorBotonCruz).click();
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