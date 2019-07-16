package com.ethen.gateway.enumeration;

public enum FilterType {
    pre, //路由之前
    routing,//路由之时
    post,//路由之后
    error//发送错误调用
}
