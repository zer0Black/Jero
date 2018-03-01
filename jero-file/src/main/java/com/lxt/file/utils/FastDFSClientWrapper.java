package com.lxt.file.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lxt.common.exception.UnsupportFileTypeException;
import com.lxt.common.utils.FileUtils;
import com.lxt.common.utils.StringUtils;
import com.lxt.file.entity.FileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
        String fileExt =  FileUtils.getExtend(file.getOriginalFilename());
        if (!ImageUtils.isFastdfsSupportImage(fileExt)){
            throw new UnsupportFileTypeException("不支持的文件格式，请保证文件是常见图片格式");
        }

        StorePath path = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(),
                file.getSize(),
                FileUtils.getExtend(file.getOriginalFilename()),
                null);
        return path.getFullPath();
    }

    /**
     * 下载文件
     * @param fileUrl
     * @return OutputStream
     */
    public ByteArrayOutputStream downloadFile(String fileUrl){
        if (StringUtils.isEmpty(fileUrl)) return null;
        try{
            StorePath path = StorePath.praseFromUrl(fileUrl);
            ByteArrayOutputStream out = storageClient.downloadFile(path.getGroup(), path.getPath(), new DownloadCallback<ByteArrayOutputStream>() {
                @Override
                public ByteArrayOutputStream recv(InputStream inputStream) throws IOException {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[2048];
                    int len;
                    while ((len = inputStream.read(buffer)) > -1 ) {
                        baos.write(buffer, 0, len);
                    }
                    baos.flush();
                    return baos;
                }
            });

            return out;
        }catch (FdfsUnsupportStorePathException e){
            logger.warn(e.getMessage());
        }
        return null;
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
