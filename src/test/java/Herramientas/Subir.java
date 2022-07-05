package Herramientas;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Subir {
	
	
	  public static void subirArchivo(WebDriver driver, By localizadorBuscarDirectorio, By localizadorBotonCargar, By localizadorMensajeCarga, String archivoSubir) {
		  //String archivoSubir="C:\\Users\\mraralma\\proyectosEclipse\\cursoInicioTestNG\\descargas\\1646460734364.png";
		  File archivo=new File(archivoSubir);
		  String path=archivo.getAbsolutePath();
		  driver.findElement(localizadorBuscarDirectorio).sendKeys(path);
		  driver.findElement(localizadorBotonCargar).click();
		  //verificar que se ha subido
		  String textoObtenido=driver.findElement(localizadorMensajeCarga).getText();
		  String textoEsperado="1646460734364.png";
		  assertEquals(textoObtenido, textoEsperado);
		  
	  }


}
