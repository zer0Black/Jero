package com.lxt.file.entity;

import com.lxt.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * 文件实体
 *
 * @author zer0
 * @version 1.0
 */
public class FileEntity extends BaseEntity implements Serializable{

    private String name;

    private String type; //拓展名

    private Long size; //文件大小

    private String contentType; //对应http协议的ContentType

    private String savePath;


    public FileEntity(String name, String type, String contentType,
                      Long size, String savePath){
        this.name = name;
        this.size = size;
        this.type = type;
        this.contentType = contentType;
        this.savePath = savePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
