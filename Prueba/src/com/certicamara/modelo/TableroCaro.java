package com.certicamara.modelo;

public class TableroCaro {

	private boolean consolaEjecutando = true;
	private int xPosicion = 0;
	private int yPosicion = 0;
	private int xMaxPosicion = 10;
	private int yMaxPosicion = 10;
	private String instruccion;
	private Integer deltax;
	private Integer deltay;

	public void consultarPosicion() {
		System.out.println(" Fila: " + xPosicion + ", Columna: " + yPosicion);
	}

	public void moverCarro() {
		validarInstruccion(instruccion, TipoInstruccion.BASE);
		consultarPosicion();
	}
	
	public void asignarMaxFilas(){
		String[] temp = instruccion.split(TipoInstruccion.BASE.getInstruccion());
		int filas;
		if (temp.length == 2) {
			try {
				filas = Integer.parseInt(temp[1].trim());
				xMaxPosicion = filas;
			} catch (NumberFormatException e) {
				publicarMensajeError();
			}
		} else {
			publicarMensajeError();
		}
	}
	
	public void asignarMaxColumnas(){
		String[] temp = instruccion.split(TipoInstruccion.BASE.getInstruccion());
		int columnas;
		if (temp.length == 2) {
			try {
				columnas = Integer.parseInt(temp[1].trim());
				yMaxPosicion = columnas;
			} catch (NumberFormatException e) {
				publicarMensajeError();
			}
		} else {
			publicarMensajeError();
		}
	}
	private void validarInstruccion(String instruccion,
			TipoInstruccion tipoInstruccion) {
		String[] temp = instruccion.split(tipoInstruccion.getInstruccion());
		if (tipoInstruccion == TipoInstruccion.BASE) {
			if (temp.length == 2) {
				validarInstruccion(temp[1], TipoInstruccion.C_CORDENADA);
			} else {
				publicarMensajeError();
			}
		} else if (tipoInstruccion == TipoInstruccion.C_CORDENADA) {
			for (String cordenada : temp) {
				validarInstruccion(cordenada, TipoInstruccion.CORDENADA);
			}
		} else if (tipoInstruccion == TipoInstruccion.CORDENADA) {// temp.length
																	// > 1
			if (procesarCoordenada(temp)) {
				applicarCordenada();
			}

		} else {
			publicarMensajeError();
		}

	}

	private void applicarCordenada() {

		System.out.println("Instrucion: " + instruccion
				+ " Cordenada: " + deltax + deltay);
		if (xPosicion + deltax <= xMaxPosicion) {
			xPosicion = xPosicion + deltax;
		} else if (xPosicion + deltax > xMaxPosicion) {
			xPosicion = xPosicion + (xMaxPosicion - xPosicion);
			System.out.println("Se ha detenido el avance por salir de los l�mites");
		}
		
		if (yPosicion + deltay <= yMaxPosicion) {
			yPosicion = yPosicion + deltay;
		} else if (yPosicion + deltay > yMaxPosicion) {
			yPosicion = yPosicion + (yMaxPosicion - yPosicion);
			System.out.println("Se ha detenido el avance por salir de los l�mites");
		}

	}

	private boolean procesarCoordenada(String[] temp) {
		boolean cordenadaValida = false;
		if (temp.length == 2) {

			try {
				deltax = Integer.parseInt(temp[0]);
				deltay = deltax;
				switch (temp[1]) {
				case "N":
					deltax = 0;
					cordenadaValida = true;
					break;
				case "S":
					deltay = deltay * -1;
					deltax = 0;
					cordenadaValida = true;
					break;
				case "E":
					deltay = 0;
					cordenadaValida = true;
					break;
				case "O":
					deltax = deltax * -1;
					deltay = 0;
					cordenadaValida = true;
					break;
				default:
					publicarMensajeError();
					cordenadaValida = false;
					break;
				}

			} catch (NumberFormatException e) {
				cordenadaValida = false;
				publicarMensajeError();
			}

		} else {
			cordenadaValida = false;
			publicarMensajeError();

		}
		return cordenadaValida;
	}

	private void publicarMensajeError() {
		System.out.println("Hay un error en la instruccion");

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