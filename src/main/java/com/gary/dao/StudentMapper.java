package com.gary.dao;

import com.gary.pojo.Books;
import com.gary.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    public int addStu(Student student); // 增加一个学生用户
    
    public int delStuById(int stu_id); // 删除一个学生用户
    
    public int updateStu(Student student); // 用户可以修改密码
    
    public Student queryStuById(@Param("stu_id") int stu_id); // 查询student
    // 好像没有这个操作
    
    public List<Student> queryAllStu(); // 查询所有学生
    
    public int borrowBook(@Param("stu_id") int stu_id,
                          @Param("book_id") int book_id,
                          @Param("borrow_time") String timestamp); // 借书
    
    public int returnBook(@Param("stu_id") int stu_id,
                          @Param("book_id") int book_id,
                          @Param("return_time") String timestamp); // 还书
    
    public List<Books> queryBorrowBook(@Param("stu_id") int id); // 通过学号查找借阅书籍
    
    public String queryTime(@Param("stu_id") int stu_id,
                            @Param("book_id") int book_id);
    
}
