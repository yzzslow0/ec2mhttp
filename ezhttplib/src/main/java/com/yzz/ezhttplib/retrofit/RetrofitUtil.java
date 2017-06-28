package com.yzz.ezhttplib.retrofit;

import android.content.Context;

import com.yzz.ezhttplib.retrofit.cookie.AddCookiesInterceptor;
import com.yzz.ezhttplib.retrofit.cookie.SaveCookiesInterceptor;
import com.yzz.ezhttplib.retrofit.interceptor.BaseInterceptor;
import com.yzz.ezhttplib.retrofit.interceptor.CaheInterceptor;
import com.yzz.ezhttplib.util.ContextHolder;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yzz on 2017/6/27.
 */

public class RetrofitUtil {

    public static String IP = "";

    private static final int DEFAULT_TIMEOUT = 20;
    private static RetrofitUtil mReInstance;
    private static Retrofit mRetrofit;
    private static Map<String, String> headers;


    public static RetrofitUtil getInstance() {
        if (mReInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mReInstance == null) {
                    mReInstance = new RetrofitUtil(ContextHolder.getContext(), headers);
                }
            }
        }
        return mReInstance;
    }


    public RetrofitUtil(Context context, Map<String, String> headers) {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)//连接超时
//                .sslSocketFactory(SSLHelper.getSSLCertifcation(context))//为OkHttp对象设置SocketFactory用于双向认证
                .addInterceptor(new BaseInterceptor(headers)) //基本拦截器
                .addInterceptor(new AddCookiesInterceptor(context))
                .addInterceptor(new SaveCookiesInterceptor(context))
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new CaheInterceptor())//缓存

                .cache(new Cache(new File(ContextHolder.getContext().getCacheDir(), "mReCache"), 1024 * 1024 * 10))
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(IP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//1.X为RxJavaCallAdapterFactory
                .build();


    }

    public static <T> T create(Class<T> ServiceClass) {
        return mRetrofit.create(ServiceClass);
    }



}
