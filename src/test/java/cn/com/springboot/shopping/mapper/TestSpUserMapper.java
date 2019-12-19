package cn.com.springboot.shopping.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.springboot.shopping.SpringBootShopping.SpringBootShoppingApplication;
import cn.com.springboot.shopping.entity.SpUser;

@SpringBootTest(classes = SpringBootShoppingApplication.class)
public class TestSpUserMapper {
	@Autowired
	private SpUserMapper userMapper;
	@Test
	public void testSelectByPrimaryKey() {
		SpUser user = this.userMapper.selectByPrimaryKey(1);
		assertNotNull(user);
	}
	@Test
	public void testInsert() {
		SpUser user = new SpUser();
		user.setUrPassword("abc");
		user.setUrUserName("springboot01");
		
		this.userMapper.insert(user);
	}
}
