package com.common.pojo.params;

/**
 * Created by linlipin on 18/3/1.
 */

public class ResultData<T> extends ResultModel {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
