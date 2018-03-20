package com.lxt.core.http;

import java.io.Serializable;

/**
 * 返回对象
 *
 * @author zer0
 * @version 1.0
 */
public class ResponseMessage<T> implements Serializable{

    private static final long serialVersionUID = 2999784516561316773L;

    private int respCode;
    private String message;
    private T data;
    private boolean ok;

    public ResponseMessage() {
    }

    public ResponseMessage(int respCode, String message) {
        this.respCode = respCode;
        this.message = message;
    }

    public ResponseMessage(int respCode, String message, boolean ok, T data) {
        this.respCode = respCode;
        this.message = message;
        this.ok = ok;
        this.data = data;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

}
