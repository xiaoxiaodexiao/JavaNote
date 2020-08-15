import utils.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class ArryDemo extends ArrayUtils {
    public static void main(String[] args) {
        String[] array = new String[]{"Apple", "Xiaomi", "Huawei", "Vivo", "Oppo"};
        // 从数组转为集合，集合list长度不可更改
        List<String> list = Arrays.asList(array);
        list.remove("Apple");
        list.forEach(s -> System.out.println(s));

    }
}
