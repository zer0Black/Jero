package com.lxt.common.utils;

import com.lxt.common.exception.DateNotFindException;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间操作工具类
 *
 * @author zer0
 * @version 1.0
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

    /**
     * 计算两个日期的时间差（年）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffYear(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }

        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.years());
        return period.getYears();
    }

    /**
     * 计算两个日期的时间差（年）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffYear(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }

        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.years());
        return period.getYears();
    }

    /**
     * 计算两个日期的时间差（月）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffMonth(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.months());
        return period.getMonths();
    }

    /**
     * 计算两个日期的时间差（月）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffMonth(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.months());
        return period.getMonths();
    }

    /**
     * 计算两个日期的时间差（天）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffDay(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.days());
        return period.getDays();
    }

    /**
     * 计算两个日期的时间差（天）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffDay(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.days());
        return period.getDays();
    }

    /**
     * 计算两个日期的时间差（小时）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffHouse(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.hours());
        return period.getHours();
    }

    /**
     * 计算两个日期的时间差（小时）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffHouse(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.hours());
        return period.getHours();
    }

    /**
     * 计算两个日期的时间差（分）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffMinute(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.minutes());
        return period.getMinutes();
    }

    /**
     * 计算两个日期的时间差（分）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffMinute(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.minutes());
        return period.getMinutes();
    }

    /**
     * 计算两个日期的时间差（秒）
     * @param date1
     * @param date2
     * @return 时间差
     */
    public static int diffSecond(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.seconds());
        return period.getSeconds();
    }

    /**
     * 计算两个日期的时间差（秒）
     * @param calendar1
     * @param calendar2
     * @return 时间差
     */
    public static int diffSecond(Calendar calendar1, Calendar calendar2){
        if (calendar1 == null || calendar2 == null) {
            throw new DateNotFindException("时间参数不存在");
        }
        DateTime dateTime1 = new DateTime(calendar1);
        DateTime dateTime2 = new DateTime(calendar2);
        Period period = new Period(dateTime1, dateTime2, PeriodType.seconds());
        return period.getSeconds();
    }

    /**
     * 计算date所在周的指定星期的时间，若所指定的星期不存在，则返回星期一的值
     * @param date 获取当前时候所在周的指定星期
     * @param weekDay 指定获取星期几的时间
     * @return 指定时间的指定星期的时间
     */
    public static Date getWeekTime(Date date, int weekDay){
        if (date == null){
            throw new DateNotFindException("时间参数不存在");
        }
        if (weekDay <= 0 || weekDay > 7){
            weekDay = 1;
        }

        DateTime dateTime = new DateTime(date);
        dateTime = resetTimeZero(dateTime);
        return dateTime.withDayOfWeek(weekDay).toDate();
    }

    /**
     * 计算date所在周的指定星期的时间，若所指定的星期不存在，则返回星期一的值
     * @param calendar 获取当前时候所在周的指定星期
     * @param weekDay 指定获取星期几的时间
     * @return 指定时间的指定星期的时间
     */
    public static Calendar getWeekTime(Calendar calendar, int weekDay){
        if (calendar == null){
            throw new DateNotFindException("时间参数不存在");
        }
        if (weekDay <= 0 || weekDay > 7){
            weekDay = 1;
        }

        DateTime dateTime = new DateTime(calendar);
        dateTime = resetTimeZero(dateTime);
        return dateTime.withDayOfWeek(weekDay).toCalendar(Locale.getDefault());
    }

    /**
     * 将时分秒设置归0
     * @param dateTime 要归0的时间
     * @return
     */
    public static DateTime resetTimeZero(DateTime dateTime){
        if (dateTime == null){
            throw new DateNotFindException("时间参数不存在");
        }
        return dateTime.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0);
    }

    /**
     * 计算当前周指定星期的时间，若所指定的星期不存在，则返回星期一的值
     * @param weekDay 指定获取星期几的时间
     * @return 指定时间的指定星期的时间
     */
    public static Date getCurWeekTime(int weekDay){
        return getWeekTime(new Date(), weekDay);
    }

    /**
     * 计算指定时间的周一
     * @param date
     * @return 指定时间的周一
     */
    public static Date getMonday(Date date){
        return getWeekTime(date, 1);
    }

    /**
     * 计算指定时间的周二
     * @param date
     * @return 指定时间的周二
     */
    public static Date getTuesday(Date date){
        return getWeekTime(date, 2);
    }

    /**
     * 计算指定时间的周三
     * @param date
     * @return 指定时间的周三
     */
    public static Date getWednesday(Date date){
        return getWeekTime(date, 3);
    }

    /**
     * 计算指定时间的周四
     * @param date
     * @return 指定时间的周四
     */
    public static Date getThursday(Date date){
        return getWeekTime(date, 4);
    }

    /**
     * 计算指定时间的周五
     * @param date
     * @return 指定时间的周五
     */
    public static Date getFriday(Date date){
        return getWeekTime(date, 5);
    }

    /**
     * 计算指定时间的周六
     * @param date
     * @return 指定时间的周六
     */
    public static Date getSaturday(Date date){
        return getWeekTime(date, 6);
    }

    /**
     * 计算指定时间的周日
     * @param date
     * @return 指定时间的周日
     */
    public static Date getSunday(Date date){
        return getWeekTime(date, 7);
    }

    /**
     * 计算当前时间的周一
     * @return 当前时间的周一
     */
    public static Date getCurMonday(){
        return getWeekTime(new Date(), 1);
    }

    /**
     * 计算当前时间的周二
     * @return 当前时间的周二
     */
    public static Date getCurTuesday(){
        return getWeekTime(new Date(), 2);
    }

    /**
     * 计算当前时间的周三
     * @return 当前时间的周三
     */
    public static Date getCurWednesday(){
        return getWeekTime(new Date(), 3);
    }

    /**
     * 计算当前时间的周四
     * @return 当前时间的周四
     */
    public static Date getCurThursday(){
        return getWeekTime(new Date(), 4);
    }

    /**
     * 计算当前时间的周五
     * @return 当前时间的周五
     */
    public static Date getCurFriday(){
        return getWeekTime(new Date(), 5);
    }

    /**
     * 计算当前时间的周六
     * @return 当前时间的周六
     */
    public static Date getCurSaturday(){
        return getWeekTime(new Date(), 6);
    }

    /**
     * 计算当前时间的周日
     * @return 当前时间的周日
     */
    public static Date getCurSunday(){
        return getWeekTime(new Date(), 7);
    }

}
