package cn.com.springboot.shopping.service;

import java.io.Serializable;
import java.util.List;

import cn.com.springboot.shopping.entity.SpProduct;

public interface IShopCarService extends Serializable{
	// session中的购物车
    public void add(SpProduct pro);
    public void add(SpProduct pro, int number);
    public void edit(SpProduct pro, int number);
    public void remove(SpProduct pro);
    public void clear();
    public int sumCount();
    public List<ShopCarItem> getProList();
    public void setUserId(int urId);
}
