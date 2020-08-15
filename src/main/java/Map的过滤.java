
import jersey.repackaged.com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2019/10/8 0008 23:24
 * @Description:
 */
public class Map的过滤 {
    public static void main(String[] args) {

//        Map<Integer, String> HOSTING = new HashMap<>();
        HashMap<String, Object>  HOSTING= Maps.newHashMap();

//        HOSTING.put(1, "linode.com");
//        HOSTING.put(2, "heroku.com");
//        HOSTING.put(3, "digitalocean.com");
//        HOSTING.put(4, "aws.amazon.com");
        HOSTING.put("第四课时",1);
        HOSTING.put("第五课时",0);
        HOSTING.put("第三课时",2);
        HOSTING.put("name","是否签到");

        //Map -> Stream -> Filter -> Map 这个是对map的value进行的过滤，查看value是否属于Int类型
        Map<Object, Object> collect = HOSTING.entrySet().stream()
                .filter(map -> (map.getValue() instanceof Integer))
                .collect(Collectors.toMap(p -> p.getKey(), p ->p.getValue() ));

        System.out.println(collect.get(2)); //output : {2=heroku.com}


    }
}
