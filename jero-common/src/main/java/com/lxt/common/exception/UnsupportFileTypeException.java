package com.lxt.common.exception;

/**
 * 不支持的文件类型异常
 *
 * @author zer0
 * @version 1.0
 */
public class UnsupportFileTypeException extends Exception{

    private String error;

    public UnsupportFileTypeException(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
