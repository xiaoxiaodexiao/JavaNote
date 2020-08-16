import java.util.*;

public class List随机出来密保 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c");
        int index = (int) (Math.random()* list.size());
        System.out.println(list.get(index));
        List randomList = createRandomList(list, 2);
        System.out.println(randomList);

    }
    private static List createRandomList(List list, int n) {
        Map map = new HashMap();
        List listNew = new ArrayList();
        if (list.size() <= n) {
            return list;
        } else {
            while (map.size() < n) {
                int random = (int) (Math.random() * list.size());
                if (!map.containsKey(random)) {
                    map.put(random, "");
                    listNew.add(list.get(random));
                }
            }
            return listNew;
        }
    }
}
