import java.text.DecimalFormat;

public class Percentage {
    public static void main(String[] args) {
        /*这个是计算百分比的demo*/
        DecimalFormat df =new DecimalFormat();

        df.setMaximumFractionDigits(0);

        df.setMinimumFractionDigits(0);

        String orderRate = df.format(10 *100.00 / 18) +"%";
        System.out.println(orderRate);

        /*求平均成绩*/
        int round = Math.round(12 / 11);
        System.out.println(round);
    }
}
