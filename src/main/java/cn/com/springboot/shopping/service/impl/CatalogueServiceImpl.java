package cn.com.springboot.shopping.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.processor.CataInitEvent;
import cn.com.springboot.shopping.entity.SpCatalogue;
import cn.com.springboot.shopping.mapper.SpCatalogueMapper;
import cn.com.springboot.shopping.service.ICatalogueService;
@Service("cataService")

@Transactional
public class CatalogueServiceImpl implements ICatalogueService, ApplicationContextAware {
	@Autowired
    private SpCatalogueMapper catalogueDAO ;
	public CatalogueServiceImpl() {
		System.out.println("create .....");
	}
	@Override
	public List<SpCatalogue> searchAllCatalogues() {
		ctx.publishEvent(new CataInitEvent("在初始化分类对象...."));
		return this.catalogueDAO.findAll();
	}
	@PostConstruct
	public void init() {
		// 发布CataInitEvent事件
		//ctx.publishEvent(new CataInitEvent("在初始化分类对象...."));
		System.out.println("初始化CatalogueService对象");
	}
	private ApplicationContext ctx = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx= applicationContext;
	}

}
