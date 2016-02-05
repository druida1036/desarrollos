package com.certicamara.modelo;
public enum TipoInstruccion {
    BASE(" "), 
    C_CORDENADA (";"),
    CORDENADA(",");

 
    private TipoInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	//Campos tipo constante   
    private final String instruccion; //Operacion

	public String getInstruccion() {
		return instruccion;
	}
 

  


}