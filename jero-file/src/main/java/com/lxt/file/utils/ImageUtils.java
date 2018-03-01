package com.lxt.file.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 图片类常用工具
 *
 * @author zer0
 * @version 1.0
 */
public class ImageUtils {

    /**
     * 是否是fastdfs支持的图片格式
     * @param fileExt
     * @return
     */
    public static boolean isFastdfsSupportImage(String fileExt){
        final String[] SUPPORT_IMAGE_TYPE = { "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP" };
        final List<String> SUPPORT_IMAGE_LIST = Arrays.asList(SUPPORT_IMAGE_TYPE);
        if (SUPPORT_IMAGE_LIST.contains(fileExt.toUpperCase())){
            return true;
        }else{
            return false;
        }
    }

}
