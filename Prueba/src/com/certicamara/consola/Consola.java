package com.certicamara.consola;
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
		boolean consolaEjecutando = true;
		sc = new Scanner(System.in);
		TableroCaro tableroCaro = new TableroCaro();
		while (consolaEjecutando){
			 System.out.println("Por favor ingrese un comando");//Se pide un dato al usuario  
		     String comando = sc.nextLine(); //Se lee el nombre con nextLine() que retorna un String con el dato
		     procesarComando(comando, tableroCaro);
		     consolaEjecutando = tableroCaro.isConsolaEjecutando();
		}
		 
	        
	       
	}

	public static void procesarComando(String comando, TableroCaro tableroCaro) {
		OperacionFactory operacionFactory = new OperacionFactory();
		Operacion order = operacionFactory.getOperacion(comando.trim().toUpperCase(), tableroCaro);
		if (order != null) {
			order.ejecutar();
	      }
	}

}
