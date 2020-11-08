package com.jarchie.library.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-07 23:06
 * 邮箱: jarchie520@gmail.com
 * 描述:
 */
public class UiUtil {

    public static int getStatusBarHeight(Context context){
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0){
            return context.getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }

    public static void setHeightAndPadding(Context context, View view){
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height += getStatusBarHeight(context);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
    }
}
