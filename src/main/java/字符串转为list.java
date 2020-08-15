import org.apache.commons.collections4.CollectionUtils;

import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 字符串转为list {
    public static void main(String[] args) {



        String ids="1";
        List<String> idsStringList = Arrays.asList(ids.split(","));
        List<Integer> idsList = new ArrayList<>();
//        CollectionUtils.collect(idsStringList, new Transformer() {
//            @Override
//            public Object transform(Object o) {
//                return Integer.valueOf(o.toString());
//            }
//        }, idsList);
        System.out.println(idsList);
        List<Long> longs = stringToLongList(ids);
        System.out.println(longs);
        List<Integer> integers = stringToIntegerList(ids);
        System.out.println(integers);


    }

    /**
     * String字符串转成List<Long>数据格式
     * String str = "1,2,3,4,5,6" -> List<Long> listLong [1,2,3,4,5,6];
     *
     * @param strArr
     * @return
     */
    private static List<Long> stringToLongList(String strArr) {
        return Arrays.stream(strArr.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
    }

    private static List<Integer> stringToIntegerList(String strArr) {
        List<Integer> list = Arrays.asList(strArr.split(",")).stream()
            .map(s -> Integer.parseInt(s))  //.map(Integer::valueOf)
            .collect(Collectors.toList());
        return list;
    }
}
