import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/10/9 0009 00:14
 * @Description:
 */
public class list求和int类型的 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //直接用sum方法
        Integer sum = integers.stream().mapToInt(i -> i).sum();
        long count = integers.stream().count();
        System.out.println(count);
        System.out.println(sum);
//        // 准备数据
//        List<User> userList = new ArrayList<User>();
//        for (int i = 0; i < 100; i++) {
//            User user = new User(i,new BigDecimal(i+"."+i));
//            userList.add(user);
//        }
//        // for version
//        BigDecimal result1 = BigDecimal.ZERO;
//        for (User user : userList) {
//            result1 = result1.add(user.getMoney());
//        }
//        System.out.println("result1 = "+result1);
//        BigDecimal result2 = userList.stream()
//                // 将user对象的mongey取出来map为Bigdecimal
//                .map(User::getMoney)
//                // 使用reduce聚合函数,实现累加器
//                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
