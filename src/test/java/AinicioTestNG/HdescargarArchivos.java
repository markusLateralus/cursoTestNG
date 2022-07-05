package AinicioTestNG;

import org.testng.annotations.Test;
import Herramientas.BrowserManager;
import Herramientas.Descarga;
import Herramientas.ResultManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;



/*   Descargar archivo
 * 
 * 1º debemos realizar unas configuraciones en el navegador para que cuando pulse en el enlace de descarga, NO se abra ninguna ventana
 *    emergente, sino que de forma directa se descargue el archivo, en la carpeta que nosotros configuremos.
 *    
 *    Esto se realiza en dos pasos:
 *       - primero cambiamos las preferencias
 *       - segundo, aplicamos las preferencias al navegador
 *    
 *  
 *  2º Automatizamos la opción de descargar un enlace en el directorio deseado.
 *  
 *  3º verificamos que en la carpeta donde se ha realizado la descarga está vacía o no.
 * 
 * 
 *  VAMOS A VERIFICAR EL NOMBRE DEL ARCHIVO DESCARGADO Y QUE NO PESO 0KB
 *  
 *   - creamos una conexion http con el link que queremos ver.
 *   - almacenamos el nombre del archiov
 *   - alamacenamos el peso del archivo
 *   - verifcamos las dos cosas
 * 
 * 								https://the-internet.herokuapp.com/download
 *
 * */
public class HdescargarArchivos {
	private String directorioDescarga="C:\\Users\\mraralma\\proyectosEclipse\\cursoInicioTestNG\\descargas";
	private WebDriver driver;
	private String url="https://the-internet.herokuapp.com/download";
	By enlaceDescarga=By.cssSelector("div.example>a");

	   @BeforeClass
	   // @Parameters({"URL", "TipoNavegador"})//aqui ponemos el valor de NAME de los parameters del archivo testng.xml
	    public void beforeClass() { //aquí le agregamos los parámetros, tantos como parameters tenga el archivo testng.xml
		   ChromeOptions opcionesChrome=Descarga.configurarOpcionesChrome(directorioDescarga);
	    //ya podemos crear ChromeDriver
	    	driver=new ChromeDriver(opcionesChrome);
	    	driver.manage().window().maximize();
	    	   driver.get(url);
	      
	    }
  @Test
  public void descargarArchivo() throws InterruptedException {
	 Descarga.descargarArchivo(driver, enlaceDescarga, directorioDescarga);
	 
  }
  
  @Test
  public void verificarTipo() throws MalformedURLException, IOException {
	  //creamos la conexion http
	  String tipoArchivoDeseado="application/octet-stream";
	  Descarga.verificarTipoArchivo(driver,enlaceDescarga, tipoArchivoDeseado);
  }

  @Test
  public void verificarTamanio() throws MalformedURLException, IOException {
	  int pesoArchivoDeseado=0;
	  Descarga.verificarTamanioArchivo(driver, enlaceDescarga, pesoArchivoDeseado);
  }
  
  

  @AfterClass
  public void afterClass() {
	  //anager.mostrarResultado(result);
  	driver.quit();
  }


}
