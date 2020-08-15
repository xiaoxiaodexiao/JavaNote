import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @Auther: Administrator
 * @Date: 2019/9/29 0029 23:31
 * @Description:
 */
public class SplitStringToHashMap {
    public static void main(String[] args) {
       String a="1:A、B,2:B、C,3:C、D";
        SplitStringToHashMap splitStringToHashMap = new SplitStringToHashMap();
        HashMap<Integer, String> integerStringHashMap = splitStringToHashMap.cutBean(a);
    }
    private  HashMap<Integer, String> cutBean(String answer){
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        String[] split =  answer.split(",");
        for (String s : split) {
            String[] split1 = s.split(":");
            integerStringHashMap.put(Integer.valueOf(split1[0]),split1[1]);
        }
        return integerStringHashMap;
    }
}
