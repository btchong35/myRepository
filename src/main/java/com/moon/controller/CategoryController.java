package com.moon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.moon.utils.BaseController;
import com.moon.entity.Category;
import com.moon.service.CategoryService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/moon/Category")
public class CategoryController extends BaseController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping("/findAll")
	public List<Category> getCateList(){
		List<Category> cateList=categoryService.getCategoryMapper().selectAll();
		return cateList;
	}

}