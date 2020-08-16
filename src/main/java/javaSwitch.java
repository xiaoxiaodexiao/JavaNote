public class javaSwitch {
    public static void main(String[] args) {

        defautTest(1);
    }
    /*
     * default不是必须的，也可以不写
     * 输出：case two
     */
    private static void defautTest(Integer a) {
       /* char ch = 'A';*/
        switch (a) {
            case 1:
                System.out.println("case one");
                break;
            case 2:
                System.out.println("case two");
                break;
            case 3:
                System.out.println("case three");
                break;
        }
        System.out.println("a");
    }
}
