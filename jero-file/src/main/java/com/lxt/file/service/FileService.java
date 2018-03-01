package com.lxt.file.service;

import com.lxt.common.exception.UnsupportFileTypeException;
import com.lxt.core.service.BaseService;
import com.lxt.file.entity.FileEntity;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 文件服务逻辑层接口
 *
 * @author zer0
 * @version 1.0
 */
public interface FileService extends BaseService<FileEntity>{

    FileEntity getById(String fileId);

    /**
     * 上传文件，并保存文件信息到数据库
     * @param file
     * @return
     */
    FileEntity uploadFile(MultipartFile file) throws IOException, UnsupportFileTypeException;

    List<FileEntity> uploadFiles(MultipartFile[] files) throws IOException, UnsupportFileTypeException;

    void downloadFile(HttpServletResponse response, HttpServletRequest request, String fileId) throws IOException;

    boolean deleteFile(String fileId);

}
