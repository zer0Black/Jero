package com.lxt.common.utils;

import com.lxt.common.exception.DateNotFindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换操作工具类
 *
 * @author zer0
 * @version 1.0
 */
public class ConvertUtils extends org.apache.commons.beanutils.ConvertUtils{

    /**
     * 日期（年月日）转换为字符串
     * @param date
     * @return 转换后的日期字符串
     */
    public static String formatStrFromDate(Date date){
        if (date == null){
            throw new DateNotFindException("时间参数不存在");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 日期（年月日时分秒）转换为字符串
     * @param date
     * @return
     */
    public static String formatStrFromTime(Date date) {
        if (date == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串转换为时间
     * @param str
     * @return 转换后的日期
     * @throws ParseException
     */
    public static Date strToDate(String str) throws ParseException{
        return strToDate(str, null);
    }

    /**
     * 字符串转换为时间
     * @param str
     * @param pattern 字符串模式
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str, String pattern) throws ParseException{
        if (pattern == null){
            pattern = "yyyy-MM-dd hh:mm:ss";
        }
        return DateUtils.parseDate(str, pattern);
    }

}
