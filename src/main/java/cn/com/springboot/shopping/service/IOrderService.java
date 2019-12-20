package cn.com.springboot.shopping.service;

public interface IOrderService {
	/**
	 * 将指定的产品形成订单
	 * 删除已经形成订单的，购物车中的产品项
	 * */
    public void addOrder(int[] proIds, int urId);
    public void addOrder(int[] proIds, String userName);
}
