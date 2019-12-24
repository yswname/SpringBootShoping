package cn.com.springboot.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import cn.com.springboot.shopping.entity.SpProduct;
import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.service.IProductService;
import cn.com.springboot.shopping.service.IShopCarService;
import cn.com.springboot.shopping.service.ShopCarItem;
import cn.com.springboot.shopping.service.impl.ShopCarServiceImpl;

/**
 * 定义所有操作购物车请求的方法
 * 
 * @author Noble Yang
 * @version 1.0
 */
@Controller
@RequestMapping("/car")
//@SessionScope // 定义控制器的作用域为Session
@SessionAttributes(value = { "SHOP_CAR" }) // 同步model中的SHOP_CAR到Session
public class ShopCarController {
	/**
	 * 产品Service
	 */
	@Autowired
	private IProductService proService;
	/**
	 * Session版购物车对象
	 */
	@Autowired
	@Qualifier("shopCarService4Session")
	private IShopCarService shopCar4Session;
	/**
	 * 数据库版购物车对象
	 */
	@Autowired
	@Qualifier("shopCarService4DB")
	private IShopCarService shopCar4Db;

	/**
	 * 处理显示购物车中商品数量请求的方法，返回购物车中的商品数量
	 * 
	 * @param shopCar IShopCarService session中获取的购物车对象
	 * 
	 * @return int 购物车中的商品数量。如果购物车不存在，数量为0
	 */
	@RequestMapping("/showShopCarProductCount.mvc")
	@ResponseBody
	public int showProductCount(@SessionAttribute(name = "SHOP_CAR", required = false) IShopCarService shopCar) {
		int count = 0;
		// 获取数量
		if (shopCar != null) {
			// 获取购物车中的商品数量
			count = shopCar.sumCount();
		}
		return count;
	}

	/**
	 * 处理 显示购物车列表请求 方法，返回购物车中的商品列表页面
	 * 
	 * @param shopCar IShopCarService Session中的购物车对象
	 * @param type    String 购物车商品列表请求种类：1、结算时显示的商品列表；default、在页面右上角动态显示的商品列表
	 * @param mode    Mode SpringMVC中用户给view传递数据的Model对象
	 * 
	 * @return String viewName(shopCarItemList.jsp or jsShopCarItemList.jsp)
	 */
	@RequestMapping("/shopCarItemList.mvc")
	public String shopCarItemList(@SessionAttribute(name = "SHOP_CAR", required = false) IShopCarService shopCar,
			String type, Model model) {
		String viewName = "shopCarItemList";
		if (shopCar != null) {
			// 获取购物车中的购物车项列表
			List<ShopCarItem> items = shopCar.getProList();
			// 将购物车项列表添加到model中
			model.addAttribute("itemList", items);
			// 如果购物车项不为空，就在model中添加商品数量
			if (items != null)
				model.addAttribute("itemSize", items.size());
		}
		// 如果type为1，返回jsShopCarItemList.jsp，否则返回shopCarItemList.jsp
		if ("1".equals(type)) {
			viewName = "jsShopCarItemList";
		}
		return viewName;
	}

	/**
	 * 处理 添加购物车请求的方法, 返回添加购物车后的成功或失败的提示信息
	 * 
	 * @param user SpUser 从session中获取的当前登录的用户对象（登录成功后，设置在session中的登录标记）
	 * @param shopCar IShopCarService 从session中获取的购物车对象
	 * @param proId int 需要添加到购物车中去的商品的id
	 * @param proNumber int 需要添加到购物车中去的商品的数量，缺省值为1
	 * @param model Model SpringMVC中的Model对象，用来传递数据给View显示
	 * 
	 * @return String 添加成功或失败后的提示信息
	 */
	@RequestMapping("/addShopCar.mvc")
	@ResponseBody
	public String addShopCar(
			@SessionAttribute(name = "LOGIN_USER", required = false) SpUser user,
			@SessionAttribute(name = "SHOP_CAR", required = false) IShopCarService shopCar,
			@RequestParam(name = "prId", defaultValue = "0") int proId,
			@RequestParam(name = "number", defaultValue = "1") int proNumber,
			Model model) {
		String response = null;
		try {
			// 根据是否登录等情况，获取对应的ShopCar（Session Car or DataBase Car）
			IShopCarService car = this.getShopCar(user, shopCar);
			model.addAttribute("SHOP_CAR", car);

			// 调用后面的service获取id对应的产品对象
			SpProduct product = this.proService.searchById(proId);
			// 调用ShopCar的方法
			car.add(product, proNumber);
			response = "添加成功";
		} catch (Exception e) {
			e.printStackTrace();
			response = "添加失败:" + e.getMessage();
		}
		return response;
	}

	/**
	 * 根据是否登录等情况，获取对应的ShopCar（Session Car or DataBase Car）
	 */
	private IShopCarService getShopCar(SpUser user, IShopCarService shopCar) {
		IShopCarService car = shopCar;

		if (user == null) {
			car = this.shopCar4Session;
		} else {
			if (shopCar == null || shopCar instanceof ShopCarServiceImpl) {
				car = this.shopCar4Db;
				// 设置用户Id
				car.setUserId(user.getUrId());
			}
		}

		return car;
	}

}
