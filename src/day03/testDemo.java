package day03;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class testDemo {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入yyyy-MM-dd格式日期：");
        String date1 = "1990-01-01";
        Scanner scanner = new Scanner(System.in);
        String date2 = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateA = sdf.parse(date1);
        Date dateB = sdf.parse(date2);
        long l = (dateB.getTime() - dateA.getTime()) / (1000 * 3600 * 24) + 1;
        if (l % 5 == 1||l % 5 == 2||l % 5 == 3){
            System.out.println("打渔！！！！");
        }else if (l % 5 == 0||l % 5 == 4){
            System.out.println("晒网.........");
        }
    }
    @Test
    public void test(){
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
    }
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime time = LocalDateTime.of(2022, 5, 5, 11, 10, 56);
        System.out.println(time);
    }
    @Test
    public void test2(){
        System.out.println("git-test");
        System.out.println("git-test");
        System.out.println("git-test");
        System.out.println("git-test4");
        System.out.println("git-test6");
        System.out.println("git-test5");
        System.out.println("git-push");
        System.out.println("git-pull");
    }
    @Test
    public void test3(){
        //方式一：DateTimeFormatter.ISO_LOCAL_DATE_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = formatter.format(localDateTime);
        System.out.println(date);
        //解析
        TemporalAccessor parse = formatter.parse("2022-05-07T10:36:35.209");
        System.out.println(parse);

        //方式二：ofLocalizedDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String date2 = formatter1.format(localDateTime);
        System.out.println(date2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String date3 = formatter2.format(localDateTime);
        System.out.println(date3);

        //方式三：
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
        String date4 = formatter3.format(localDateTime);
        System.out.println(date4);
    }
}
