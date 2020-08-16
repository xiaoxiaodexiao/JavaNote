import java.util.Date;

public class Long类型的 {
     /*Long.ValueOf("String")返回Long包装类型

        包装类型： Byte，Integer，Short，Long，Boolean，Character，Float，Double等
        Long.parseLong("String")返回long基本数据类型

        基本数据类型：byte，int， short， long， boolean，char， float，double等*/
//        sysMenuAll.setId(Long.parseLong(roleMenuBut.getId()));
    /*这个设置的是结束时间*/
//    long endTime = new Date().getTime() + (5 * 60 * 1000);
     public static void main(String[] args) {
         Long lo=1199981197195530241L;
         long li = lo.longValue();

         int i = (int)li;
         System.out.println(i);
     }



}
