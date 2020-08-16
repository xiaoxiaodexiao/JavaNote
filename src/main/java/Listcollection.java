import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
public class Listcollection {

    public static void main(String[] args) {

        List<User> list1 = new ArrayList<>();
        list1.add(new User("xiaxia", 1,new Date()));
        list1.add(new User("xi", 2,new Date()));
        list1.add(new User("xia", 3,new Date()));
        list1.add(new User("xiax", 4,new Date()));


        List<User1> list2 = new ArrayList<>();
        list2.add(new User1("oooo", 1));
        list2.add(new User1("ooooo", 3));

//        // 交集
//        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);
//
//        // 差集 (list1 - list2)
//        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out :: println);
//
//        // 差集 (list2 - list1)
//        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
//        System.out.println("---差集 reduce2 (list2 - list1)---");
//        reduce2.parallelStream().forEach(System.out :: println);
//
//        // 并集
//        List<String> listAll = list1.parallelStream().collect(toList());
//        List<String> listAll2 = list2.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println("---并集 listAll---");
//        listAll.parallelStream().forEachOrdered(System.out :: println);
//
//        // 去重并集
//        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
//        System.out.println("---得到去重并集 listAllDistinct---");
//        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);
//
//        System.out.println("---原来的List1---");
//        list1.parallelStream().forEachOrdered(System.out :: println);
//        System.out.println("---原来的List2---");
//        list2.parallelStream().forEachOrdered(System.out :: println);


        //使用迭代器删除两个集合中相同的属性字段，从大集合中删除
//        Iterator<User> menuIterator = list1.iterator();
//
//        while (menuIterator.hasNext()) {
//            //多线程情况下加锁
//            synchronized (menuIterator) {
//                User next = menuIterator.next();
//                for (User1 roleMenuBut : list2) {
//                    if (roleMenuBut.getUid().equals(next.getId())) {
//                        //不是list的remove,是迭代器的
//                        menuIterator.remove();
//                    }
//                }
//            }
//        }

        System.out.println(list1.toString());
        List<Integer> collect = list1.stream().map(User::getId).collect(toList());
        System.out.println(collect);

        /*计算的是集合中对象属性id的和*/
        int totalValue = list1.stream().mapToInt(User::getId).sum();
        System.out.println(totalValue);


        /*Java中compareTo比较两个日期大小*/

        /*以前我一直以为，如果大于的话compareTo的返回值应该是1，等于的话是0，小于的话是-1，

        网上很多也是这样说，但是现实中我程序出错，最后打出来，看了一下，如果大于的话返回的是正整数，

        等于是0，小于的话就是负整数，而不仅仅局限于1,0和-1，以后做比较要注意*/

        List<User> sysSubjectiveList = list1
                .stream()
                .filter(sys -> sys.getEndTime().compareTo(new Date())>0)
                .collect(Collectors.toList());

    }
}



