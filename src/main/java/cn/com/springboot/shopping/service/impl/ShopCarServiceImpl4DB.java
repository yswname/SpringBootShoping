package cn.com.springboot.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.entity.SpShopCarItem;
import cn.com.springboot.shopping.mapper.SpShopCarItemMapper;
import cn.com.springboot.shopping.service.IProductService;
import cn.com.springboot.shopping.service.IShopCarService;
import cn.com.springboot.shopping.service.ShopCarItem;
import cn.com.springboot.shopping.utils.ApplicationContextTool;
@Service("shopCarService4DB")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShopCarServiceImpl4DB implements IShopCarService {
//	@Autowired
//	private SpShopCarItemMapper carDAO;
//	@Autowired
//	private IProductService productService;

	private int urId;

	@Override
	public void setUserId(int urId) {
		this.urId = urId;
	}

	@Override
	public void add(SpProduct pro) {
		add(pro, 1);
	}

	@Override
	public void add(SpProduct pro, int number) {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		shopCar.add(pro, number);
	}

	@Override
	public void edit(SpProduct pro, int number) {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		shopCar.edit(pro, number);
	}

	@Override
	public void remove(SpProduct pro) {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		shopCar.remove(pro);
	}

	@Override
	public void clear() {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		shopCar.clear();
	}

	@Override
	public int sumCount() {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		return shopCar.sumCount();
	}

	@Override// 数据库中的item查询出来，封装成代码中的item
	public List<ShopCarItem> getProList() {
		IShopCarService shopCar = (IShopCarService)ApplicationContextTool.getBean("ShopCarServiceImpl4DBAdapter");
		shopCar.setUserId(this.urId);
		return shopCar.getProList();
	}

}
