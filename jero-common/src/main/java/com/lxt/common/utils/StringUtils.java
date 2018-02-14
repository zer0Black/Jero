package com.lxt.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 *
 * @version 1.0
 * @author  zer0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 从0~9中随机选择 bit 位生成字符串
     * @param bit 所生成字符串长度，默认6位
     * @return 数字随机组成的字符串
     */
    public static String randomNum(int bit){
        if (bit <= 0){
            bit = 6;
        }
        return RandomStringUtils.randomNumeric(bit);
    }

    /**
     * 从0~9、a~z、A~Z中随机选择 bit 位生成字符串
     * @param bit 所生成字符串长度，默认6位
     * @return 数字、字母随机组成的字符串
     */
    public static String random(int bit){
        if (bit <= 0){
            bit = 6;
        }
        return RandomStringUtils.random(bit, true, true);
    }

    /**
     * 从0~9、a~z中随机选择 bit 为生成字符串
     * @param bit 所生成字符串长度，默认6位
     * @return 数字、小写字母随机组成的字符串
     */
    public static String randomLower(int bit){
        return lowerCase(random(bit));
    }

    /**
     * 从0~9、A~Z中随机选择 bit 为生成字符串
     * @param bit 所生成字符串长度，默认6位
     * @return 数字、大写字母随机组成的字符串
     */
    public static String randomUpper(int bit){
        return upperCase(random(bit));
    }

    /**
     * 判断字符串是否为数字表示
     * @param str 判断的字符串
     * @return 为数字返回true，不为数字返回false
     */
    public static boolean isNumber(String str){
        boolean res = false;
        if (str != null && str.length() > 0){
            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher m = pattern.matcher(str);
            if (m.find()){
                res = true;
            }
        }
        return res;
    }

    /**
     * 判断字符串是否为浮点型表示
     * @param str 判断的字符串
     * @return 为浮点型返回true，不为浮点型返回false
     */
    public static boolean isFloat(String str){
        boolean res = false;
        if (str != null && str.length() > 0){
            Pattern pattern = Pattern.compile("^\\d+\\.\\d*$");
            Matcher m = pattern.matcher(str);
            if (m.find()){
                res = true;
            }
        }
        return res;
    }

    /**
     * 判断字符串是否为纯字母
     * @param str 判断的字符串
     * @return 为纯字母返回true，不为纯字母返回false
     */
    public static boolean isLetter(String str){
        boolean res = false;
        if (str != null && str.length() > 0){
            Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
            Matcher m = pattern.matcher(str);
            if (m.find()){
                res = true;
            }
        }
        return  res;
    }

    /**
     * 判断字符串是否为纯中文
     * @param str 判断的字符串
     * @return 为纯中文返回true，不为纯中文返回false
     */
    public static boolean isChinese(String str){
        boolean res = false;
        if (str != null && str.length() > 0){
            Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]+$");
            Matcher m = pattern.matcher(str);
            if (m.find()){
                res = true;
            }
        }
        return res;
    }



}
