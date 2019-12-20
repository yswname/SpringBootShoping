package cn.com.springboot.shopping.service;

import java.util.List;

import cn.com.springboot.shopping.entity.SpProduct;

public interface IProductService {
    public List<SpProduct> searchProductListByCate(int cataId);
    public SpProduct searchById(int prId);
}
