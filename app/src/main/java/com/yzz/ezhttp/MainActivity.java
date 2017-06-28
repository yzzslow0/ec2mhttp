package com.yzz.ezhttp;

import android.app.Activity;
import android.os.Bundle;

import com.yzz.ezhttp.modle.ReModel;
import com.yzz.ezhttp.service.TestService;
import com.yzz.ezhttplib.retrofit.RetrofitUtil;
import com.yzz.ezhttplib.rxutil.BaseObserver;
import com.yzz.ezhttplib.rxutil.RxUtil;
import com.yzz.ezhttplib.retrofit.model.HttpResult;
import com.yzz.ezhttplib.util.L;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends Activity {

    private Map<String, String> params = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        params.put("username","123321");
        params.put("password","1wwedgvf");

        RetrofitUtil.getInstance()
                .create(TestService.class)
                .httppost("user/login",params)
                .compose(RxUtil.<HttpResult>all_io())
                .subscribe(new BaseObserver<HttpResult>() {
                    @Override
                    public void onFailed(String message) {
                        L.v(message);
                    }

                    @Override
                    protected void onSuccess(HttpResult response) {
                        L.i(response.getData()+"");
                    }


                });


    }
}
