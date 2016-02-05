package com.certicamara.modelo;

public class TableroCaro {

	private boolean consolaEjecutando = true;
	private int xPosicion = 0;
	private int yPosicion = 0;
	private int xMaxPosicion;
	private int yMaxPosicion;
	private String instruccion;

	public void consultarPosicion() {
		System.out.println(" Fila: " + xPosicion + ", Columna: " + yPosicion);
	}

	public void moverCarro() {
		validarInstruccion(instruccion, TipoInstruccion.BASE);
		consultarPosicion();
	}

	private void validarInstruccion(String instruccion, TipoInstruccion tipoInstruccion) {
		String[] temp = instruccion.split(tipoInstruccion.getInstruccion());
		if (tipoInstruccion == TipoInstruccion.BASE) {
			if (temp.length == 2) {
				validarInstruccion(temp[1], TipoInstruccion.C_CORDENADA);
			} else {
				System.out.println("Hay un error en la instruccion");
			}
		} else if (tipoInstruccion == TipoInstruccion.C_CORDENADA) {
			for (String cordenada : temp) {
				validarInstruccion(cordenada, TipoInstruccion.CORDENADA);
			}
		} else if (tipoInstruccion == TipoInstruccion.CORDENADA) {// temp.length
																	// > 1

			if (temp.length != 2) {
				System.out.println("Hay un error en la instruccion");
			} else {
				System.out.println("Instrucion: " + instruccion);
			}

			// validarInstruccion(temp[1], TipoInstruccion.C_CORDENADA);

		} else {
			System.out.println("Hay un error en la instruccion");
		}

	}

	public boolean isConsolaEjecutando() {
		return consolaEjecutando;
	}

	public void setConsolaEjecutando(boolean consolaEjecutando) {
		this.consolaEjecutando = consolaEjecutando;
	}

	public int getxPosicion() {
		return xPosicion;
	}

	public void setxPosicion(int xPosicion) {
		this.xPosicion = xPosicion;
	}

	public int getyPosicion() {
		return yPosicion;
	}

	public void setyPosicion(int yPosicion) {
		this.yPosicion = yPosicion;
	}

	public int getxMaxPosicion() {
		return xMaxPosicion;
	}

	public void setxMaxPosicion(int xMaxPosicion) {
		this.xMaxPosicion = xMaxPosicion;
	}

	public int getyMaxPosicion() {
		return yMaxPosicion;
	}

	public void setyMaxPosicion(int yMaxPosicion) {
		this.yMaxPosicion = yMaxPosicion;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
}