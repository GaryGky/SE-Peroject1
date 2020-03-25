package com.gary.dao;

import com.gary.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    public int addBook(Books book);
    
    public int delBookById(@Param("book_id") int book_id);
    
    public int updateBook(Books book);
    
    public Books queryBookById(int book_id);
    
    public List<Books> queryAllBook();
    
    public Books queryBookByName(@Param("bkName") String bkName);
}
