package com.certicamara.command;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

import com.certicamara.modelo.TableroCaro;
import com.certicamara.modelo.TipoOperacion;

public class OperacionFactory implements InitializingBean {
	
	public void init(){
		System.out.println("bean init factory");
	}

	// use getOrder method to get object of type Order
	public Operacion getOperacion(TableroCaro tableroCaro) {
		String comando = tableroCaro.getInstruccion();

		if (comando.equalsIgnoreCase(TipoOperacion.CONSUL_COMAND.getOperacion())) {
			return new ConsultarLCdosCM();

		} else if (comando.equalsIgnoreCase(TipoOperacion.CERRAR.getOperacion())) {
			return new TerminarCM(tableroCaro);

		} else if (comando.equalsIgnoreCase(TipoOperacion.CONSUL_POS_CAR.getOperacion())) {
			return new ConsultarPosCarroCM(tableroCaro);
			
		} else if (comando.startsWith(TipoOperacion.MOVER_CAR.getOperacion())) {
			tableroCaro.setInstruccion(comando);
			return new MoverCarroCM(tableroCaro);
		} else if (comando.startsWith(TipoOperacion.ASIGNAR_FILAS.getOperacion())) {
			tableroCaro.setInstruccion(comando);
			return new AsignarMaxFilasCM(tableroCaro);
		} else if (comando.startsWith(TipoOperacion.ASIGNAR_COLUMNAS.getOperacion())) {
			tableroCaro.setInstruccion(comando);
			return new AsignarMaxColumnasCM(tableroCaro);	
		}else{
			return new OperacionIndefinidaCM();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method");
		
	}
	
	@PostConstruct
	public void inicio1 (){
		System.out.println("postconstructor method");
	}
	

	public void inicio (){
		System.out.println("default init method");
	}
}