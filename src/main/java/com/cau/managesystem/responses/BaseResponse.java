package com.cau.managesystem.responses;


public abstract class BaseResponse<T> {
    public int code;
    public String result;
    public String message;
    public T data;

    public void buildSuccess(){
        this.code=200;
        this.result="success";
    }

    public void buildFail(){
        this.code=0;
        this.result="fail";
    }
    public void buildFail(String errMsg){
        this.code=0;
        this.result="fail";
        this.message = errMsg;
    }
}


