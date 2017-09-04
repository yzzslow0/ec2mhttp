package com.yzz.ezhttplib.retrofit.model;

/**
 * Created by yzz on 2017/6/28.
 */

public class HttpResult <T> {

    public int state;
    public String msg;
    public T data;
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}