package utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import model.DoenLoader;

/**
 * Created by 腾蛇小怪 on 2017/7/23.
 */

public class DialogUtils  {

    public static void showUpdateDialog(final Activity act,String title,String mes,final String url){
        AlertDialog.Builder builder = new AlertDialog.Builder(act);

        builder.setTitle(title);
        builder.setMessage(mes);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                downloadAndInstall(act,url);
            }
        });
        AlertDialog alertDialog = builder.create();
    }
        private static void downloadAndInstall(Activity act, String url) {
            DoenLoader.downLoadAndInstallApk(act,url);
        }
}
