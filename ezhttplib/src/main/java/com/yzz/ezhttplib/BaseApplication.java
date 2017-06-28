package com.yzz.ezhttplib;

import android.app.Application;

import com.yzz.ezhttplib.util.ContextHolder;

/**
 * Created by yzz on 2017/6/27.
 */

public class BaseApplication extends Application {


    /**
     * 代码分割 >64k
     */
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        MultiDex.install(newBase);
//        super.attachBaseContext(newBase);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.initial(this);
    }
}
