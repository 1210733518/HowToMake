package httputils;

import okhttp3.OkHttpClient;

/**
 * Created by 腾蛇小怪 on 2017/7/21.
 */

public class OkHttpUtils {

    private static OkHttpUtils okUtils = new OkHttpUtils();
    private static OkHttpClient okHttpClient;

    private OkHttpUtils(){
        okHttpClient = new OkHttpClient();

    }


    public static OkHttpClient getInstance(){
        return okHttpClient;
    }

}
