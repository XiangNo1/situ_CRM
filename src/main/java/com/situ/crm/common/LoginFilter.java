package com.situ.crm.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse resp = (HttpServletResponse) response;
       String uri = req.getRequestURI();
       // /Java1705Web/login.jsp   /Java1705Web/loginFilter
       System.out.println(uri);
       if (uri.contains("login") || uri.contains("js") || uri.contains("jsp") || uri.contains("css")) {
           //直接放行
           chain.doFilter(request, response);
       } else {
           //都是需要登陆验证
           // 1.得到Session对象
           HttpSession session = req.getSession();
           // 2.得到会话数据
           if (session.getAttribute("currentUser") == null) {
               resp.sendRedirect(req.getContextPath() + "/login/login.action");
               return;
           }else{
           //验证成功，放行(可以访问jsp或者servlet这些资源)
           chain.doFilter(request, response);
           }
       }
    }
    @Override
    public void destroy() {
    }

}

