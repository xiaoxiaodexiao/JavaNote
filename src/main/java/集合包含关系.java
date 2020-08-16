import java.util.ArrayList;

public class 集合包含关系 {
    public static void main(String[] args) {

        ArrayList<String> als = new ArrayList<String>();
        als.add("叠合楼板");
        als.add("重合楼板");
//        als.add("c");
//        als.add("d");
//        als.add("e");
        ArrayList<String> alss = new ArrayList<String>();
        alss.add("叠合楼板");
        alss.add("重合楼板");
//        alss.add("e");
        System.out.println(als.containsAll(alss));
        boolean blo = als.contains("叠合楼板");
        System.out.println(blo);
    }
}
