package com.moon.controller;

import com.moon.entity.Product;
import com.moon.service.ProductService;
import com.moon.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/30
 * @since 1.0.0
 */
@Controller
@RequestMapping("/moon/room")
public class RoomController extends BaseController {

    @Autowired
    ProductService productService;

    @RequestMapping("/roomView")
    public String roomView(int productId, HttpServletRequest request, HttpServletResponse response, Model model){
        Product product=productService.getProductMapper().selectByPrimaryKey(productId);
        model.addAttribute("product", product);
        return "demo/room";
    }
}