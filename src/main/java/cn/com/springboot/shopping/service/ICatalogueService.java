package cn.com.springboot.shopping.service;

import java.util.List;

import cn.com.springboot.shopping.entity.SpCatalogue;

public interface ICatalogueService {
    public List<SpCatalogue> searchAllCatalogues();
}
