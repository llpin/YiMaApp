package com.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by linlipin on 17/7/3.
 */

public class ToastUtil {
    private static boolean enable = true;

    private static Toast toast;

    public static boolean isEnable() {
        return enable;
    }

    public static void setEnable(boolean enable) {
        ToastUtil.enable = enable;
    }

    public static void  showShort(Context ct, String str){
        if (isEnable())
            showToast(ct, str, Toast.LENGTH_SHORT);
    }

    public static void  showLong(Context ct, String str){
        if (isEnable())
            showToast(ct, str, Toast.LENGTH_LONG);
    }

    public static void showToast(Context context,
                                 String content, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    duration);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}
