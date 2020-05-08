package com.moon.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/5/8
 * @since 1.0.0
 */
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("corsFilter--doFilter");
        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(request, resp);
    }

    @Override
    public void destroy() {

    }
}