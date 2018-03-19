package com.lxt.user.entity;

import com.lxt.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * 账户实体
 *
 * @author lixuetao
 * @version 1.0
 */
public class AccountEntity extends BaseEntity implements Serializable {

    private String userName;

    private String password;

    private String realName;

    private int type; //账户类型

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
