package com.lxt.file.service;

import com.lxt.core.service.BaseService;
import com.lxt.file.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 文件服务逻辑层接口
 *
 * @author zer0
 * @version 1.0
 */
public interface FileService extends BaseService<FileEntity>{

    /**
     * 上传文件，并保存文件信息到数据库
     * @param file
     * @return
     */
    FileEntity uploadFile(MultipartFile file) throws IOException;

    List<FileEntity> uploadFiles(MultipartFile[] files) throws IOException;

    void downloadFile(String fileId);

    void deleteFile(String fileId);

}
