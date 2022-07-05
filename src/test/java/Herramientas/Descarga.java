package Herramientas;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


/* se encarga de realizar las configuraciones en CHROME para que al pulsar en el enlace para descargar NO aparezca la ventana emergente Y se descarge el archivo directamente
 * se encarga de descargar archivos en la ubicación que le pongas
 * se encarga de comprobar que el tipo de archivo es el que le pasas por parámetro
 * comprobar que el peso del archivo NO sea menor al del indicado
 * 
 * */
public class Descarga {


	//realiza las configuraciones en Chrome y devuelve un objeto con las configuraciones para despues aplicarlas al navegado
	public static ChromeOptions configurarOpcionesChrome(String directorioDescarga) {
		   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    //cambiamos laconfiguración del navegador. Vamos a desabilitar la opción de que se abra la ventana 
		    	HashMap <String,Object> preferenciasChrome= new HashMap<String, Object>();
		    	preferenciasChrome.put("profile.default_content_settings.popups", 0);   //deshabilitar ventana
		    	preferenciasChrome.put("download.default_directory", directorioDescarga);//direccion para guardar el archivo.
		  //configuramos Chrome con las preferencias cambiadas
		    	ChromeOptions opcionesChrome=new ChromeOptions();
		    	opcionesChrome.setExperimentalOption("prefs", preferenciasChrome);
		    	return opcionesChrome;
	}


	public static  void descargarArchivo(WebDriver driver, By enlaceDescarga,String directorioDescarga) throws InterruptedException {
		  driver.findElement(enlaceDescarga).click();
		  Thread.sleep(2000);
		  
		  //vamos a almacenar todos los archivos que haya en la ruta de descarga, y verificar si está vaciá la carpeta o si contiene un archivo
		  File ficheros=new File(directorioDescarga);
		  File[] listaArchivos= ficheros.listFiles();
		  
		  assertTrue(listaArchivos.length>0, "No hay ningun archivo descargado");
		  
		  
		  
	  }
	  //verifica si el tipo de archivo que le pasamos por parametro es  de tipo  pasado por parametro
	  public static void verificarTipoArchivo(WebDriver driver,By enlaceDescarga, String tipoArchivoDeseado) throws MalformedURLException, IOException {
		  //creamos la conexion http
		  String hrefLink=driver.findElement(enlaceDescarga).getAttribute("href");
		  HttpURLConnection httpConection= (HttpURLConnection)(new URL(hrefLink).openConnection());
		  //solicitamos la cabecera del link
		  httpConection.setRequestMethod("HEAD");
		  httpConection.connect();
		  
		  String tipoArchivoObtenido=httpConection.getContentType();
		  System.out.println("contenido: " + tipoArchivoObtenido);

		  assertEquals(tipoArchivoDeseado, tipoArchivoObtenido);   //"application/octet-stream"
		
		  
	  
	  }
	  public static  void verificarTamanioArchivo(WebDriver driver, By enlaceDescarga, int pesoDeseado) throws MalformedURLException, IOException {
		  //creamos la conexion http
		  String hrefLink=driver.findElement(enlaceDescarga).getAttribute("href");
		  HttpURLConnection httpConection= (HttpURLConnection)(new URL(hrefLink).openConnection());
		  //solicitamos la cabecera del link
		  httpConection.setRequestMethod("HEAD");
		  httpConection.connect();
		  int pesoObtenido=httpConection.getContentLength();
		  System.out.println("peso " + pesoObtenido);
		  assertNotEquals(pesoDeseado, pesoObtenido);
		  
	  
	  }

}
