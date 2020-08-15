import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 集合取差集 {
    public static void main(String[] args) {

        Long[] src={1L,2L,3L,4L};

   /*     Arrays.stream(src).boxed().collect(Collectors.toList());*/
        List<Long> trueStringList = new ArrayList<>(Arrays.asList(src));
        List<Long> integerList = new ArrayList<>();
        integerList.add(1L);
        integerList.add(2L);
        integerList.add(3L);
        trueStringList.removeAll(integerList);
        System.out.println(trueStringList);


    }
}
