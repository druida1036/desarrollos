package com.certicamara.command;

import com.certicamara.modelo.TableroCaro;

public class AsignarMaxFilasCM implements Operacion {
	
	private TableroCaro tableroCaro;
	

	public AsignarMaxFilasCM(TableroCaro tableroCaro) {
		super();
		this.tableroCaro = tableroCaro;
	}


	public void ejecutar() {
		tableroCaro.asignarMaxColumnas();
	}
}