package com.cyq.moveenablefloatbutton.library;


import android.text.TextUtils;

/**
 *
 */
public class DataUtils {

    /**
     * 判断是否在一定范围内
     *
     * @param current
     * @param min
     * @param max
     * @return
     */
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    public static boolean isEquals(String TAG, String str1, String str2) {
        if (TextUtils.isEmpty(str1)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(str1)) {
            return true;
        }
        return false;
    }


}