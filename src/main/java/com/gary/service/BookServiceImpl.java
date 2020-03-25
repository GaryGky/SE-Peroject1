package com.gary.service;

import com.gary.dao.BookMapper;
import com.gary.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    
    // service层调用DAO层
    private BookMapper bookMapper;
    
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }
    
    public int delBookById(int book_id) {
        return bookMapper.delBookById(book_id);
    }
    
    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }
    
    public Books queryBookById(int book_id) {
        return bookMapper.queryBookById(book_id);
    }
    
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
    
    public Books queryBookByName(String bkName) {
        return bookMapper.queryBookByName(bkName);
    }
}
