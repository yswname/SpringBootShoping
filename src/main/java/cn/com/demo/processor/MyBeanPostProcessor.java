package cn.com.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.com.springboot.shopping.service.impl.CatalogueServiceImpl;
@Component
@Order(1)
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof CatalogueServiceImpl) {
			System.out.println("***********postProcessBeforeInitialization");
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof CatalogueServiceImpl) {
			System.out.println("***********postProcessAfterInitialization");
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
