package cn.com.springboot.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.mapper.SpProductMapper;
import cn.com.springboot.shopping.service.IProductService;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
    private SpProductMapper proDao ;

	@Override
	public SpProduct searchById(int prId) {
		SpProduct pro = this.proDao.selectByPrimaryKey(prId);
		return pro;
	}


	@Override
	public List<SpProduct> searchProductListByCate(int cataId) {
		List<SpProduct> proList = null;
		proList = this.proDao.findProListByCataId(cataId);
		return proList;
	}

}
