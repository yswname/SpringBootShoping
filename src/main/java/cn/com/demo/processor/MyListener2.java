package cn.com.demo.processor;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class MyListener2 {
	@EventListener(CataInitEvent.class)
    public void hell(CataInitEvent event) {
    	System.out.println("************hello.....");
    }
}
