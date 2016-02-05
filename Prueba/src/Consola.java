import java.util.Scanner;

import com.certicamara.command.Operacion;
import com.certicamara.command.OperacionFactory;
import com.certicamara.modelo.TableroCaro;


public class Consola {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isQuit = true;
		sc = new Scanner(System.in);
		
		while (isQuit){
			 System.out.println("Por favor ingrese un comando");//Se pide un dato al usuario  
		     String comando = sc.nextLine(); //Se lee el nombre con nextLine() que retorna un String con el dato
		     TableroCaro abcStock = new TableroCaro();
		     procesarComando(comando, abcStock);
		     isQuit = abcStock.isConsolaEjecutando();
		}
		 
	        
	       
	}

	public static void procesarComando(String comando, TableroCaro abcStock) {
		OperacionFactory operacionFactory = new OperacionFactory();
		Operacion order = operacionFactory.getOperacion(comando.trim().toUpperCase(), abcStock);
		if (order != null) {
			order.ejecutar();
	      }
	}

}
