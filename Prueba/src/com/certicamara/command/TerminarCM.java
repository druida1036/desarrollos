package com.certicamara.command;

import com.certicamara.modelo.TableroCaro;


public class TerminarCM implements Operacion {
   private TableroCaro abcStock;

   public TerminarCM(TableroCaro abcStock){
      this.abcStock = abcStock;
   }

   public void ejecutar() {
      abcStock.setConsolaEjecutando(false);
      System.out.println("Programa terminado");
   }
}