package utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by 腾蛇小怪 on 2017/7/24.
 */

public class PackageUtils {
    public String getCurrenVersion(Activity activity) throws PackageManager.NameNotFoundException {
        PackageManager pm = activity.getPackageManager();
        PackageInfo packageItemInfo = pm.getPackageInfo("com.guaju.howtomakeanapp", 0);
        String versionName = packageItemInfo.versionName;
        if (TextUtils.isEmpty(versionName)){
            return "";
        }
        return versionName;
    }
}
