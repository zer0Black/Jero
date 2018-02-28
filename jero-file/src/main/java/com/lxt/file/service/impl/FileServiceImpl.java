package com.lxt.file.service.impl;

import com.lxt.core.service.impl.BaseServiceImpl;
import com.lxt.file.entity.FileEntity;
import com.lxt.file.mapper.FileMapper;
import com.lxt.file.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author zer0
 * @version 1.0
 */
@Service
@Transactional
public class FileServiceImpl extends BaseServiceImpl<FileMapper, FileEntity> implements FileService{

    @Override
    public FileEntity uploadFile(MultipartFile file) {
        return null;
    }

}
