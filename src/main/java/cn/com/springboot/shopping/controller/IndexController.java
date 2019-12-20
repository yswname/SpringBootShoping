package cn.com.springboot.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import cn.com.springboot.shopping.entity.SpCatalogue;
import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.service.ICatalogueService;
import cn.com.springboot.shopping.service.IIndexService;
import cn.com.springboot.shopping.service.IShopCarService;
import cn.com.springboot.shopping.service.ShopCarItem;
/**
 * 定义 处理首页请求的方法
 * 
 * @author Noble Yang
 * @version 1.0
 * */
@Controller
@RequestMapping("/index")
public class IndexController {
	/**
	 * 商品分类Service
	 * */
	@Autowired
	private ICatalogueService catalogueService;
	/**
	 * 首页功能Service
	 * */
	@Autowired
	private IIndexService indexService;
	
	/**
	 * 首页上显示购物车列表请求处理方法，返回购物车中的商品列表页面
	 * 
	 * @param shopCar IShopCarService Session中的购物车对象
	 * @param type String 购物车商品列表请求种类：1、结算时显示的商品列表；default、在页面右上角动态显示的商品列表
	 * @param mode Mode SpringMVC中用户给view传递数据的Model对象
	 * 
	 * @return String viewName(shopCarItemList.jsp or jsShopCarItemList.jsp)
	 * */
	@RequestMapping("/shopCarItemList.mvc")
	public String shopCarItemList(
			@SessionAttribute(name="SHOP_CAR", required=false) IShopCarService shopCar, 
			String type, 
			Model model) {
		String result = "shopCarItemList";

		if (shopCar != null) {
			// 获取购物车中的购物车项列表
			List<ShopCarItem> items = shopCar.getProList();
			// 将购物车项列表添加到model中
			model.addAttribute("itemList", items);
			// 如果购物车项不为控，就在model中添加商品数量
			if (items != null)
				model.addAttribute("itemSize", items.size());
		}

		// 如果type为1，返回jsShopCarItemList.jsp，否则返回shopCarItemList.jsp
		if ("1".equals(type)) {
			result = "jsShopCarItemList";
		}
		
		return result;
	}
	
	/**
	 * 处理首页上请求商品列表的方法，返回商品列表页面
	 * 
	 * @param model Model SpringMVC中用户给view传递数据的Model对象
	 * 
	 * @return String viewName(视图名称 indexCataList.jsp)
	 * */
	@RequestMapping("/indexCataList.mvc")
	public String indexCataList(Model model) {
		// 调用分类Service，查询分类列表
		List<SpCatalogue> cataList = this.catalogueService.searchAllCatalogues();
		// 添加分类列表到Model，以便页面显示
		model.addAttribute("cataList", cataList);
		// 返回viewName，转向indexCataList.jsp
		return "indexCataList";
	}

	/**
	 * 处理首页上请求商品列表方法，返回首页上显示的商品列表页面
	 * 
	 * @param model Model SpringMVC中用户给view传递数据的Model对象
	 * 
	 * @return String viewName(视图名称 indexProList.jsp)
	 * */
	@RequestMapping("/indexProList.mvc")
	public String indexProList(Model model) {
		// 获取每类的第一个产品集合
		List<SpProduct> proList = this.indexService.searchCataFirst();
		// 设置到request中
		model.addAttribute("firstProList", proList);
		return "indexProList";
	}
}
