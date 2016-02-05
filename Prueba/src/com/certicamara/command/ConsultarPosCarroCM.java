package com.certicamara.command;

import com.certicamara.modelo.TableroCaro;

public class ConsultarPosCarroCM implements Operacion {
	
	private TableroCaro tableroCaro;
	

	public ConsultarPosCarroCM(TableroCaro tableroCaro) {
		super();
		this.tableroCaro = tableroCaro;
	}


	public void ejecutar() {
		tableroCaro.consultarPosicion();
	}
}