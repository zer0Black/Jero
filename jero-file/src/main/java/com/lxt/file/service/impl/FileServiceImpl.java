package com.lxt.file.service.impl;

import com.lxt.common.exception.UnsupportFileTypeException;
import com.lxt.common.utils.FileUtils;
import com.lxt.core.service.impl.BaseServiceImpl;
import com.lxt.file.entity.FileEntity;
import com.lxt.file.mapper.FileMapper;
import com.lxt.file.service.FileService;
import com.lxt.file.utils.FastDFSClientWrapper;
import com.lxt.file.utils.ImageUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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
    public FileEntity getById(String fileId) {
        return fileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public FileEntity uploadFile(MultipartFile file) throws IOException, UnsupportFileTypeException {
        String fileName = file.getOriginalFilename();
        String fileExt = FileUtils.getExtend(file.getOriginalFilename());
        String contentType = file.getContentType();
        Long size = file.getSize();

        StringBuilder storagePath = new StringBuilder();
        if (ImageUtils.isFastdfsSupportImage(fileExt)){
            storagePath.append(fastDFSClient.uploadImageAndCrtThumbImage(file));
        }else{
            storagePath.append(fastDFSClient.uploadFile(file));
        }

        FileEntity fileEntity = new FileEntity(fileName, fileExt, contentType, size, storagePath.toString());
        fileMapper.insert(fileEntity);

        return fileEntity;
    }

    @Override
    public List<FileEntity> uploadFiles(MultipartFile[] files) throws IOException, UnsupportFileTypeException {
        List<FileEntity> fileEntityList = new ArrayList<>();
        for (int i = 0; i < files.length; i++){
            FileEntity fileEntity = uploadFile(files[i]);
            fileEntityList.add(fileEntity);
        }
        return fileEntityList;
    }

    @Override
    public void downloadFile(HttpServletResponse response, HttpServletRequest request, String fileId) throws IOException {
        FileEntity file = fileMapper.selectByPrimaryKey(fileId);
        ByteArrayOutputStream downedStream = fastDFSClient.downloadFile(file.getSavePath());

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=" + encodeFileName(request, file.getName()));
        response.setContentType(file.getContentType());
        OutputStream out = new BufferedOutputStream(response.getOutputStream());

        byte[] bytes = downedStream.toByteArray();
        out.write(bytes);
        out.close();
        downedStream.close();
    }

    @Override
    public boolean deleteFile(String fileId) {
        final int SUCCESS_NUM = 1; //删除一条数据的值一定为1
        FileEntity file = fileMapper.selectByPrimaryKey(fileId);
        int delFlag = fileMapper.deleteByPrimaryKey(fileId);
        if (delFlag == SUCCESS_NUM){
            fastDFSClient.deleteFile(file.getSavePath());
            return true;
        }

        return false;
    }

    private String encodeFileName(HttpServletRequest request, String fileName){
        String encdoeFileName = "";
        try {
            String userAgent = request.getHeader("user-agent").toLowerCase();
            if(userAgent.contains("mise") || userAgent.contains("like gecko")){
                encdoeFileName = URLEncoder.encode(fileName,"UTF-8");
            }else {
                encdoeFileName = new String(fileName.getBytes(), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdoeFileName;
    }

}
