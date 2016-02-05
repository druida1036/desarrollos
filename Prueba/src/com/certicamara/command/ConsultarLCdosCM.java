package com.certicamara.command;

import com.certicamara.modelo.TipoOperacion;

public class ConsultarLCdosCM implements Operacion {

	public void ejecutar() {
		for (TipoOperacion operacion : TipoOperacion.values()) {
			System.out.println(operacion.getOperacion() + " - "
					+ operacion.getDescripcion());
		}
	}
}