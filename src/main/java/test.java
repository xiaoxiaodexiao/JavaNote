//package com.xzyhproduct.eps.common.Util.myutils;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.sql.Timestamp;
//public class test {
//    public static void main(String[] args) {
//        Date date1 = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(date1);
//        System.out.println(dateString);
//        Date endTimeOf24 = DateUtil.getEndTimeOf24(date1);
//        String dateString2 = formatter.format(endTimeOf24);
//        System.out.println(dateString2);
//        Date endTimeOf241 = DateUtil.getEndTimeOf24(date1, 30);
//        String dateString21 = formatter.format(endTimeOf241);
//        System.out.println(dateString21);
//        Timestamp t = new Timestamp(date1.getTime());
//        long sqlLastTime = t.getTime();// 直接转换成long
//        System.out.println("sqlLastTime = "+sqlLastTime); //毫秒数
//        System.out.println("sqlLastTime/1000 = "+sqlLastTime/1000);     // 秒数
//        System.out.println(t);
//        try {
//            Timestamp ts = Timestamp.valueOf(dateString21);
//            System.out.println(ts);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        输出结果
////        2020-05-02 02:10:55
////        2020-05-03 00:00:00
////        2020-06-02 00:00:00
////        sqlLastTime = 1588356655249
////        sqlLastTime/1000 = 1588356655
////        2020-05-02 02:10:55.249
////        2020-06-02 00:00:00.0
//    }
//}
