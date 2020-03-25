package com.gary.service;

import com.gary.dao.StudentMapper;
import com.gary.pojo.Books;
import com.gary.pojo.Student;

import java.util.List;

public class StuServiceImpl implements StuService {
    private StudentMapper studentMapper;
    
    public StudentMapper getStudentMapper() {
        return studentMapper;
    }
    
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    
    public int addStu(Student student) {
        return studentMapper.addStu(student);
    }
    
    public int delStuById(int stu_id) {
        return studentMapper.delStuById(stu_id);
    }
    
    public int updateStu(Student student) {
        return studentMapper.updateStu(student);
    }
    
    public Student queryStuById(int stu_id) {
        return studentMapper.queryStuById(stu_id);
    }
    
    public List<Student> queryAllStu() {
        return studentMapper.queryAllStu();
    }
    
    public int borrowBook(int stu_id, int book_id, String timestamp) {
        return studentMapper.borrowBook(stu_id, book_id, timestamp);
    }
    
    public int returnBook(int stu_id, int book_id, String timestamp) {
        return studentMapper.returnBook(stu_id, book_id, timestamp);
    }
    
    public List<Books> queryBorrowBook(int stu_id) {
        return studentMapper.queryBorrowBook(stu_id);
    }
    
    public String queryTime(int stu_id, int book_id) {
        return studentMapper.queryTime(stu_id, book_id);
    }
}
