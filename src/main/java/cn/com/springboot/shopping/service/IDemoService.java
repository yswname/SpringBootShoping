package cn.com.springboot.shopping.service;

import java.util.List;

import cn.com.springboot.shopping.entity.SpUser;

public interface IDemoService {
    public void addUser(SpUser user);
    public List<SpUser> searchAllUserList();
}
