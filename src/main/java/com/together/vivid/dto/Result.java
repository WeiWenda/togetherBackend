package com.together.vivid.dto;

import com.together.vivid.entity.User;

/**
 * Created by weiwenda on 2017/9/27.
 */
public class Result<T> {

    private boolean success;
    private T data;
    private String error;// 错误信息

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return success;
    }
    public T getData() {
        return data;
    }

    // 成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    // 成功T为String时的构造器
    public Result(T data,boolean success) {
        this.success = success;
        if(success)
            this.data = data;
        else
            this.error =data.toString();
    }
    // 错误时的构造器
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
