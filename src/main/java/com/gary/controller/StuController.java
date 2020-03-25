package com.gary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gary.pojo.Books;
import com.gary.pojo.BorrowInfo;
import com.gary.pojo.Student;
import com.gary.service.BookServiceImpl;
import com.gary.service.StuServiceImpl;
import com.gary.utils.TimeUtils;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StuController {
    // 调service层
    @Autowired
    @Qualifier("StuServiceImpl")
    private StuServiceImpl stuService;
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookServiceImpl bookService;
    
    private long getFund(String borrowDate) throws ParseException { // 计算罚金
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date old = sdf.parse(borrowDate);
        long diff = now.getTime() - old.getTime();
//        long day = diff / (24 * 60 * 60 * 1000);
//        long hour = diff / (60 * 60 * 1000) - day * 24;
        return (diff / (60 * 1000)); // 借了几分钟给几块钱
    }
    
    private BorrowInfo getInfo(Books book, long fund) {
        return new BorrowInfo(book, fund);
    }
    
    private List<BorrowInfo> getInfoList(int stu_id, List<Books> booksList) throws ParseException {
        List<BorrowInfo> infoList = new ArrayList<BorrowInfo>();
        for (Books books : booksList) {
            infoList.add(getInfo(books, getFund(stuService.queryTime(stu_id,
                    books.getBook_id()))));
        }
        return infoList;
    }
    
    
    @RequestMapping("/stu/queryBookByStu")
    public String queryBookByStu(HttpSession session, int stu_id, Model model) throws ParseException {
        Integer session_stuId = (Integer) session.getAttribute("stu_id");
        if (!session_stuId.equals(stu_id) && session_stuId!=17373290) {
            model.addAttribute("error1", "您无权查询其他学生");
            return "allbook";
        }
        Student student = stuService.queryStuById(stu_id);
        if (student == null) {
            model.addAttribute("error", "请输入正确的学号");
            return "allbook";
        } else {
            List<Books> books = stuService.queryBorrowBook(stu_id);// 得到该学生借阅的书籍
            model.addAttribute("list", getInfoList(stu_id, books));
            model.addAttribute("stu_id", stu_id);
            return "ownbook";
        }
    }
    
    @RequestMapping("stu/gotoborrowbook") // 获取到书籍的信息并且展示借书界面
    public String gotoBorrowBook(HttpServletRequest request,
                                 HttpServletResponse response, int book_id,
                                 Model model) throws IOException {
        // 数量为0 或者重复借书不能跳转
        HttpSession session = request.getSession();
        int count = bookService.queryBookById(book_id).getBkCount();
        if (count == 0) {
            PrintWriter writer = response.getWriter();
            writer.print("<script>\n" +
                    "        alert(\"图书数量为0\");\n" +
                    "    </script>");
            writer.flush();
            writer.close();
            return "redirect:allbook";
        }
        Integer stu_id = (Integer) session.getAttribute("stu_id");
        if (stuService.queryTime(stu_id, book_id) != null) {
            PrintWriter writer = response.getWriter();
            writer.print("<script>\n" +
                    "        alert(\"不能重复借书\");\n" +
                    "    </script>");
            writer.flush();
            writer.close();
            return "redirect:allbook";
        }
        Books books = bookService.queryBookById(book_id);
        model.addAttribute("book", books);
        return "borrowbook";
    } // 借书
    
    @RequestMapping("stu/borrowbook") // 修改数据库并返回主界面
    public String borrowBook(HttpServletRequest request,
                             HttpServletResponse response,
                             HttpSession session,
                             int book_id, int stu_id,
                             Model model) throws IOException, ParseException {
        Integer sessStuId = (Integer) session.getAttribute("stu_id");
        if (!sessStuId.equals(stu_id)) {
            model.addAttribute("error", "请输入正确的学号");
            return "borrowbook";
        } else {
            stuService.borrowBook(stu_id, book_id, TimeUtils.getJson(new Date()));
            List<Books> booksList = stuService.queryBorrowBook(stu_id);
            model.addAttribute("list", getInfoList(stu_id, booksList));
            return "ownbook";
        }
    }
    
    
    @RequestMapping("stu/returnbook")
    public String returnBook(int stu_id, int book_id, Model model) throws JsonProcessingException, ParseException {
        stuService.returnBook(stu_id, book_id, TimeUtils.getJson(new Date()));
        List<Books> booksList = stuService.queryBorrowBook(stu_id);
        model.addAttribute("list", getInfoList(stu_id, booksList));
        return "ownbook";
    }
}
