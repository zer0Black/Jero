package com.lxt.common.exception;

/**
 * @author zer0
 * @version 1.0
 */
public class DateNotFindException extends RuntimeException{

    private String error;

    public DateNotFindException(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
