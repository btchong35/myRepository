package com.moon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.moon.entity.Category;
import com.moon.dao.CategoryMapper;

@Transactional
@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

}