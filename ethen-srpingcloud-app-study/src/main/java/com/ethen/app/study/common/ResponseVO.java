package com.ethen.app.study.common;

public class ResponseVO<T> implements Cloneable {

    private static final ResponseVO SUCCESS = new ResponseVO(0, "success");

    private int code;
    private String msg;
    private T data;

    public ResponseVO() {
    }

    public ResponseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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


    public static <T> ResponseVO<T> success(T data) {
        ResponseVO<T> responseVO = new ResponseVO<>(0, "OK");
        responseVO.setData(data);
        return responseVO;
    }
}
