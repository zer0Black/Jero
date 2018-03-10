package com.lxt.common.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/** 
* StringUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 13, 2017</pre> 
* @version 1.0 
*/ 
public class EncodeUtilsTest {

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    @Test
    public void testEncodeHex() throws Exception {
        assertEquals("61646d696e", EncodeUtils.encodeHex("admin".getBytes()));
        assertEquals("74657374", EncodeUtils.encodeHex("test".getBytes()));
        assertNotEquals("61646d696e", EncodeUtils.encodeHex("test".getBytes()));
    }

    @Test
    public void testDecodeHex() throws Exception{
        assertArrayEquals("admin".getBytes(), EncodeUtils.decodeHex("61646d696e"));
        assertArrayEquals("test".getBytes(), EncodeUtils.decodeHex("74657374"));
    }

    @Test
    public void testEncodeBase64() throws Exception{
        assertEquals("YWRtaW4=", EncodeUtils.encodeBase64("admin".getBytes()));
        assertEquals("dGVzdCBpcyBhIGdvb2Rz",
                EncodeUtils.encodeBase64("test is a goods".getBytes()));
    }

    @Test
    public void testDecodeBase64() throws Exception{
        assertArrayEquals("admin".getBytes(), EncodeUtils.decodeBase64("YWRtaW4="));
        assertArrayEquals("test is a goods".getBytes(), EncodeUtils.decodeBase64("dGVzdCBpcyBhIGdvb2Rz="));
    }

}
