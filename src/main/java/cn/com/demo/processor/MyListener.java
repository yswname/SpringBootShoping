package cn.com.demo.processor;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class MyListener{// implements ApplicationListener<ApplicationEvent> {

	@EventListener(ApplicationEvent.class)
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("**********MyListener111111");
	}

}
