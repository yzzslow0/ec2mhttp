package com.yzz.ezhttp.service;

import com.yzz.ezhttp.modle.ReModel;
import com.yzz.ezhttplib.retrofit.model.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by yzz on 2017/6/27.
 */

public  interface TestService {

    @POST()
    Observable<HttpResult> httppost(
            @Url String url,
            @QueryMap Map<String, String> maps);
    @POST()
    Observable<ResponseBody> httppost2(
            @Url String url,
            @QueryMap Map<String, String> maps);
}
