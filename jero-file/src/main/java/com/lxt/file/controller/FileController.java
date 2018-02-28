package com.lxt.file.controller;

import com.lxt.core.enums.Code;
import com.lxt.core.http.ResponseMessage;
import com.lxt.core.http.Result;
import com.lxt.file.entity.FileEntity;
import io.swagger.annotations.Api;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    public ResponseMessage<FileEntity> uploadFile(@RequestParam("file") MultipartFile file){
        if (file == null) return Result.error(Code.NOT_FIND_FILE);

        return Result.success();
    }

}
