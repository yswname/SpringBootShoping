package cn.com.springboot.shopping.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.springboot.shopping.SpringBootShopping.SpringBootShoppingApplication;
import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.service.IDemoService;

@SpringBootTest(classes = SpringBootShoppingApplication.class)
public class TestDemoServiceImpl {
	@Autowired
    private IDemoService demoService;
	
	@Test
	public void testAddUser() {
		SpUser user = new SpUser();
		user.setUrPassword("123");
		user.setUrUserName("boot03");
		
		this.demoService.addUser(user);
	}
	@Test
	public void testSearchAllUserList() {
		List<SpUser> userList = this.demoService.searchAllUserList();
		assertTrue(userList.size()>0);
	}
}
