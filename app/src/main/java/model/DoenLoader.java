package model;

import android.app.Activity;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import httputils.OkHttpUtils;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 腾蛇小怪 on 2017/7/22.
 */

public class DoenLoader {

    public static void downLoadAndInstallApk(final Activity act, String url){
    final Request request = new Request.Builder()
            .url(url)
            .get()
            .build();
       okhttp3.Call call = OkHttpUtils.getInstance().newCall(request);
        call.enqueue((Callback) new DownLoaderCallBack(act));

    }
    private static class DownLoaderCallBack implements Callback{
        private Activity act;
        private DownLoaderCallBack(Activity act){
            this.act=act;
        }
     public void onFailure(Request request, IOException e){

     }

        @Override
        public void onFailure(okhttp3.Call call, IOException e) {

        }

        @Override
        public void onResponse(okhttp3.Call call, Response response) throws IOException {
            if (response.isSuccessful()){
                byte[] bytes = response.body().bytes();
                if (bytes!=null&&bytes.length>0){
                    File dir = new File(Environment.getExternalStorageDirectory()+"/how");
                    if (!dir.exists()){
                        dir.mkdirs();
                    }
                    File file = new File(dir,"how.apk");
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(bytes);

                    fos.close();
                    bytes=null;

                    InstallApk.InstallApk(act,file);
                }

            }
        }

    }



}
