package tech.wangjie.imagepicker.utils;

import android.app.Activity;
import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangj on 2016/8/22
 */
public class GloableUtils {

    /**
     * 判断SD卡是否可用
     */
    public static boolean isSdcardOK() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }


    /**判断该文件是否是一个图片。*/
    public static boolean isImage(String fileName) {
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png");
    }

    private static List<Activity> mActivityManager = new ArrayList<>(2);

    public static void addActivity(Activity target) {
        if (!mActivityManager.contains(target)) {
            mActivityManager.add(target);
        }
    }
    public static void clearActivity(Activity target) {
        if (mActivityManager.contains(target)) {
            target.finish();
        }
    }

    public static void clearAllActivity() {
        if (mActivityManager.size() > 0) {
            for (Activity target : mActivityManager) {
                target.finish();
            }
        }
    }
}
