package tech.wangj.pickimage.utils;

import android.os.Environment;

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
}
