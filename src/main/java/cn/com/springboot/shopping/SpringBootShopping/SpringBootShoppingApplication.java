package cn.com.springboot.shopping.SpringBootShopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages= {"cn.com.springboot.shopping.controller",
		                      "cn.com.springboot.shopping.service",
		                      "cn.com.demo.processor"})
@MapperScan(basePackages= {"cn.com.springboot.shopping.mapper"})
public class SpringBootShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShoppingApplication.class, args);
	}

}
