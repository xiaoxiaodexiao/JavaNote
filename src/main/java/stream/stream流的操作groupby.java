package stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2019/11/17 0017 21:10
 * @Description:
 */
public class stream流的操作groupby {

    public static void main(String[] args) {

        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple",  6),
                new Fruit("apple", 6),
                new Fruit("banana", 7), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape",8));

        Map<String, Long> map = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));

        System.out.println(map);
//        番木瓜= 1，香蕉= 2，苹果= 3，猩猩= 1，西瓜= 1

        Map<String, Integer> sumMap = fruitList.stream().collect
        (Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getPrice)));
//        番木瓜= 20，香蕉= 30，苹果= 40，orang = 10，西瓜= 10
        System.out.println(sumMap);



    }
    /*小写转大写，stream().map()，您可以将对象转换为其他对象*/
    List<String> alpha = Arrays.asList("a", "b", "c", "d");

    @Test
    public void test03(){
        /*map针对每一个数据的处理，对数据进行重写组合*/
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    List<Integer> num = Arrays.asList(1,2,3,4,5);
    /*乘以二倍操作*/
    @Test
    public void test04(){
//        collect(Collectors.toList())转换成list集合  Collectors.toSet()：转换成set集合
    List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
    }
    /*求和操作*/
    @Test
    public void test5(){
        /*reduce针对最后的结果的处理,对数据进行汇总操作*/
        Integer integer = num.stream().reduce((sum, x) -> sum + x).get();
        System.out.println(integer);
    }


}
