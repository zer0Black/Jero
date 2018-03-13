package com.lxt.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 文件工具类测试包
 *
 * @author lixuetao
 * @version 1.0
 */
public class FileUtilsTest {

    private String path = "http://www.lxt.com/path/excel.xls";
    private String fileName = "test.pdf";

    @Test(expected = IllegalArgumentException.class)
    public void testGetExtendFileNameBlank(){
        FileUtils.getExtend("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExtendFileNameNull(){
        FileUtils.getExtend(null);
    }

    @Test
    public void testGetExtend(){
        assertEquals("pdf", FileUtils.getExtend(fileName));
        assertEquals("xls", FileUtils.getExtend(path));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFileNameBlank(){
        FileUtils.getFileName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFileNameNull(){
        FileUtils.getFileName(null);
    }

    @Test
    public void testGetFileName(){
        assertEquals("test", FileUtils.getFileName(fileName));
        assertEquals("test", FileUtils.getFileName("te st.jpg"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFileNameFromPathBlank(){
        FileUtils.getFileNameFromPath("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFileNameFromPathNull(){
        FileUtils.getFileNameFromPath(null);
    }

    @Test
    public void testGetFileNameFromPath(){
        assertEquals("excel.xls", FileUtils.getFileNameFromPath(path));
        assertEquals("1.pdf", FileUtils.getFileNameFromPath("http://a.com\\2\\1.pdf"));
    }

}