package com.yzz.ezhttplib.rxutil;

import com.yzz.ezhttplib.util.ContextHolder;
import com.yzz.ezhttplib.util.download.DownLoadManager;

import okhttp3.ResponseBody;

/**
 * Created by yzz on 2017/8/16.
 */

public abstract class DownloadObserver<T> extends BaseObserver<T> {

    @Override
    public void onNext(Object response) {
         if (DownLoadManager.writeResponseBodyToDisk(ContextHolder.getContext(), (ResponseBody) response)) {

          }
    }



}



