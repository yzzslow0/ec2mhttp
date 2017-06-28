package com.yzz.ezhttplib.rxutil;

import android.util.Log;

import com.yzz.ezhttplib.retrofit.model.HttpResult;
import com.yzz.ezhttplib.util.L;
import com.yzz.ezhttplib.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by yzz on 2017/6/28.
 */

public abstract class BaseObserver<T extends HttpResult> implements Observer<T> {


    public abstract void onFailed(String message);

    protected abstract void onSuccess(String response);

//        @Override
//    public void onStart() {
//        super.onStart();
//
//        L.v("Http is Start");
//        if (!NetUtil.isNetworkAvailable()) {
//            L.v("BaseSubscriber","无网络");
//            onCompleted();
//            return;
//        }
//
//    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.v("onSubscribe", "????");
        Log.v("Http is Start","");
        if (!NetUtil.isNetworkAvailable()) {
            Log.v("BaseSubscriber","无网络");
            onComplete();
            return;
        }
    }

    @Override
    public void onNext(T response) {
        if (response.getState() == 0) {
            L.i("BaseObserver", "onNext");
            onSuccess(response + "");
        } else {
            onFailed(response.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        // todo error somthing
        L.d("BaseObserver", e.getMessage());
        onFailed(e.getMessage());
        onFinish();
    }

    public void onFinish() {
        L.v("BaseObserver", "请求完成");
    }


    @Override
    public void onComplete() {
        L.v("BaseSubscriber_onCompleted", "请求完成");
    }
}
