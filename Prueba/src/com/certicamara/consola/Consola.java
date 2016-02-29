package com.certicamara.consola;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.certicamara.command.Operacion;
import com.certicamara.eventos.CustomEventHandler;
import com.certicamara.eventos.CustomEventPublisher;
import com.certicamara.modelo.TableroCaro;
import com.certicamara.modelo.Vehiculo;


public class Consola {

	private static Scanner sc;
	private static ClassPathXmlApplicationContext context;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean consolaEjecutando = true;
		sc = new Scanner(System.in);
	    context = new ClassPathXmlApplicationContext("com/certicamara/confg/applicationContext.xml");
	    Vehiculo vehiculo = context.getBean(Vehiculo.class);
//	    context.getEnvironment().setActiveProfiles("dev");
//	    context.refresh();
	    CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
	    publisher.publish();
//	    context.getBean("&tableroCaro");
		TableroCaro tableroCaro = context.getBean(TableroCaro.class);
		while (consolaEjecutando){
			 System.out.println("Por favor ingrese un comando");//Se pide un dato al usuario  
		     String comando = sc.nextLine(); //Se lee el nombre con nextLine() que retorna un String con el dato
		     procesarComando(comando, tableroCaro);
		     consolaEjecutando = tableroCaro.isConsolaEjecutando();
		}
		 
	        
	       
	}

	public static void procesarComando(String comando, TableroCaro tableroCaro) {
		tableroCaro.setInstruccion(comando.trim().toUpperCase());
		Operacion order = context.getBean(Operacion.class);
		if (order != null) {
			order.ejecutar();
	      }
	}

}
