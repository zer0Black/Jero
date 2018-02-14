package com.lxt.core.advice;

import com.lxt.core.entity.RestInfo;
import com.lxt.core.enums.Code;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常统一处理
 *
 * @author zer0
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "server error")
    @ExceptionHandler(Exception.class)
    public RestInfo resolveException(Exception exception, HttpServletRequest request){
        Throwable deepestException = deepestExcepetion(exception);
        log.error("全局异常处理捕获："+ deepestException);

        RestInfo restInfo = RestInfo.build(Code.SERVICE_DISABLED, Code.SERVICE_DISABLED.getMsg());
        return restInfo;
    }

    /**
     * 获取引发异常的源头
     * @param e
     * @return 抛出的异常
     */
    private Throwable deepestExcepetion(Throwable e){
        if (e == null){
            return new NullPointerException("异常信息不能为空");
        }

        Throwable tmp = e;
        int breakPoint = 0;
        while (tmp.getCause() != null){
            if (tmp.equals(tmp.getCause())){
                break;
            }
            tmp = tmp.getCause();
            breakPoint++;
            if (breakPoint > 1000){
                break;
            }
        }
        return tmp;
    }
}
