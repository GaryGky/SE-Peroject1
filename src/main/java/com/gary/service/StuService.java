package com.gary.service;

import com.gary.pojo.Books;
import com.gary.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuService {
    public int addStu(Student student); // 增加一个学生用户
    
    public int delStuById(int stu_id); // 删除一个学生用户
    
    public int updateStu(Student student); // 用户可以修改密码
    
    public Student queryStuById(int stu_id); // 查询student好像没有这个操作
    
    public List<Student> queryAllStu(); // 查询所有学生
    
    public int borrowBook(int stu_id, int book_id, String timestamp);
    
    public int returnBook(int stu_id, int book_id, String timestamp);
    
    public List<Books> queryBorrowBook(int stu_id);
    
    public String queryTime(int stu_id,int book_id);
}
