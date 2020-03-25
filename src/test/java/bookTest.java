import com.gary.pojo.Books;
import com.gary.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bookTest {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("BookServiceImpl");
        bookService.addBook(new Books(1,"JAVA",2676,"从入门到精通"));
        bookService.addBook(new Books(2,"Python",234,"从删库到跑路"));
        bookService.addBook(new Books(3,"C",678,"从进门到进牢"));
    }
    
    
    @Test
    public void testQuery(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("BookServiceImpl");
        for (Books books : bookService.queryAllBook()) {
            System.out.println(books);
        }
        System.out.println(bookService.queryBookById(3));
    }
    
    @Test
    public void testQuery2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookService.queryBookById(1));
        System.out.println(bookService.queryBookById(2));
        System.out.println(bookService.queryBookById(3));
    }
    
    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("BookServiceImpl");
//        bookService.updateBook(new Books(1,"甘凯元","20","很帅"));
//        bookService.updateBook(new Books(2,"甘凯元","20","很帅"));
//        bookService.updateBook(new Books(3,"甘凯元","20","很帅"));
    }
    
    @Test
    public void testDel(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean("BookServiceImpl");
        bookService.delBookById(1);
        bookService.delBookById(2);
        bookService.delBookById(3);
    }
}
