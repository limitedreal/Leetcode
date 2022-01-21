package main.jd.qiuzhao.exam1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        //首先这种时间格式应该是美国时间的一种格式，因为这里不写上Locale.US"的话，则会抛ParseException异常
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        //
        //String cstStr = "Wed, 17 Oct 2018 20:17:40 CST";
        //String bstStr = "Wed, 17 Oct 2018 20:17:40 BST";
        //
        //System.out.println(sdf.parse(cstStr));
        //System.out.println(sdf.parse(bstStr));
        //
        //sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        //
        //System.out.println(sdf.parse(cstStr));
        //System.out.println(sdf.parse(bstStr));

        String s = "Fri Jan 14 2022 17:11:20 GMT+0800 (CST)";
        String g = "Fri Jan 14 2022 17:11:20 GMT+0800";
        Date date = new Date(s);
        date.toString();
        System.out.println(date);
        timeTest();
        timeTest1();
        //System.out.println(DateFormat.getDateInstance(DateFormat.FULL).parse(g));
        //System.out.println(DateFormat.getDateInstance(DateFormat.FULL).parse(s));


        SimpleDateFormat SDformat = new SimpleDateFormat();

        // Initializing Calendar object
        Calendar cal = Calendar.getInstance();

        // Getting the Current Date
        String Todaysdate = SDformat.format(cal.getTime());

        // Displaying the date
        //System.out.println("Current Date: " + Todaysdate);

        // Using toPattern() method
        // to Print the Date Pattern
        //System.out.println("The Date Pattern- " + SDformat.toPattern());
    }

    public static void timeTest() throws ParseException {
        String time = "Mon Jan 17 2022 16:07:14 GMT+0800 (CST)";
        if (time.contains("GMT")) {
            // remove "GMT" because of the difficulty to make pattern string
            time = time.replace("GMT", "");
        }
        String pattern = "EEE MMM dd yyyy HH:mm:ss Z (zzz)";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);

        Date parse = format.parse(time);
        System.out.println(parse);

        //

         time = "Mon Jan 17 2022 16:07:14 GMT+0800 (CST)";
        if (time.contains("GMT")) {
            // remove "GMT" because of the difficulty to make pattern string
            time = time.replace("GMT", "");
        }
         pattern = "EEE MMM dd yyyy";
         format = new SimpleDateFormat(pattern, Locale.US);
        Date parse1 = format.parse(time);
        System.out.println(parse1);
    }

    public static void timeTest1() throws ParseException {
        String time = "Mon Jan 17 2022 16:07:14 GMT+0800 (CST)";
        if (time.contains("GMT")) {
            // remove "GMT" because of the difficulty to make pattern string
            time = time.replace("GMT", "");
        }
        String pattern = "EEE MMM dd yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
        Date parse = format.parse(time);
        System.out.println(parse);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int[] xLocation = new int[n];
        int[] yLocation = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = 0;
            xLocation[i] = x;
            yLocation[i] = y;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = xLocation[i];
                int y1 = yLocation[i];
                int x2 = xLocation[j];
                int y2 = yLocation[j];
                if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
