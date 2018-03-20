package com.lxt.user.constants;

public enum AccountStatusEnum {

    ENABLE((short)1, "启用"),
    DISABLE((short)0, "禁用");

    AccountStatusEnum(short value, String lable) {
        this.value = value;
        this.lable = lable;
    }

    public short getValue() {
        return value;
    }

    public String getLable() {
        return lable;
    }

    private short value;
    private String lable;


}


