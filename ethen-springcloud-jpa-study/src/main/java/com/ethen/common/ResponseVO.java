package com.ethen.common;

public class ResponseVO<T> {
    public static final ResponseVO SUCCESS_RESULT = new ResponseVO(0, "OK");
    public static final ResponseVO FAIL_RESULT = new ResponseVO(1, "FAIL");

    private int code;
    private String msg;
    private T data;

    public ResponseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseVO() {
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

    public boolean isSuccess() {
        return code == SUCCESS_RESULT.getCode();
    }

    public static <T> ResponseVO<T> success(T data) {
        ResponseVO<T> response = new ResponseVO<>(0, "OK");
        if (data != null) {
            response.setData(data);
        }
        return response;
    }


    @Override
    public String toString() {
        return "ResponseVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
