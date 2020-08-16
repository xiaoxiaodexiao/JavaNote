import com.google.common.base.Joiner;

import static utils.StringUtils.addSubString;

/**
 * @Auther: Administrator
 * @Date: 2019/10/13 0013 20:22
 * @Description:
 */
public class 字符串拼接 {
    public static void main(String[] args) {
        String s = addSubString("a", "b", "-");
        System.out.println(s);
        String join = Joiner.on(" 至 ").join("a", "d");
        System.out.println(join);
    }
}
