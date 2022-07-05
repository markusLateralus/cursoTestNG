package Herramientas;

import org.testng.ITestResult;

public class ResultManager {

	
	public static void mostrarResultado(ITestResult result) {
		 System.out.println("metodo: " + result.getMethod().getMethodName() + ", " + result.getMethod().getDescription() + ", el estado es: " +result.getStatus()+
	  			  ", tiempo en ser invocado: "+ result.getMethod().getInvocationTimeOut() + ", prioridad: " + result.getMethod().getPriority() +
	  			   ", esta enabled?: " + result.getMethod().getEnabled() + ", total de veces invocado: " + result.getMethod().getInvocationCount()+
	  			   ", porcentaje éxito: " + result.getMethod().getSuccessPercentage() + "%.");
	}
}
