package com.gary.controller;

import com.gary.pojo.Books;
import com.gary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
// @RequestMapping("/book")
public class BookController {
    // 调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    
    // 查询全部枢机，返回到一个书籍展示页面
    @RequestMapping("/book/allbook")
    public String list(Model model,HttpSession session) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        Integer stu_id = (Integer) session.getAttribute("stu_id");
        if(stu_id == 17373290){
            return "admin";
        }
        return "allbook";
    }
    
    @RequestMapping("/book/jumpToadd")
    public String toAddPage(Model model) { // 跳转到添加书籍的界面
        return "addbook";
    }
    
    @RequestMapping("/book/addbook")
    public String addBook(Books books, HttpSession session,Model model) {
        System.out.println("AddBook=>" + books);
        bookService.addBook(books);
        Integer stu_id = (Integer) session.getAttribute("stu_id");
        if( stu_id== 17373290){
            List<Books> booksList = bookService.queryAllBook();
            model.addAttribute("list",booksList);
            return "admin";
        }
        return "redirect:allbook"; // 重定向到一个请求
    }
    
    @RequestMapping("/book/jumpToUpdate")
    public String toUpdateBook(int book_id, Model model) {
        System.out.println("id ====> " + book_id);
        Books book = bookService.queryBookById(book_id);
        model.addAttribute("modBook", book); // 传递一个需要修改的书籍
        return "updateBook"; // 重定向到一个请求
    }
    
    @RequestMapping("/book/updatebook")
    public String updateBook(Books books) {
        System.out.println(books);
        bookService.updateBook(books);
        return "admin"; // 重定向到一个请求
    }
    
    @RequestMapping("/book/delete")
    public String deleteBook(int book_id) {
        System.out.println(bookService.queryBookById(book_id));
        bookService.delBookById(book_id);
        return "admin";
    }
    
    @RequestMapping("/book/queryBook")
    public String queryBook(String queryBookName, Model model,HttpSession session) {
        Books books = bookService.queryBookByName(queryBookName);
        if (books == null) {
            model.addAttribute("error", "未查到该书籍");
        } else {
            List<Books> list = new ArrayList<Books>();
            list.add(books);
            model.addAttribute("list", list);
        }
        Integer stu_id = (Integer) session.getAttribute("stu_id");
        if(stu_id == 17373290){
            return "admin";
        }
        return "allbook";
    }
    
    @RequestMapping("book/gotoWelcome")
    public String gotoWelCome(){
        return "register";
    }
}
