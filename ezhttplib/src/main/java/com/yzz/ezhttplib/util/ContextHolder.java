package com.yzz.ezhttplib.util;

import android.content.Context;

/**
 * Created by yzz on 2017/6/27.
 */

public class ContextHolder {

    static Context ApplicationContext;
    public static void initial(Context context) {
        ApplicationContext = context;
    }
    public static Context getContext() {
        return ApplicationContext;
    }
}
