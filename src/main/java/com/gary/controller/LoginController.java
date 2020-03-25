package com.gary.controller;

import com.gary.pojo.Books;
import com.gary.pojo.Student;
import com.gary.service.BookService;
import com.gary.service.StuServiceImpl;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    
    @Autowired
    @Qualifier("StuServiceImpl")
    private StuServiceImpl stuService;
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    
    @RequestMapping("user/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("userName") int userName,
                        @RequestParam("password") String password,
                        Model model) throws ServletException, IOException {
        System.out.println(userName + " : " + password);
        // 把用户的信息存在session中
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("stu_id", userName);
        if (stuService.queryStuById(userName) == null) {
            httpSession.setAttribute("error", "请输入正确的用户名和密码");
            httpSession.getServletContext().getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return "";
        } else if (stuService.queryStuById(userName).getPwd().equals(password)) {
            // 登录成功
            httpSession.removeAttribute("error");
            if (userName == 17373290) {
                List<Books> booksList = bookService.queryAllBook();
                model.addAttribute("list",booksList);
                return "admin";
            }
            return "allbook";
        } else { // 登录失败
            httpSession.setAttribute("error", "请输入正确的用户名和密码");
            httpSession.getServletContext().getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return "";
        }
    }
    
    @RequestMapping("register")
    public String gotoRegister() {
        return "register";
    }
    
    @RequestMapping("goto/login")
    public void gotoLogin(HttpServletRequest request,
                          HttpServletResponse response,Student student) throws ServletException, IOException {
        stuService.addStu(student);
        HttpSession httpSession = request.getSession();
        httpSession.getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
