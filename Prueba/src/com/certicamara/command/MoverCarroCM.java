package com.certicamara.command;

import com.certicamara.modelo.TableroCaro;

public class MoverCarroCM implements Operacion {
	
	private TableroCaro tableroCaro;
	

	public MoverCarroCM(TableroCaro tableroCaro) {
		super();
		this.tableroCaro = tableroCaro;
	}


	public void ejecutar() {
		tableroCaro.moverCarro();
	}
}