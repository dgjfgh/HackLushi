import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.File;
import java.util.concurrent.TimeUnit;

import jdk.nashorn.internal.objects.Global;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import sun.rmi.runtime.Log;

/**
 * Created by majianghua on 2019/3/8.
 */
public class Test {

//    @org.junit.Test
//    public void test(){
//        File file = new File("C:/Users/pc/Desktop/screen.png");
//        uploadFile(file.getAbsolutePath());
//    }
//
//    public static void uploadFile(String filepath) {
//        String url = "http://144.52.16.198:8762/file/upload";
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(40, TimeUnit.SECONDS)//设置连接超时时间
//                .readTimeout(40, TimeUnit.SECONDS)//设置读取超时时间
//                .build();
//
//        String filename = "aa";
//        if (filepath.lastIndexOf("/") != -1) {
//            filename = filepath.substring(filepath.lastIndexOf("/") + 1);
//        }
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("file", filename,
//                        RequestBody.create(MediaType.parse("multipart/form-data"), new File(filepath)))
//                .build();
//
//        okhttp3.Request request = new okhttp3.Request.Builder()
//                .header("Authorization", "B")
//                .url(url)
//                .post(requestBody)
//                .build();
//
//        try {
//            okhttp3.Response response = client.newCall(request).execute();
//            if (response.code() == 200) {
//                String data = response.body().string();
//                System.out.println(data);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}