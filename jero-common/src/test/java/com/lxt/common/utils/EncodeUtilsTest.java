package com.lxt.common.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testEncodeUrlSafeBase64() throws Exception{
        assertEquals("5YS_5a2Q", EncodeUtils.encodeUrlSafeBase64("儿子".getBytes()));
        assertEquals("6K-06K-d", EncodeUtils.encodeUrlSafeBase64("说话".getBytes()));
    }

    @Test
    public void testEscapeHtml() throws Exception{
        assertEquals("&lt;html lang=&quot;zh_cn&quot;&gt;", EncodeUtils.escapeHtml("<html lang=\"zh_cn\">"));
        assertEquals("&lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=utf-8&quot; /&gt;",
                EncodeUtils.escapeHtml("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"));
    }

    @Test
    public void testUnescapeHtml() throws Exception{
        assertEquals("<html lang=\"zh_cn\">", EncodeUtils.unescapeHtml("&lt;html lang=&quot;zh_cn&quot;&gt;"));
        assertEquals("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />",
                EncodeUtils.unescapeHtml("&lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=utf-8&quot; /&gt;"));
    }

    @Test
    public void testUrlEncode() throws Exception{
        assertEquals("http%3A%2F%2Fwww.baidu.com%2Fs%3Fie%3Dutf-8%26f%3D8%26tn%3Dbaidu+%26wd%3D%E4%B8%B4%E6%97%B6%E9%82%AE%E7%AE%B1",
                EncodeUtils.urlEncode("http://www.baidu.com/s?ie=utf-8&f=8&tn=baidu &wd=临时邮箱"));
    }

    @Test
    public void testUrlDecode() throws Exception{
        //小写解码
        assertEquals("http://www.baidu.com/s?ie=utf-8&f=8&tn=baidu &wd=临时邮箱",
                EncodeUtils.urlDecode("http%3a%2f%2fwww.baidu.com%2fs%3fie%3dutf-8%26f%3d8%26tn%3dbaidu+%26wd%3d%e4%b8%b4%e6%97%b6%e9%82%ae%e7%ae%b1"));
        //大写解码
        assertEquals("http://www.baidu.com/s?ie=utf-8&f=8&tn=baidu &wd=临时邮箱",
                EncodeUtils.urlDecode("http%3A%2F%2Fwww.baidu.com%2Fs%3Fie%3Dutf-8%26f%3D8%26tn%3Dbaidu+%26wd%3D%E4%B8%B4%E6%97%B6%E9%82%AE%E7%AE%B1"));
    }

}
