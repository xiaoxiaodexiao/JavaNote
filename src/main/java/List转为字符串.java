import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class List转为字符串 {
    public static void main(String[] args) {

        List<Integer> li=new ArrayList<Integer>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        List<String> st=new ArrayList<String>();
        st.add("项目1");
        st.add("项目4");
        st.add("项目3");
        st.add("项目2");
        /****************第一种方法***************/
        StringBuilder strbul  = new StringBuilder();
        Iterator<Integer> iter = li.iterator();
        while(iter.hasNext())
        {
            strbul.append(iter.next());
            if(iter.hasNext()){
                strbul.append(",");
            }
        }
        String s = strbul.toString();
        System.out.println(s);
//       result: 1,2,3,4
        StringBuilder strbul2  = new StringBuilder();
        Iterator<String> iter2 = st.iterator();
        while(iter2.hasNext())
        {
            strbul2.append(iter2.next());
            if(iter2.hasNext()){
                strbul2.append(",");
            }
        }
        String s2 = strbul2.toString();
        System.out.println(s2);






//        /****************第二种方法***************/
//        String str = StringUtils.join(li, ",");
//        System.out.println(str);
////        1,2,3,4
//
////        StringUtils.join()方法第一个参数是数组或者集合（**什么类型都可以**），第二个参数是分隔符。
////        String.join()方法第一个参数是分隔符，第二个参数是数组或者集合（**只能是String类型**）。
//        List<String> list1 = new ArrayList<String>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        String ss = String.join(",", list1);
//        System.out.println(StringUtils.join(list1,""));
//        System.out.println(ss);
//        System.out.println("+++++++++++++++++++++++++++++++++");
//        System.out.println("字符串转List");
//
//        List<String> listString = Arrays.asList(ss.split(","));
//        for (String string : listString) {
//            System.out.println(string);
//        }
//        System.out.println("+++++++++++++++++++++++++++++++++");

    }
}
