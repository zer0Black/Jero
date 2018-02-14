package com.lxt.core.enums;

/**
 * TODO
 *
 * @author zer0
 * @version 1.0
 */
public enum Code {

    ERROR(0, "系统错误"),
    SUCCESS(1, "操作成功"),

    ILLEGAL_TOKEN(1001, "不合法的凭证"),
    ILLEGAL_FILE_TYPE(1002, "不合法的文件类型"),
    ILLEGAL_FILE_SIZE(1003, "不合法的文件大小"),
    ILLEGAL_PARAM(1004, "不合法的参数"),
    UNSUPPORT_IMAGE_TYPE(1005, "不支持的图片格式"),
    UNSUPPORT_VIDEO_TYPE(1006, "不支持的视频格式"),
    TEXT_OVER_LIMIT(1007, "文本超过限制"),
    JSON_ERROR(1008, "解析JSON内容错误");

    private int code;
    private String msg;

    private Code(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
