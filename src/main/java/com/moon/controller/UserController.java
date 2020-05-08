package com.moon.controller;

import com.moon.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/29
 * @since 1.0.0
 */
@RequestMapping("/moon/user")
@Controller
public class UserController extends BaseController {

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mgr_getToken = "http://120.55.53.172:7000/moon/SysUser/getToken";
        response.sendRedirect(mgr_getToken + "?callbackurl=http://localhost:8000");
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mgr_logout = "http://120.55.53.172:7000/moon/SysUser/logout";
        response.sendRedirect(mgr_logout);

    }
}