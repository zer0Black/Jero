package com.lxt.core.enums;

public enum DeleteEnum {

    NORMAL(1, "正常"),
    DELETE(0, "已删除");

    private int value;
    private String label;

    DeleteEnum(int value, String label){
        this.value = value;
        this.label = label;
    }

    public int getValue(){return value;}
    public String getＬabel(){return label;}

}
