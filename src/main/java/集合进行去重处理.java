import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class 集合进行去重处理 {
    public static void main(String[] args) {
        /*对符合条件的进行过滤处理*/
        List<User> userList = new ArrayList<>();

        User user1 = User.builder().id(1).name("ONE").build();

        User user2 = User.builder().id(2).name("ZERO").build();

        User user3 = User.builder().id(3).name("TWO").build();

        User user4 = User.builder().id(4).name("FOUR").build();

        User user5 = User.builder().id(5).name("ONE").build();

        User five = User.builder().id(1).name("FIVE").build();


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(five);

        /*对全部课时相同的进行去重处理*/
        List<User> unique = userList.stream().collect(
                Collectors.collectingAndThen(
                        /*Collectors.toCollection(TreeSet::new)：转换成特定的set集合*/
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getId))), ArrayList::new)
        );

        unique.forEach( bean->System.out.println(bean.getName()));

        List<String> idList=userList.stream().map(User::getName).collect(Collectors.toList());
    }


}
