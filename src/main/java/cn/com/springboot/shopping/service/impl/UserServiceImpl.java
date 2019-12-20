package cn.com.springboot.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.mapper.SpUserMapper;
import cn.com.springboot.shopping.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
    private SpUserMapper userDAO;// = new SpUserDAOImpl();
	@Override
	public SpUser searchUser(String userName) {
		SpUser user = null;
		
		user = this.userDAO.findByUserName(userName);
		
		return user;
	}

}
