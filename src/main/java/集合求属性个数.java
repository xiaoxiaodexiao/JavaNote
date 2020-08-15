import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 集合求属性个数 {
    public static void main(String[] args) {
        SysProcedure sysProcedure = new SysProcedure(1L,4,"1,2,3",1L);
        SysProcedure sysProcedure1 = new SysProcedure(2L,5,"1,2,3",1L);
        SysProcedure sysProcedure3 = new SysProcedure(3L,6,"1,2,3",1L);
        SysProcedure sysProcedure4 = new SysProcedure(4L,6,"1,2,3",1L);
        SysProcedure sysProcedure5 = new SysProcedure(5L,4,"1,2,3",1L);
        List<SysProcedure> sysProcedures = new ArrayList<>();
        sysProcedures.add(sysProcedure);
        sysProcedures.add(sysProcedure1);
        sysProcedures.add(sysProcedure3);
        sysProcedures.add(sysProcedure4);
        sysProcedures.add(sysProcedure5);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (SysProcedure sy : sysProcedures) {

            Integer count = map.get(sy.getType());

            map.put(sy.getType(), (count == null) ? 1 : count + 1);

        }
        ArrayList<Map> maps = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            HashMap<String, Integer> map2 = new HashMap<>();
            Integer mapKey = entry.getKey();
           Integer mapValue = entry.getValue();
           map2.put("type",mapKey);
           map2.put("count",mapValue);
//            System.out.println(mapKey+":"+mapValue);
            maps.add(map2);
        }
        System.out.println(maps);
        System.out.println(map);
    }
}
