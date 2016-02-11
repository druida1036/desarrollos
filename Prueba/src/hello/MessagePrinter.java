package hello;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MessagePrinter {

    final private MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }
    @PostConstruct
    public void initMethod(){
      	System.out.println("test");
      }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}