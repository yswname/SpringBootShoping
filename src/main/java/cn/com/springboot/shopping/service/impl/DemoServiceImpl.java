package cn.com.springboot.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.mapper.SpUserMapper;
import cn.com.springboot.shopping.service.IDemoService;
@Service
@Transactional
public class DemoServiceImpl implements IDemoService {
	@Autowired
    private SpUserMapper userMapper;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(SpUser user) {
		this.userMapper.insert(user);
		String str = null;
		//str.toCharArray();
	}

	@Override
	public List<SpUser> searchAllUserList() {
		return this.userMapper.findAllUsers();
	}

}
