package cn.com.springboot.shopping.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class ApplicationContextTool implements ApplicationContextAware {
    private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
	
	public static Object getBean(String name) {
		return ctx.getBean(name);
	}
	
	public static <T> T getBean(Class<T> cls) {
		return ctx.getBean(cls);
	}

}
