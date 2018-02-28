package com.lxt.file.service.impl;

import com.lxt.common.utils.FileUtils;
import com.lxt.core.service.impl.BaseServiceImpl;
import com.lxt.file.entity.FileEntity;
import com.lxt.file.mapper.FileMapper;
import com.lxt.file.service.FileService;
import com.lxt.file.utils.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zer0
 * @version 1.0
 */
@Service
@Transactional
public class FileServiceImpl extends BaseServiceImpl<FileMapper, FileEntity> implements FileService{

    @Autowired
    FastDFSClientWrapper fastDFSClient;

    @Autowired
    FileMapper fileMapper;

    @Override
    public FileEntity uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExt = FileUtils.getExtend(file.getOriginalFilename());
        String contentType = file.getContentType();
        String storagePath = fastDFSClient.uploadFile(file);

        FileEntity fileEntity = new FileEntity(fileName, fileExt, contentType, storagePath);
        fileMapper.insert(fileEntity);

        return fileEntity;
    }

    @Override
    public List<FileEntity> uploadFiles(MultipartFile[] files) throws IOException {
        List<FileEntity> fileEntityList = new ArrayList<>();
        for (int i = 0; i < files.length; i++){
            FileEntity fileEntity = uploadFile(files[i]);
            fileEntityList.add(fileEntity);
        }
        return fileEntityList;
    }

    @Override
    public void downloadFile(String fileId) {

    }

    @Override
    public void deleteFile(String fileId) {

    }

}
