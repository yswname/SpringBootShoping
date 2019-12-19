package cn.com.springboot.shopping.SpringBootShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages= {"cn.com.springboot.shopping.controller"})
public class SpringBootShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShoppingApplication.class, args);
	}

}
