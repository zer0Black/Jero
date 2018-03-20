package com.lxt.user.entity;

import com.lxt.core.entity.BaseEntity;
import com.lxt.user.constants.AccountStatusEnum;

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

    private short type; //账户类型

    private short status = AccountStatusEnum.ENABLE.getValue(); //账户状态，0禁用，1启用，默认启用

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

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
