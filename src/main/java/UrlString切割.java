public class UrlString切割 {
    public static void main(String[] args) {

        String URL="https://xiaoxiaoa.oss-cn-beijing.aliyuncs.com/vidfile/2019-11-08/1573180668461.mp4" ;
        /*将老的URL进行切割，获取最后的文件名*/
        String filename_extension = URL.substring(URL
                .lastIndexOf("/") +1);
        System.out.println(filename_extension);
    }



}
