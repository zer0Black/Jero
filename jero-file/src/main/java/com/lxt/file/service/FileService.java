package com.lxt.file.service;

import com.lxt.core.service.BaseService;
import com.lxt.file.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务逻辑层接口
 *
 * @author zer0
 * @version 1.0
 */
public interface FileService extends BaseService<FileEntity>{

    FileEntity uploadFile(MultipartFile file);

}
