package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/10/1 0001 01:36
 * @Description:
 */
public class TimeTes {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2019-10-01 01:42:36");
        if (date1.getTime()>new Date().getTime()) {
            System.out.println(true);
        }
    }
}
