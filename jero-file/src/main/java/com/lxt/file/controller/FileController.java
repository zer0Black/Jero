package com.lxt.file.controller;

import com.lxt.common.exception.UnsupportFileTypeException;
import com.lxt.common.utils.ArrayUtils;
import com.lxt.common.utils.StringUtils;
import com.lxt.core.enums.Code;
import com.lxt.core.http.ResponseMessage;
import com.lxt.core.http.Result;
import com.lxt.file.entity.FileEntity;
import com.lxt.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 文件服务控制器，处理文件上传下载
 *
 * @author zer0
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/file")
@Api(description = "文件上传和下载")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/{fileId}")
    @ApiOperation(value = "根据Id获取文件信息")
    public ResponseMessage<FileEntity> getById(@PathVariable String fileId){
        if (StringUtils.isBlank(fileId)) return Result.error(Code.ILLEGAL_PARAM.getCode(), "文件id不存在");
        return Result.success(fileService.getById(fileId));
    }

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public ResponseMessage<FileEntity> uploadFile(@RequestParam("file") MultipartFile file){
        if (file == null) return Result.error(Code.NOT_FIND_FILE);
        try {
            FileEntity fileEntity = fileService.uploadFile(file);
            return Result.success(fileEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(Code.FILE_STREAM_EXCEPTION);
        } catch (UnsupportFileTypeException e) {
            e.printStackTrace();
            return Result.error(Code.UNSUPPORT_IMAGE_TYPE.getCode(), e.getError());
        }
    }

    @PostMapping("/uploads")
    @ApiOperation(value = "批量上传文件")
    public ResponseMessage<List<FileEntity>> uploadFile(@RequestParam MultipartFile[] file) {
        if (ArrayUtils.isEmpty(file)) return Result.error(Code.NOT_FIND_FILE);
        try {
            List<FileEntity> fileEntityList = fileService.uploadFiles(file);
            return Result.success(fileEntityList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportFileTypeException e) {
            e.printStackTrace();
            return Result.error(Code.UNSUPPORT_IMAGE_TYPE.getCode(), e.getError());
        }
        return Result.error();
    }

    @GetMapping("/{fileId}/download")
    @ApiOperation(value = "下载文件")
    public ResponseMessage downloadFile(HttpServletResponse response, HttpServletRequest request, @PathVariable String fileId){
        if (StringUtils.isBlank(fileId)) return Result.error(Code.NOT_FIND_FILE);
        try {
            fileService.downloadFile(response, request, fileId);
            return Result.success("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error("下载失败");
    }

    @DeleteMapping("/{fileId}")
    @ApiOperation(value = "删除文件")
    public ResponseMessage deleteFile(@PathVariable String fileId){
        if (StringUtils.isBlank(fileId)) return Result.error(Code.NOT_FIND_FILE);
        boolean isDel = fileService.deleteFile(fileId);
        return isDel ? Result.success() : Result.error();
    }

}
