package cn.com.springboot.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.springboot.shopping.entity.SpCatalogue;
import cn.com.springboot.shopping.mapper.SpCatalogueMapper;
import cn.com.springboot.shopping.service.ICatalogueService;
@Service
@Transactional
public class CatalogueServiceImpl implements ICatalogueService {
	@Autowired
    private SpCatalogueMapper catalogueDAO ;
	@Override
	public List<SpCatalogue> searchAllCatalogues() {
		return this.catalogueDAO.findAll();
	}

}
