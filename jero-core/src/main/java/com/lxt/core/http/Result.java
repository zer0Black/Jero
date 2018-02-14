package com.lxt.core.http;

import com.lxt.core.enums.Code;

public class Result {

    private static final ResponseMessage RESPONSE_MESSAGE_SUCCESS = new ResponseMessage(Code.SUCCESS.getCode(), "", true, null);

    public static ResponseMessage success() {
        return RESPONSE_MESSAGE_SUCCESS;
    }

    public static <T> ResponseMessage<T> success(int code, T t) {
        return new ResponseMessage(code, "", true, t);
    }

    public static <T> ResponseMessage<T> success(Code code, T t) {
        return new ResponseMessage(code.getCode(), code.getMsg(), true, t);
    }

    public static <T> ResponseMessage<T> success(int code, String message, T t) {
        return new ResponseMessage(code, message, true, t);
    }

    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage(Code.SUCCESS.getCode(), "", true, t);
    }

    public static ResponseMessage error() {
        return error("");
    }

    public static ResponseMessage error(String message) {
        return error(Code.ERROR.getCode(), message);
    }

    public static ResponseMessage error(Code code){
        return error(code.getCode(), code.getMsg(), null);
    }

    public static <T> ResponseMessage<T> error(Code code, T t) {
        return error(code.getCode(), code.getMsg(), t);
    }

    public static ResponseMessage error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> ResponseMessage<T> error(int code, String message, T t) {
        return new ResponseMessage(code, message, false, t);
    }
}
