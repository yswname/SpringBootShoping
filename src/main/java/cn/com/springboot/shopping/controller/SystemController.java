package cn.com.springboot.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.service.IShopCarService;
import cn.com.springboot.shopping.service.ISystemControlService;
import cn.com.springboot.shopping.service.ShopCarItem;
import cn.com.springboot.shopping.service.impl.ShopCarServiceImpl;

/**
 * 定义系统权限控制的所有处理方法
 * 
 * @author Noble Yang
 * @version 1.0
 */
@Controller
@RequestMapping("/system")
//@SessionScope // 定义SystemController的生命周期为Session
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@SessionAttributes(value = { "LOGIN_USER", "SHOP_CAR" }) // 同步Model中 LOGIN_USER、SHOP_CAR的值到Session
public class SystemController {
	/**
	 * 购物车Service
	 */
	@Autowired
	@Qualifier("shopCarService4DB")
	private IShopCarService carService;
	/**
	 * 系统控制Service
	 */
	@Autowired
	private ISystemControlService sysService;

	/**
	 * 处理 系统登录请求的方法，登录成功，返回index.html页面，否则返回login.html页面
	 * 
	 * @param userName String 登录的用户名
	 * @param password String 登录的密码
	 * @param shopCar  IShopCarService 从session中获取的购物车对象
	 * @param model    Model SpringMVC中，用来传递数据给View显示的Model对象
	 */
	@RequestMapping(value = "/login.mvc", method = RequestMethod.POST)
	public String login(String userName, String password,
			@SessionAttribute(name = "SHOP_CAR", required = false) IShopCarService shopCar, Model model) {
		String forwardJsp = "index.html";

        // a）完成登录验证
		try {
			SpUser user = this.sysService.verify(userName, password);
            // b）成功
			if (user != null) {
				// 添加登录标记
				model.addAttribute("LOGIN_USER", user);
                // i）购物车的同步
				// IShopCarService shopCar = (IShopCarService) session.getAttribute("SHOP_CAR");
				if (shopCar != null && shopCar instanceof ShopCarServiceImpl) {
					// 1 获取以前购物车中的所有商品和数量
					List<ShopCarItem> sessionItemList = shopCar.getProList();
					// 2 创建DB购物车对象
					shopCar = this.carService;// new ShopCarServiceImpl4DB();
					shopCar.setUserId(user.getUrId());
					// 3 循环的将以前的商品和数量，添加到DB购物车
					for (ShopCarItem item : sessionItemList) {
						shopCar.add(item.getPro(), item.getCount());
					}
				} else {
					// 创建db购物车
					// 从容器中获取
					shopCar = this.carService;
					shopCar.setUserId(user.getUrId());
				}
				// 4 用DB购物车对象，替换session中的老对象
				model.addAttribute("SHOP_CAR", shopCar);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "登录失败:" + e.getMessage());
			forwardJsp = "login.html";
		}
		// ii）转向成功登录（index.html）
		forwardJsp = "redirect:../" + forwardJsp;
		return forwardJsp;
	}
}
