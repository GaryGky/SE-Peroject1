package com.gary.config;

import com.gary.service.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 拦截器
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    @Qualifier("StuServiceImpl")
    private StuServiceImpl stuService;
    
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object Handler) throws ServletException, IOException {
        return true;
    }
    
    //在请求处理方法执行之后执行
    // 拦截日志
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("------------处理后------------");
        return;
    }
    
    //在dispatcherServlet处理后执行,做清理工作.
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("------------清理------------");
    }
}
