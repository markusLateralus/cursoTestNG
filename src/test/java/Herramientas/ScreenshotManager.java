package Herramientas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * 
 * es encargada de realizar capturas de pantallas y almacenarlas
 * 
 * 
 * */
public class ScreenshotManager {
	
	
	public static void hacerCapturaPantalla(WebDriver driver, String titulo) {
		  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("./archivos generados/"+titulo +" " + System.currentTimeMillis()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
