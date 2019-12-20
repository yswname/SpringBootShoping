package cn.com.springboot.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@Service("shopCarService4DB")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShopCarServiceImpl4DB implements IShopCarService {
	@Autowired
	private SpShopCarItemMapper carDAO;
	@Autowired
	private IProductService productService;

	private int urId;

	@Override
	public void setUserId(int urId) {
		this.urId = urId;
	}

	@Override
	public void add(SpProduct pro) {
		this.add(pro, 1);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(SpProduct pro, int number) {
		if (pro != null) {
			SpShopCarItem item = this.carDAO.findItemByUrIdAndProId(urId, pro.getPrId());
			if(item == null) {
				// 没有
				item = new SpShopCarItem();
				item.setCarItNumber(number);
				item.setCarItPrId(pro.getPrId());
				item.setCarItUrId(urId);
				// 插入
				this.carDAO.insert(item);
			}else {
				item.setCarItNumber(item.getCarItNumber()+number);
				// 更新(urId+prId)
				this.carDAO.updateByPrimaryKeySelective(item);
			}
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void edit(SpProduct pro, int number) {
		if(pro != null) {
			SpShopCarItem item = this.carDAO.findItemByUrIdAndProId(urId, pro.getPrId());
			if(item == null) {
				// 没有
				item = new SpShopCarItem();
				item.setCarItNumber(number);
				item.setCarItPrId(pro.getPrId());
				item.setCarItUrId(urId);
				// 插入
				this.carDAO.insert(item);
			}else {
				item.setCarItNumber(number);
				// 更新(urId+prId)
				this.carDAO.updateByPrimaryKeySelective(item);
			}
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(SpProduct pro) {
		if(pro != null) {
			SpShopCarItem item = this.carDAO.findItemByUrIdAndProId(urId, pro.getPrId());
			this.carDAO.deleteByPrimaryKey(item.getCarItId());
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void clear() {
		this.carDAO.deleteByUrId(urId);
	}

	@Override
	public int sumCount() {
		int count = 0;
		List<SpShopCarItem> dbItems = this.carDAO.findByUrId(urId);
		if(dbItems != null) {
			for(SpShopCarItem item:dbItems) {
				count += item.getCarItNumber();
			}
		}
		return count;
	}

	@Override// 数据库中的item查询出来，封装成代码中的item
	public List<ShopCarItem> getProList() {
		List<ShopCarItem> items = null;
		
		// 查询数据库对象
		List<SpShopCarItem> dbItems = this.carDAO.findByUrId(urId);
		// 封装成ShopCarItem
		if(dbItems != null) {
			items = new ArrayList<ShopCarItem>();
			ShopCarItem item = null;
			for(SpShopCarItem dbItem:dbItems) {
				item = new ShopCarItem();
				item.setCount(dbItem.getCarItNumber());
				//item.setPro(this.productDAO.findById(dbItem.getCarItPrId()));
				SpProduct product = this.productService.searchById(dbItem.getCarItPrId());
				item.setPro(product);
				
				items.add(item);
			}
		}
		
		return items;
	}

}
