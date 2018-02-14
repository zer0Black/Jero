package com.lxt.common.utils;

import com.lxt.common.exception.DateNotFindException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/** 
* DateUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 14, 2017</pre> 
* @version 1.0 
*/ 
public class DateUtilsTest { 

    Date date1;
    Date date2;
    Date date3;
    Date date4;

    Calendar calendar1;
    Calendar calendar2;

@Before
public void before() throws Exception {
    date1 = new Date(2017, 3, 14, 18, 33, 22);
    date2 = new Date(2017, 4, 15, 18, 33, 22);
    date3 = new Date(2017, 3, 14, 18, 33, 22);
    date4 = new Date(2017, 4, 14, 18, 33, 23);

    calendar1 = Calendar.getInstance();
    calendar1.set(2017, 3, 10, 15, 39, 21);
    calendar2 = Calendar.getInstance();
    calendar2.set(2017, 3, 11, 16, 49, 33);
}

@After
public void after() throws Exception { 
} 

@Test
public void testDiffYearForDate1Date2() throws Exception {
    assertEquals(0, DateUtils.diffYear(date1, date2));
}

@Test
public void testDiffYearForCalendar1Calendar2() throws Exception {
    assertEquals(0, DateUtils.diffYear(calendar1, calendar2));
}

@Test
public void testDiffMonthForDate1Date2() throws Exception {
    assertEquals(1, DateUtils.diffMonth(date1, date2));
}

@Test(expected = DateNotFindException.class)
public void testDiffMonthForCalendar1Calendar2() throws Exception {
    assertEquals(0, DateUtils.diffMonth(calendar1, calendar2));
    DateUtils.diffMonth(calendar1, null);
}

@Test(expected = DateNotFindException.class)
public void testDiffDayForDate1Date2() throws Exception {
    assertEquals(31, DateUtils.diffDay(date1, date2));
    DateUtils.diffDay(null, date2);
}

@Test(expected = DateNotFindException.class)
public void testDiffDayForCalendar1Calendar2() throws Exception {
    assertEquals(1, DateUtils.diffDay(calendar1, calendar2));
    DateUtils.diffDay(calendar2, null);
}

@Test
public void testDiffHouseForDate1Date2() throws Exception {
    assertEquals(744, DateUtils.diffHouse(date1, date2));
    assertEquals(720, DateUtils.diffHouse(date3, date4));

}

@Test(expected = DateNotFindException.class)
public void testDiffHouseForCalendar1Calendar2() throws Exception {
    assertEquals(25, DateUtils.diffHouse(calendar1, calendar2));
    DateUtils.diffHouse(null, calendar1);
}

@Test
public void testDiffMinuteForDate1Date2() throws Exception {
    assertEquals(43200, DateUtils.diffMinute(date3, date4));
}

@Test
public void testDiffMinuteForCalendar1Calendar2() throws Exception {
    assertEquals(1510, DateUtils.diffMinute(calendar1, calendar2));
}

@Test
public void testDiffSecondForDate1Date2() throws Exception {
    assertEquals(2592001, DateUtils.diffSecond(date3, date4));
}

@Test
public void testDiffSecondForCalendar1Calendar2() throws Exception {
    assertEquals(90612, DateUtils.diffSecond(calendar1, calendar2));
}

} 
