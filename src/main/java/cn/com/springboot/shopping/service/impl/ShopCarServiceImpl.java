package cn.com.springboot.shopping.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.service.IShopCarService;
import cn.com.springboot.shopping.service.ShopCarItem;
@Service("shopCarService4Session")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShopCarServiceImpl implements IShopCarService {
	private Map<Integer, ShopCarItem> itemMap = new HashMap<Integer, ShopCarItem>();

	@Override
	public void add(SpProduct pro) {
		// 判断以前是否有当前产品
		// 有++
		// 无 1 put
		this.add(pro, 1);
	}

	@Override
	public void add(SpProduct pro, int number) {
		if (pro != null) {
			ShopCarItem item = this.itemMap.get(pro.getPrId());
			if (item == null) {
				item = new ShopCarItem();
				item.setPro(pro);
				this.itemMap.put(pro.getPrId(), item);
			}
			item.setCount(item.getCount() + number);
		}
	}

	@Override
	public void edit(SpProduct pro, int number) {
		if (pro != null) {
			ShopCarItem item = this.itemMap.get(pro.getPrId());
			if (item == null) {
				item = new ShopCarItem();
				item.setPro(pro);
				this.itemMap.put(pro.getPrId(), item);
			}
			item.setCount(number);
		}
	}

	@Override
	public void remove(SpProduct pro) {
		if (pro != null)
			this.itemMap.remove(pro.getPrId());
	}

	@Override
	public void clear() {
		this.itemMap.clear();
	}

	@Override
	public int sumCount() {
		int count =0;
		List<ShopCarItem> items = this.getProList();
		for(ShopCarItem item:items) {
			count+=item.getCount();
		}
		return count;
	}

	@Override
	public List<ShopCarItem> getProList() {
		Collection<ShopCarItem> cls = this.itemMap.values(); 
		List<ShopCarItem> list = new ArrayList<ShopCarItem>();
		list.addAll(cls);
		return list;
	}

	@Override
	public void setUserId(int urId) {}

}
