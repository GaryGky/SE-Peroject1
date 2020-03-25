package com.gary.service;

import com.gary.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    public int addBook(Books book);
    
    public int delBookById(int book_id);
    
    public int updateBook(Books book);
    
    public Books queryBookById(int book_id);
    
    public List<Books> queryAllBook();
    
    public Books queryBookByName(String bkName);
    
    
}
