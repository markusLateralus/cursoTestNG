package AinicioTestNG;

import org.testng.annotations.Test;

import Herramientas.Subir;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


/*
 * 
 * 
 * 
 * 
 * 
 *     http://the-internet.herokuapp.com/upload
 * */
public class HsubirArchivo {
	
	private WebDriver driver;
	String url=" http://the-internet.herokuapp.com/upload";
	By localizadorBuscarDirectorio= By.id("file-upload");
	By localizadorBotonCargar=By.id("file-submit");
	By localizadorMensajeCarga=By.id("uploaded-files");
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  	driver=new ChromeDriver();
	    	driver.manage().window().maximize();
	    	   driver.get(url);
	  }

  @Test
  public void subirArchivo() {
	  String nombreArchivo="C:\\Users\\mraralma\\proyectosEclipse\\cursoInicioTestNG\\descargas\\1646460734364.png";
	  Subir.subirArchivo(driver, localizadorBuscarDirectorio, localizadorBotonCargar, localizadorMensajeCarga, nombreArchivo);
	  /*
	  File archivo=new File(nombreArchivo);
	  String path=archivo.getAbsolutePath();
	  driver.findElement(localizadorBuscarDirectorio).sendKeys(path);
	  driver.findElement(localizadorBotonCargar).click();
	  //verificar que se ha subido
	  String textoObtenido=driver.findElement(localizadorMensajeCarga).getText();
	  String textoEsperado="1646460734364.png";
	  assertEquals(textoObtenido, textoEsperado);
	  */
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
