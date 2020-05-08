package com.moon.service;

import com.moon.utils.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.moon.entity.Product;
import com.moon.dao.ProductMapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Transactional
@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public MyPage<Product> selectByCategory(int categoryId,int pagenum,int pagesize){
		Example exampl=new Example(Product.class);
		Criteria crx=exampl.createCriteria();
		crx.andCondition("status!=", 0);
		if(categoryId!=0){
			crx.andCondition("categoryid=", categoryId);
		}
		return MyPage.selectByExampleAndPage(productMapper, exampl, pagenum, pagesize);
	}

	public MyPage<Product> selectByKeyword(String keyword,int pagenum,int pagesize){
		Example example=new Example(Product.class);
		Criteria crx=example.createCriteria();
		if(keyword!=null&&keyword!=""){
			crx.andCondition("productname like", "%"+keyword+"%");
		}
		return MyPage.selectByExampleAndPage(productMapper, example, pagenum, pagesize);
	}
}