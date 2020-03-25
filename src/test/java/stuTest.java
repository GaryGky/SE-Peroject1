import com.gary.pojo.Books;
import com.gary.pojo.Student;
import com.gary.service.BookServiceImpl;
import com.gary.service.StuServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class stuTest {
    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        stuService.addStu(new Student(1, "甘凯元", "999625"));
        stuService.addStu(new Student(2, "中文好", "981111"));
        stuService.addStu(new Student(3, "等理由", "123456"));
    }
    
    
    @Test
    public void testQuery() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        for (Student student : stuService.queryAllStu()) {
            System.out.println(student);
        }
    }
    
    @Test
    public void testQuery2() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        System.out.println(stuService.queryStuById(1));
        System.out.println(stuService.queryStuById(2));
        System.out.println(stuService.queryStuById(3));
    }
    
    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        stuService.updateStu(new Student(1, "gky", "0"));
        stuService.updateStu(new Student(2, "zwh", "1"));
        stuService.updateStu(new Student(3, "dly", "2"));
    }
    
    @Test
    public void testDel() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        stuService.delStuById(1);
        stuService.delStuById(2);
        stuService.delStuById(3);
    }
    
    @Test
    public void testBorrow() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD " +
                "HH:mm:ss");
        
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        stuService.borrowBook(1, 1, simpleDateFormat.format(date));
        stuService.borrowBook(1, 2, simpleDateFormat.format(date));
        stuService.borrowBook(1, 3, simpleDateFormat.format(date));
    }
    
    @Test
    public void testReturn() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD " +
                "HH:mm:ss");
        
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        stuService.returnBook(1,1,simpleDateFormat.format(date));
        stuService.returnBook(1,2,simpleDateFormat.format(date));
        stuService.returnBook(1,3,simpleDateFormat.format(date));
    }
    
    @Test
    public void testQueryStu() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD " +
                "HH:mm:ss");
        
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        for (Books books : stuService.queryBorrowBook(1)) {
            System.out.println(books);
        }
    }
}


