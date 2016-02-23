package com.certicamara.eventos;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
public class CustomEventAnnotationPublisher {
	@EventListener
	@Order(2)
	public void processCustomEvent(CustomEvent customEvent){
		System.out.println("Annotated "+customEvent.toString());
		
	}

}
