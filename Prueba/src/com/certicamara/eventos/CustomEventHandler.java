package com.certicamara.eventos;


import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class CustomEventHandler 
   implements ApplicationListener<CustomEvent>{

   public void onApplicationEvent(CustomEvent event) {
      System.out.println(event.toString());
      
   }

}