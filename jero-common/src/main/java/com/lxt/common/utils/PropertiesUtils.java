package com.lxt.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * properties配置文件操作工具类
 *
 * @author zer0
 * @version 1.0
 */
public class PropertiesUtils {

    Properties properties = new Properties();

    public PropertiesUtils(String fileName){
        InputStream is = null;
        try {
            is = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String readProperty(String key){
        if (key == null || properties.getProperty(key) == null){
            throw new NoSuchElementException();
        }
        String value = properties.getProperty(key);
        return value;
    }

}
