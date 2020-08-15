import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
@Slf4j
public class small {

    public static void main(String[] args) throws Exception {
        String scene ="123&456";
//        https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=27__PiK1RhTFIpllnkrZ4BvHerBSteQWsNo-LoMyVLzK-OgU9TKQXdo3sVmY3mdyxM6gdaMdXfDwHKVA8Bn56SvRjwxo5AktedQY__mOCQwY0IqMC064ctYomMWaKPImpBYv7b0ucdjPLGq5TBLDFZcACAJLF
        String accesstoken="27_opnl366bbZQBOGuxXyzyOWw5zMIg1ndt23nKefFO1nnNaYNj2Bf9rLEhMsnrdIiRROYCz5j4qpKcbauCEDseXvzSLUpeNPSHqi8LkqamBrtQmwckGVYf1oDkvRR2Bko9cmoV9bT-da1OvqFOKZZdAEADSS";
//       String str = getminiqrQr(scene,accesstoken);
      ImgDTO qrCodeByAccessToken = getQrCodeByAccessToken(scene, accesstoken);
//        String getre = getre(scene, accesstoken);

    }
    public static String getminiqrQr(String sceneStr, String accessToken) {
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try
        {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessToken;
            Map<String,Object> param = new HashMap<>();
            param.put("scene", sceneStr);
            param.put("page", "pages/index/index");
            param.put("width", 430);
            param.put("auto_color", false);
            Map<String,Object> line_color = new HashMap<>();
            line_color.put("r", 0);
            line_color.put("g", 0);
            line_color.put("b", 0);
            param.put("line_color", line_color);

            log.info("调用生成微信URL接口传参:" + param);

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

            HttpEntity requestEntity = new HttpEntity(JSON.toJSONString(param), headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
            log.info("调用小程序生成微信永久小程序码URL接口返回结果:" + entity.getBody());
            byte[] result = entity.getBody();
        int statusCodeValue = entity.getStatusCodeValue();

        if(statusCodeValue!=200){
            return String.valueOf(statusCodeValue);
        }
        String resultImage = new String("data:image/png;base64," + Base64.encodeBase64String(result));

            log.info(Base64.encodeBase64String(result));

            inputStream = new ByteArrayInputStream(result);

            File file = new File("D:/xzyhImg/images/productImg/abcd.png");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
            log.error("调用小程序生成微信永久小程序码URL接口异常",e);
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        return resultImage;
        return null;

    }


    public static ImgDTO getQrCodeByAccessToken(String sceneStr, String accessToken) throws Exception {

        ImgDTO imgDTO = new ImgDTO();

        String imei = UUID.randomUUID().toString().substring(4);
//        String page="pages/scanCode/scanCode";
        String token = accessToken;   // 得到token

        imgDTO.setUuid(imei);

        Map<String, Object> param = new HashMap<>();
        param.put("scene", sceneStr);
        param.put("page", "pages/index/index");
        param.put("width", 430);
        param.put("auto_color", true);
//        Map<String,Object> line_color = new HashMap<>();
//        line_color.put("r", 0);
//        line_color.put("g", 0);
//        line_color.put("b", 0);
//        param.put("line_color", line_color);
//        params.put("scene", imei);  //参数
//        params.put("page", page); //位置
//        params.put("width", 430);

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token);  // 接口
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");

        String body = JSON.toJSONString(param);           //必须是json模式的 post
        StringEntity entity;
        entity = new StringEntity(body);
//        entity.setContentType("image/png");

        httpPost.setEntity(entity);
        HttpResponse response;

        response = httpClient.execute(httpPost);
        InputStream inputStream = response.getEntity().getContent();

//        String name = "qqq"+".png";

        String imgStream = saveToImgByInputStream(inputStream);  //保存图片
        System.out.println(imgStream);
        imgDTO.setImg(imgStream);


        return imgDTO;
    }


    /**
     * 将二进制转换成文件保存
     * @param instreams 二进制流
     * @return
     *      1：保存正常
     *      0：保存失败
     */
    public static String saveToImgByInputStream(InputStream instreams){
        String resultImage = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if(instreams != null){
            try {
//                File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等
//                FileOutputStream fos=new FileOutputStream(file);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = instreams.read(b)) != -1) {
                    os.write(b, 0, nRead);
                }
                os.flush();
                System.out.println(os.toString());
                resultImage = new String("data:image/png;base64," + Base64.encodeBase64String(os.toByteArray()));
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
        return resultImage;
    }

    public static String getre(String scenes,String access_token) throws Exception {
        try
        {
//            GetUrlS();
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+access_token);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            paramJson.put("scene", scenes);
            paramJson.put("page", "pages/index/index");
            paramJson.put("width", 430);
            paramJson.put("auto_color", true);
            /**
             * line_color生效
             * paramJson.put("auto_color", false);
             * JSONObject lineColor = new JSONObject();
             * lineColor.put("r", 0);
             * lineColor.put("g", 0);
             * lineColor.put("b", 0);
             * paramJson.put("line_color", lineColor);
             * */

            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
        int responseCode = httpURLConnection.getResponseCode();
        if(responseCode!=200){
            return String.valueOf(responseCode);
        }
        BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            InputStream input = httpURLConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len1 = 0;
            byte[] b = new byte[1024];
            while ((len1 = input.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len1);
            }
            byte[] buffer =  baos.toByteArray();



            String resultImage = new String("data:image/png;base64," + Base64.encodeBase64String(buffer));

            OutputStream os = new FileOutputStream(new File("D:/xzyhImg/images/productImg/abc.png"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1)
            {
                os.write(arr, 0, len);
                os.flush();
            }

            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//        return resultImage;
        return null;

    }


}
