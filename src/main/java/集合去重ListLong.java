import com.google.common.collect.Lists;

import lombok.var;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 集合去重ListLong {

    public static void main(String[] args) {
        ArrayList<Long> longs = Lists.newArrayList(1L, 2L, 3L,2L);
        List<Long> longs1 = 集合去重ListLong(longs);

//        也可以调用MyCollectionUtil方法进行去重处理

        System.out.println(longs1);
    }

    /**/
    public static <T> List<T> 集合去重ListLong(List<T> list){
      //初始化HashSet对象，并把list对象元素赋值给HashSet对象
        HashSet set = new HashSet(list);
     //把List集合所有元素清空
      list.clear();
      //把HashSet对象添加至List集合
      list.addAll(set);
      return list;
    }

}
