import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SysProcedure sysProcedure = new SysProcedure(1L,4,"1,2,3",1L);
        SysProcedure sysProcedure1 = new SysProcedure(2L,5,"1,2,3",1L);
        SysProcedure sysProcedure3 = new SysProcedure(3L,6,"1,2,3",1L);
        List<SysProcedure> sysProcedures = new ArrayList<>();
        sysProcedures.add(sysProcedure);
        sysProcedures.add(sysProcedure1);
        sysProcedures.add(sysProcedure3);
        sysProcedures.stream().forEach(e->System.out.format("%s ",e));

        /*拿到了type集合,获取全部的属性字段集合*/
        List<Integer> collect = sysProcedures.stream().map(SysProcedure::getType).collect(Collectors.toList());
        collect.forEach(item->System.out.println(item));

        /*拿到list中的type和id存入map中去,在Map集合中包含键名4:1*/
        Map<Integer, Long> map = sysProcedures.stream().collect(Collectors.toMap(SysProcedure::getType, SysProcedure::getId));
        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", value:" + v);
        });

        Integer key=4;
        boolean contains = map.containsKey(key);    //判断是否包含指定的键值
        if (contains) {         //如果条件为真
            System.out.println("在Map集合中包含键名" + key+":"+map.get(key)); //输出信息
        } else {
            System.out.println("在Map集合中不包含键名" + key);
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
                 System.out.println("List转字符串");

        Long[] roleIds = Convert.toLongArray("1,8,6,4,5");
        for (Long roleId : roleIds){
            System.out.println(roleId);
        }

        System.out.println("++++++++++++++这个是枚举类型的操作+++++++++++++++++++");
        Integer i=3;
        switchEnum enumOrder = switchEnum.getEnumOrder(i);
        System.out.println(enumOrder);
        System.out.println(enumOrder.toString());
        System.out.println("+++++++++++++++++++++++++++++++++");


        /*对符合条件的进行过滤处理*/
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().id(1).name("ONE").build();
        User user2 = User.builder().id(2).name("ZERO").build();
        User user3 = User.builder().id(3).name("TWO").build();
        User user4 = User.builder().id(4).name("FOUR").build();
        User user5 = User.builder().id(5).name("ONE").build();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        System.out.println("筛选前：" + userList);
        userList = userList.stream().filter(o -> o.getName().equals("ONE")).collect(Collectors.toList());
        System.out.println("筛选后：" + userList);



//        list.stream().filter(bean -> {
//            if (1 == bean.getNum1())
//                bean.setNum1(2);
//            return true;
//        }).collect(Collectors.toList());





        List<Person> persons = Arrays.asList(
                new Person("e1", "l1"),
                new Person("e2", "l1"),
                new Person("e3", "l2"),
                new Person("e4", "l2"),
                new Person("e5", "l3"),
                new Person("e6", "l3"),
                new Person("e7", "l3")

        );
        //.filter（过滤条件）
        //.collect(Collectors.toList()) 把结果搜集到List之中。
        persons = persons.stream().filter(person -> person.getLastName().equals("l3")).collect(Collectors.toList());
        persons.forEach(person -> {
            System.out.println(person.getName());
        });

        /*过滤操作*/
//        persons.stream().filter(bean -> {
//            if ("e3" == bean.getName())
//                bean.setName();
//            return true;
//        }).collect(Collectors.toList());

    }

        /*遍历集合对象对里面的属性进行判断过滤*/
    //            for (ProcedureLog procedureLog : allLog) {
//                if (recoderVo.getId().equals(procedureLog.getMatterId())) {
//                    /*这个的意思就是我在这次事件中的处理意见*/
//                    matterRecoderVo.setSelfresult(ResultStatus.getEnumStatus(procedureLog.getStatus()).toString());
//                }
//            }
//            allLog.stream().forEach(bean -> {
//        if (recoderVo.getId().equals(bean.getMatterId()))
//            matterRecoderVo.setSelfresult(ResultStatus.getEnumStatus(bean.getStatus()).toString());
//    });



}



