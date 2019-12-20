package cn.com.springboot.shopping.service;

import cn.com.springboot.shopping.entity.SpProduct;

public class ShopCarItem {
	private SpProduct pro;
	private int count;

	public SpProduct getPro() {
		return pro;
	}

	public void setPro(SpProduct pro) {
		this.pro = pro;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
