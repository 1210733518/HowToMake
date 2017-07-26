package model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by 腾蛇小怪 on 2017/7/23.
 */

public class InstallApk {
    public static void InstallApk(Activity act,File file){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.parse("file://"+file.getAbsolutePath()),
                "application/vnd.android.package-archive");
        act.startActivity(intent);
    }

}
