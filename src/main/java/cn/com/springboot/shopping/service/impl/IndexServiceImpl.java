package cn.com.springboot.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpCatalogue;
import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.mapper.SpCatalogueMapper;
import cn.com.springboot.shopping.service.IIndexService;
import cn.com.springboot.shopping.service.IProductService;
@Service
@Transactional
public class IndexServiceImpl implements IIndexService {
	@Autowired
	private IProductService proService;
	@Autowired
	private SpCatalogueMapper cataDAO;

	@Override
	public List<SpProduct> searchCataFirst() {
		List<SpProduct> proList = null;
		// 查询所有的类别
		List<SpCatalogue> cataList = this.cataDAO.findAll();

		if (cataList != null && cataList.size() > 0) {
			proList = new ArrayList<SpProduct>();
			for (SpCatalogue cata : cataList) {
				// 根据每个类别查询产品
				List<SpProduct> cataProList = this.proService.searchProductListByCate(cata.getCtId());
				// 获取每个类别中的第一个产品
				if(cataProList != null && cataProList.size()>0) {
					proList.add(cataProList.get(0));
				}
			}
		}
		return proList;
	}

}
