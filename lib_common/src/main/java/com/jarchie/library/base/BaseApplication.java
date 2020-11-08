package com.jarchie.library.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jarchie.library.BuildConfig;

/**
 * 作者：created by Jarchie
 * 时间：2020/9/9 17:16:25
 * 邮箱：jarchie520@gmail.com
 * 说明：应用Application类
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
