package com.certicamara.command;
import com.certicamara.modelo.TableroCaro;
import com.certicamara.modelo.TipoOperacion;

public class OperacionFactory {

	// use getOrder method to get object of type Order
	public Operacion getOperacion(String comando, TableroCaro tableroCaro) {
		if (comando == null) {
			return null;
		}
		if (comando.equalsIgnoreCase(TipoOperacion.CONSUL_COMAND.getOperacion())) {
			return new ConsultarLCdosCM();

		} else if (comando.equalsIgnoreCase(TipoOperacion.CERRAR.getOperacion())) {
			return new TerminarCM(tableroCaro);

		} else if (comando.equalsIgnoreCase(TipoOperacion.CONSUL_POS_CAR.getOperacion())) {
			return new ConsultarPosCarroCM(tableroCaro);
			
		} else if (comando.startsWith(TipoOperacion.MOVER_CAR.getOperacion())) {
			tableroCaro.setInstruccion(comando);
			return new MoverCarroCM(tableroCaro);	
		}else{
			return new OperacionIndefinidaCM();
		}

	}
}