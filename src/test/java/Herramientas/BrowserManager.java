package Herramientas;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * se encarga de dar las configuraciones de tamaño y posicion del navegador
 * se encarga de abrir el tipo de navegador que se le solicite
 * 
 * */
public class BrowserManager {

	public static void setWindow(WebDriver driver, String valor) {
		if(valor.toLowerCase()=="maximized") {
			driver.manage().window().maximize();
		}
		if(valor.toLowerCase()=="fullscreen") {
			driver.manage().window().fullscreen();
		}
	}
	
	
	public static void setWindow(WebDriver driver, int ancho, int alto) {
		driver.manage().window().setSize(new Dimension(ancho, alto));
	}
	
	//se ecarga de abrir un navegador según el tipo que se le ponga por parámetro
	public static WebDriver setDriverNavegador(String tipoNavegador) {
		WebDriver driver = null;
		if(tipoNavegador.equalsIgnoreCase("chrome")) {
  	 	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  	  		driver= new ChromeDriver(); 
  	 
  	}else if(tipoNavegador.equalsIgnoreCase("firefox")) {
  	 	  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
  	  		driver= new FirefoxDriver(); 
  
  	}else if(tipoNavegador.equalsIgnoreCase("InternetExplorer")) {
  		  System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
	  		driver= new InternetExplorerDriver(); 
	     
  	}
		return driver;
	}
}
