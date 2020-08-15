import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Administrator
 * @Date: 2019/9/26 0026 01:28
 * @Description:
 */
public class Strsplit {
    public static void main(String[] args) {

        Boolean a1 = isContain("A:void,B:12class,C:_blank,D:.exe", "A");
        System.out.println(a1);
        String m="霍建华";
        boolean hua = m.contains("霍华");
        System.out.println(hua);






        /*字符串拼接操作*/
        String str="A:void,B:12class,C:_blank,D:.exe";
//            将字符串切割
            String[] split =  str.split(",");
            System.out.println(split);
            boolean status=false;
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
               Boolean status1 = split[i].contains("A");
                if(status1){
                    status=true;
                    break;
                }else{
                    status=false;
                    System.out.println("不包含");
                }

            }


            int a=(int) 88;
//            是不是整数
            Pattern pattern = Pattern.compile("^\\d+$|-\\d+$");
            Matcher matcher = pattern.matcher(String.valueOf(a));
            if (!matcher.matches()) {
                System.out.println("是整数");
            }
            System.out.println("不是整数");

        HashMap<String, Object> integerObjectHashMap = new HashMap<>();
        String str1="1:1、2,2:1、3,3:2、4";
//        将字符串切割
        String[] split1 =  str1.split(",");
        for (String s : split1) {
            String[] split2 = s.split(":");
            integerObjectHashMap.put(split2[0],split2[1]);
            System.out.println(split2.toString());
        }



        String str2="10,*,*";
        ArrayList<Long> longs = new ArrayList<>();
        String[] split2 =  str2.split(",");

//        for (int i = 0; i < split2.length; i++) {
//
//            boolean status = split2[i].contains("*");
//            if(status){
//
//                System.out.println("包含");
//
//            }else{
//                System.out.println("不包含");
//               longs.add(Long.parseLong(split2[i])) ;
//            }
//
//        }

        System.out.println(longs);









        }

    /*将字符串切割*/
    public static Boolean isContain(String str,String s){
        String[] split =  str.split(",");
        boolean status=false;
        for (int i = 0; i < split.length; i++) {

            Boolean status1 = split[i].contains(s);

            if(status1){
              status=status1;

                break;

            }

        }
        return status;
    }
    }


