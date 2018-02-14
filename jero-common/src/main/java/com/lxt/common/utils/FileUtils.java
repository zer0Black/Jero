package com.lxt.common.utils;

import java.io.*;

/**
 * 文件操作工具类
 *
 * @author zer0
 * @version 1.0
 */
public class FileUtils extends org.apache.commons.io.FileUtils{

    /**
     * 获取文件扩展名
     * @param fileName 文件名
     * @return
     */
    public static String getExtend(String fileName){
        if(StringUtils.isBlank(fileName)){
            throw new IllegalArgumentException("文件名不能为空");
        }
        int index = fileName.lastIndexOf(".");
        if(index > 0 && index < fileName.length() - 1){
            return fileName.substring(index + 1).toLowerCase();
        }
        throw new IllegalArgumentException("文件名不正确");
    }

    /**
     * 获取文件名，不带文件拓展名
     * @param fileName 文件名
     * @return
     */
    public static String getFileName(String fileName){
        if (StringUtils.isBlank(fileName)){
            throw new IllegalArgumentException("文件名不能为空");
        }
        int index = fileName.lastIndexOf(".");
        if(index > 0 && index < fileName.length() - 1){
            return fileName.substring(0, index).replaceAll("\\s*", "");
        }else{
            return fileName;
        }
    }

    /**
     * 获取文件名
     * @param path 路径名
     * @return
     */
    public static String getFileNameFromPath(String path){
        if (StringUtils.isBlank(path)){
            throw new IllegalArgumentException("路径不能为空");
        }

        path = uniformSeparator(path);
        String[] fileName = path.split("/");
        if (fileName == null || fileName.length <= 0){
            throw new IllegalArgumentException("路径不正确");
        }

        return fileName[fileName.length - 1];
    }

    /**
     * 判断文件是否存在
     * @param fileName 文件路径+文件名
     * @return
     */
    public static boolean checkFile(String fileName){
        if (StringUtils.isBlank(fileName)){
            return false;
        }

        File file = new File(fileName);
        if(file.exists()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 删除文件
     * @param fileName 文件名
     * @return boolean 是否删除成功
     */
    public static boolean deleteFile(String fileName){
        if (StringUtils.isBlank(fileName)){
            return false;
        }

        File fileDelete = new File(fileName);
        if (!fileDelete.exists() || !fileDelete.isFile()) {
            return false;
        }

        return fileDelete.delete();
    }

    /**
     * 批量删除文件
     * @param fileNames 文件名
     * @return
     */
    public static void deleteFileBatch(String[] fileNames){
        if(fileNames == null || fileNames.length == 0){
            return;
        }

        for(int i = 0; i < fileNames.length; i++){
            File fileDelete = new File(fileNames[i]);
            if (!fileDelete.exists() || !fileDelete.isFile()) {
                fileDelete.delete();
            }
        }
    }

    /**
     * 统一分隔符为 “/”
     * @param
     * @return
     */
    public static String uniformSeparator(String path){
        if (StringUtils.isBlank(path)){
            return path;
        }

        path = path.replace("\\", "/");
        return path;
    }

}
