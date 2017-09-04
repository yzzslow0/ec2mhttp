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

 public abstract class BaseObserver<T> implements Observer<T> {



    protected abstract void onFailed(String message);

    protected abstract void onSuccess(T response);



    @Override
    public void onSubscribe(Disposable d) {
        Log.v("Http is Start","");
        if (!NetUtil.isNetworkAvailable()) {
            Log.v("BaseSubscriber","无网络");
            onComplete();
        }
    }



    @Override
    public void onError(Throwable e) {
        // todo error somthing
        L.d("BaseObserver", e.getMessage());
        onFailed(e.getMessage());
        onFinish();
    }

    private void onFinish() {
        L.v("BaseObserver", "请求完成");
    }


    @Override
    public void onComplete() {
        L.v("BaseSubscriber_onCompleted", "请求完成");
    }
}
