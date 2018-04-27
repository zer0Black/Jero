package com.lxt.core.util;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 校验工具类，处理校验后的错误信息
 *
 * @author lixuetao
 * @version 1.0
 */
public class ValidatedUtil {

    public static String assembleErros(List<ObjectError> errors){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < errors.size(); i++) {
            stringBuilder.append(errors.get(i).getDefaultMessage());
            if (i != errors.size() - 1){
                stringBuilder.append("\\n");
            }
        }
        return stringBuilder.toString();
    }

}
