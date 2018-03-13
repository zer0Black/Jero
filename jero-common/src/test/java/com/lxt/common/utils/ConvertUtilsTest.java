package com.lxt.common.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
* ConvertUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 16, 2017</pre> 
* @version 1.0 
*/ 
public class ConvertUtilsTest {

    Date date;

    @Before
    public void before() throws Exception {
        date = new Date(2017-1900, 8-1, 2, 11, 22, 33);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFormatStrFromDate() throws Exception {
        assertEquals("2017-08-02", ConvertUtils.formatStrFromDate(date));
    }

    @Test
    public void testFormatStrFromTime() throws Exception {
        assertEquals("2017-08-02 11:22:33", ConvertUtils.formatStrFromTime(date));
    }

    @Test
    public void testStrToDateStr() throws Exception {
        assertEquals(date, ConvertUtils.strToDate("2017-08-02 11:22:33"));
    }

    @Test(expected = ParseException.class)
    public void testStrToDateForStrPattern() throws Exception {
        assertEquals(date, ConvertUtils.strToDate("2017/08/02 11:22:33", "yyyy/MM/dd HH:mm:ss"));
        assertEquals(date, ConvertUtils.strToDate("2017-08-02 11:22:33", null));
        assertNotEquals(date, ConvertUtils.strToDate("2017/08/02 11:22:33", null));
    }

}
