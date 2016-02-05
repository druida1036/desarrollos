package com.certicamara.modelo;
public enum TipoOperacion {
    CONSUL_COMAND ("C", "Lista las opciones disponibles."), 
    CERRAR ("Q","Cerrar la aplicacion."),
    MOVER_CAR("MC","Mover el Carro."),
    CONSUL_POS_CAR ("CPC","Consultar posicion actual del carro.");
 
    //Campos tipo constante   
    private final String operacion; //Operacion
    private final String descripcion; //Descripcion
 

    TipoOperacion (String operacion, String descripcion) { 
        this.operacion = operacion;
        this.descripcion = descripcion;
    } //Cierre del constructor


	public String getOperacion() {
		return operacion;
	}


	public String getDescripcion() {
		return descripcion;
	}
 


}