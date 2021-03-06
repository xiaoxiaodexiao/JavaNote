public class 数字转字母 {
    public static void main(String[] args) {

        数字转字母 letternum = new 数字转字母();
        String s = letternum.numberToLetter(4);
        int a = letternum.letterToNumber("A");
        System.out.println(a);
        System.out.println(s);

    }
    private String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);

        return letter;
    }
    private int letterToNumber(String letter) {
        int length = letter.length();
        int num = 0;
        int number = 0;
        for(int i = 0; i < length; i++) {
            char ch = letter.charAt(length - i - 1);
            num = (int)(ch - 'A' + 1) ;
            num *= Math.pow(26, i);
            number += num;
        }
        return number;
    }
}
