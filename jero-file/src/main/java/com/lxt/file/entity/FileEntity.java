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

    private String savePath;

    private String contentType; //对应http协议的ContentType

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
