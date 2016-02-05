package com.certicamara.command;

import com.certicamara.modelo.TableroCaro;

public class AsignarMaxColumnasCM implements Operacion {
	
	private TableroCaro tableroCaro;
	

	public AsignarMaxColumnasCM(TableroCaro tableroCaro) {
		super();
		this.tableroCaro = tableroCaro;
	}


	public void ejecutar() {
		tableroCaro.asignarMaxFilas();
	}
}