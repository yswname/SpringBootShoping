package cn.com.springboot.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.springboot.shopping.entity.SpUser;
import cn.com.springboot.shopping.service.IDemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private IDemoService demoService;
    @RequestMapping(value="/register", method=RequestMethod.GET)
	public String regPage() {
		return "register";
	}
    @RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(SpUser user) {
    	System.out.println("**********" + user);
		String result = null;
		try {
			demoService.addUser(user);
			result = "forward:/demo/searchUsers";
		} catch (Exception e) {
			e.printStackTrace();
			result = "redirect:/demo/register";
		}
		return result;
	}
    @RequestMapping("/searchUsers")
    public String searchUserList(Model model) {
    	List<SpUser> userList = this.demoService.searchAllUserList();
    	model.addAttribute("userList", userList);
    	return "userList";
    }
}
