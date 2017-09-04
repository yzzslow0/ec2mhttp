package com.yzz.ezhttplib.util.upload;

/**
 * Created by yzz on 2017/8/18.
 */

public class BaseResponse<T> {
    public int code;
    public String msg;
    public T data;
}