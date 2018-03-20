package com.lxt.core.enums;

public enum DeleteEnum {

    NORMAL((short)1, "正常"),
    DELETE((short)0, "已删除");

    private short value;
    private String label;

    DeleteEnum(short value, String label){
        this.value = value;
        this.label = label;
    }

    public short getValue(){return value;}
    public String getＬabel(){return label;}

}
