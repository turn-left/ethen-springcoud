package com.ethen.kafka;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡夫卡消息定义
 */
public class Message implements Serializable {
    private long msgId; //消息id
    private int code;   //返回码
    private String msg; //消息内容
    private Date startTime;//时间戳
    private Date sendTime; //时间戳
    private String logPath;//日志地址

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
}
