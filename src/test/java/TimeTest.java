import com.fasterxml.jackson.core.JsonProcessingException;
import com.gary.service.StuServiceImpl;
import com.gary.utils.TimeUtils;
import javafx.util.Duration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    @Test
    public void timeTest() throws JsonProcessingException, ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        Date date = new Date(); // 当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StuServiceImpl stuService = (StuServiceImpl) context.getBean("StuServiceImpl");
        Date oldDate = sdf.parse(stuService.queryTime(1, 1)); // 借书时间
        
        System.out.println(date.getTime());
        System.out.println(oldDate.getTime());
        long diff = Math.abs(date.getTime() - oldDate.getTime());
        long day = diff / (24 * 60 * 60 * 1000);
        long hour = diff / (60 * 60 * 1000) - day * 24;
        long min = (diff / (60 * 1000)) - day * 24 * 60 - hour * 60;
        System.out.println("diff ===> " + diff);
        System.out.println("day ===> " + day); // day
        System.out.println("hour ===> " + hour); // hour
        System.out.println("minutes ===> " + min); // minute


//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c1.setTime(date);
//        c2.setTime(oldDate);
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(oldDate));
//        System.out.println("月份=====>" + (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH)));
//        System.out.println("天数=====>" + (c1.get(Calendar.DATE) - c2.get(Calendar.DATE)));
//        System.out.println("小时====>"+(c1.get(Calendar.HOUR) - c2.get(Calendar.HOUR)) );
//        System.out.println("分钟====>" + (c1.get(Calendar.MINUTE) - c2.get(Calendar.MINUTE)));
//        System.out.println("秒====>" + (c1.get(Calendar.SECOND) - c2.get(Calendar.SECOND)));
    }
}
