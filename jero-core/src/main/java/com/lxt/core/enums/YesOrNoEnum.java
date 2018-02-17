package com.lxt.core.enums;

public enum YesOrNoEnum {
    YES(1,"是"),
    NO(0,"否");

    private int value;
    private String label;

    YesOrNoEnum(int value, String label){
        this.value = value;
        this.label = label;
    }

    public int getValue(){return value;}
    public String getＬabel(){return label;}
}
