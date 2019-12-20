package cn.com.demo.processor;

import org.springframework.context.ApplicationEvent;

public class CataInitEvent extends ApplicationEvent {
	public CataInitEvent(Object source) {
		super(source);
	}

}
