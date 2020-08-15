public class 基本数据类型的判断 {


        public static void main(String[] args) {
            Object object1 = null;
            int a = 1;
            long b = 2;
            short c = 3;
            boolean d = true;
            byte e = 4;
            char f = 'p';
            double g = 1.22;
            float h = 3.0f;
            String s = "wahaha";
            Integer i = new Integer(17); // 创建int原型类对象

            // 输出原来的数据
            System.out.println("object1=" + object1);
            System.out.println("a=" + a);
            System.out.println("b=" + b);
            System.out.println("c=" + c);
            System.out.println("d=" + d);
            System.out.println("e=" + e);
            System.out.println("f=" + f);
            System.out.println("g=" + g);
            System.out.println("h=" + h);
            System.out.println("s=" + s);
            System.out.println("i=" + i);
            System.out.println();// 换行
            object1 = a;
            object1 = b;
            object1 = c;
            object1 = d;
            object1 = e;
            object1 = f;
            object1 = g;
            object1 = h;
            object1 = s;
            object1 = i.byteValue(); // 以byte类型返回该Integer
            object1 = i.intValue(); // 以int型返回该Integer
            object1 = i.shortValue(); // 以short型返回该Integer
            object1 = i.toString(); // 以String对象返回该Integer
            object1 = Integer.toBinaryString(i); // 以String对象返回i转为二进制的字符串
            object1 = Integer.toHexString(i);// 以String对象返回i转为十六进制的字符串
            object1 = Integer.toOctalString(i);// 以String对象返回i转为八进制的字符串
            // object1 = null; // 未知类型;自定义类型

            // 判断数据类型
            if (object1 instanceof Integer) {
                System.out.println(object1 + " is Integer");
            } else if (object1 instanceof Long) {
                System.out.println(object1 + " is Long");
            } else if (object1 instanceof Short) {
                System.out.println(object1 + " is Short");
            } else if (object1 instanceof Boolean) {
                System.out.println(object1 + " is Boolean");
            } else if (object1 instanceof Byte) {
                System.out.println(object1 + " is byte");
            } else if (object1 instanceof Character) {
                System.out.println(object1 + " is Character");
            } else if (object1 instanceof Double) {
                System.out.println(object1 + " is Double");
            } else if (object1 instanceof Float) {
                System.out.println(object1 + " is Float");
            } else if (object1 instanceof String) {
                System.out.println(object1 + " is String");
            } else {
                System.out.println("unknown type, or yourself type");
            }

        }

    }

