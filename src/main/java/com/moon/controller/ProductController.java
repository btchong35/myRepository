package com.moon.controller;

import com.moon.entity.Category;
import com.moon.service.CategoryService;
import com.moon.utils.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.moon.utils.BaseController;
import com.moon.entity.Product;
import com.moon.service.ProductService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * sdfsdfdsf
 */
@Controller
@RequestMapping("/moon/Product")
public class ProductController extends BaseController {

    @Value("${upload.dir}")
    private String uploaddir;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/selectByCategory")
    @ResponseBody
    public MyPage<Product> selectByCategory(int categoryid, int pagenum, int pagesize) {
        return productService.selectByCategory(categoryid, pagenum, pagesize);
    }

    @RequestMapping("/selectByKeyword")
    @ResponseBody
    public MyPage<Product> selectByKeyword(String keyword,int pagenum,int pagesize){
        MyPage<Product> myPage=productService.selectByKeyword(keyword, pagenum, pagesize);
        return myPage;
    }


    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable("id") Integer productId, HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
        System.out.println("productId="+productId);
        Product product=productService.getProductMapper().selectByPrimaryKey(productId);
        Category category=categoryService.getCategoryMapper().selectByPrimaryKey(product.getCategoryid());
        model.addAttribute("product", product);
        model.addAttribute("category", category);


        return "demo/productDetail";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile img,Product product) throws IOException {
        if(!img.isEmpty()){
            String uuid= UUID.randomUUID().toString();
            String extname=img.getOriginalFilename().split("\\.")[1];
            String newFileName=uuid+"."+extname;
            String destpath=uploaddir+uuid+"."+extname;
            img.transferTo(new File(destpath));
            product.setImgsrc(newFileName);

        }
        product.setCreatedate(new Date());
        product.setUpdatedate(new Date());
        product.setStatus(1);
        productService.getProductMapper().insertSelective(product);
        return "success";
    }

}