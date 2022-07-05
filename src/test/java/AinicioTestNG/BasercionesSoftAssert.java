package AinicioTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

/*    SoftAssert
 * Se utiliza para cuando hay varios assert incluidos en un método, en caso de que falle un assert la prueba continua haciendo assert y no se para;
 * 
 * */



public class BasercionesSoftAssert {
	

  @Test
  public void conSoftAssert() {
	  int a=5;
	  int b=5;
	  int c=0;
	SoftAssert softAssert=new SoftAssert();
	System.out.println("en caso de que falle un assert, la prueba continua");
	softAssert.assertEquals(a,5, "a debe valer 5");
	softAssert.assertEquals(c, 2, "c debe valer 0");  // En caso de ser falso, y continua con la siguiente assert.
	softAssert.assertEquals(a,c, "a y c deben ser iguales");// también es falso, y continua la prueba
	softAssert.assertAll();
  }
  
  @Test
  public void sinSoftAssert() {
	  System.out.println("en caso de que falle un assert, la prueba finaliza");
	  int a=5;
	  int b=5;
	  int c=0;
	  Assert.assertEquals(a,5, "a debe valer 5");
	  Assert.assertEquals(c,0, "c debe valer 0"); // En caso de ser falso  la prueba se para.
	  Assert.assertEquals(a,c, "a y c deben ser iguales"); //este linea no se ejecutará
  }
  
 

}
