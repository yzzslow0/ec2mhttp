package com.yzz.ezhttp;

import com.yzz.ezhttplib.BaseApplication;
import com.yzz.ezhttplib.retrofit.RetrofitUtil;

/**
 * Created by yzz on 2017/6/28.
 */

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitUtil.IP = "http://172.16.0.167:8080";
    }
}
