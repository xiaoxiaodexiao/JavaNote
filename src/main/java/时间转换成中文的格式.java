import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间转换成中文的格式 {
    public static void main(String[] args) {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy年MM月dd日 HH时mm分ss秒" );
        SimpleDateFormat sdf1 =   new SimpleDateFormat( " yyyy年MM月dd日 HH:mm" );
        Date date = new Date();
        String str = sdf.format(date);
        String format = sdf1.format(date);
        System.out.println(str);
        System.out.println(format);
    }
}
