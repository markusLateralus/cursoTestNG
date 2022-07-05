package AinicioTestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/*       @DataProvider
 * - Tiene un atributo de tipo String que es su nombre. Si no lo declaramos tomará como nombre, el nombre del método.
 * En este método realizamos una carga de datos que puede ser harkodeada, recibida por una excel o por bd.
 * 
 * la etiqueta llevará la siguiente configuración
 *      @DataProvider(name="autenticarDatos")
 *      
 * el método que vaya a realizar la prueba deberá llevará 2 configuraciones:
 *     1º  @Test(dataProvider = "autenticarDatos")
 *     2º  Los parámetros de entrada deben llevar las variables que almacena el método dataProvaider()
 * 
 * 
 * 
 * */
public class AetiquetaDataProvider {
	
	WebDriver driver;
	By localizadorLogarse=By.linkText("Sign in");
	By localizadorEmail=By.id("email");
	By localizadorPassword=By.id("passwd");
	By localizadorBotonLogarse=By.id("SubmitLogin");
	By localizadorBotonDeslogarse=By.cssSelector(("a.logout"));
	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.get(("http://automationpractice.com/index.php"));
		driver.manage().window().maximize();
	}
	
  @Test(dataProvider = "autenticarDatos")
  public void login(String email, String password) {
	  if(driver.findElement(localizadorLogarse).isDisplayed()) {
		  driver.findElement(localizadorLogarse).click();
		  WebDriverWait wait=new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(localizadorEmail));
		  //nos registramos
		  driver.findElement(localizadorEmail).sendKeys(email);		  
		  driver.findElement(localizadorPassword).sendKeys(password);
		  driver.findElement(localizadorBotonLogarse).click();
		  
		  assertEquals(driver.findElement(localizadorBotonDeslogarse).getText(), "Sign out");
		  
		  driver.findElement(localizadorBotonLogarse).click();
		  
	  }else {
		  System.out.println("no está");
	  }
  }

  @DataProvider(name="autenticarDatos")
  public Object[][] getDatos() {
	  //podemos cargar datos de BD o de una excell
	  						//correo y contrasena
    Object[][]datos=new Object[2][2];
    //usuario1
    datos[0][0]="qs123@gmali.com";  datos[0][1]="qs123"; 
    //usuario2
    datos[1][0]="testng_qs@gamil.com";  datos[1][1]="qs123";
    return datos;
  }
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
}
