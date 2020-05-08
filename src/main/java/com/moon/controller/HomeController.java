package com.moon.controller;

import com.moon.entity.Category;
import com.moon.model.SysUser;
import com.moon.service.CategoryService;
import com.moon.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.moon.utils.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController extends BaseController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/")
	public String home() {
		return "demo/home";
	}

	@RequestMapping("/openWork/{work}")
	public String openWork(@PathVariable("work") String work) {
		return "demo/" + work;
	}

	@RequestMapping({"/success","/info"})
	public String success() {
		return "demo/success";
	}

	@RequestMapping("/test")
	public String testPage(){
	    return "demo/test";
    }

    @RequestMapping("/uploadView")
    public String uploadPage(HttpServletRequest request,Model model){
		String token=super.getCookieVal(request, "token");
		SysUser user= JwtUtils.getObject(token, SysUser.class);
		model.addAttribute("user", user);
		List<Category> categoryList=categoryService.getCategoryMapper().selectAll();
		model.addAttribute("catelist", categoryList);
		return "demo/upload";
	}

}