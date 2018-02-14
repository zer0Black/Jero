package com.lxt.common.exception;

/**
 * Excel中表单不存在异常
 *
 * @author zer0
 * @version 1.0
 */
public class SheetNotFindException extends RuntimeException{

    private String error;

    public SheetNotFindException(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
