package com.lxt.file.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lxt.common.exception.UnsupportFileTypeException;
import com.lxt.common.utils.FileUtils;
import com.lxt.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * fastDFS客户端工具类
 *
 * @author zer0
 * @version 1.0
 */
@Component
public class FastDFSClientWrapper {

    private static Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 上传文件到服务器
     * @param file
     * @return String
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath path = storageClient.uploadFile(file.getInputStream(),
                file.getSize(),
                FileUtils.getExtend(file.getOriginalFilename()),
                null);
        return path.getFullPath();
    }

    /**
     * 上传图片并生成缩略图
     * @param file
     * @return
     * @throws IOException
     */
    public String uploadImageAndCrtThumbImage(MultipartFile file) throws IOException, UnsupportFileTypeException {
        final String[] SUPPORT_IMAGE_TYPE = { "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP" };
        final List<String> SUPPORT_IMAGE_LIST = Arrays.asList(SUPPORT_IMAGE_TYPE);

        String fileExtName =  FileUtils.getExtend(file.getOriginalFilename());
        if (SUPPORT_IMAGE_LIST.contains(fileExtName.toUpperCase())){
            throw new UnsupportFileTypeException("不支持的文件格式，请保证文件是常见图片格式");
        }

        StorePath path = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(),
                file.getSize(),
                FileUtils.getExtend(file.getOriginalFilename()),
                null);
        return path.getFullPath();
    }

    /**
     * 删除文件
     * @param fileUrl
     * @return boolean
     */
    public boolean deleteFile(String fileUrl){
        if (StringUtils.isEmpty(fileUrl)) return false;
        try{
            StorePath path = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(path.getGroup(), path.getPath());
        }catch (FdfsUnsupportStorePathException e){
            logger.warn(e.getMessage());
            return false;
        }
        return true;
    }

}
