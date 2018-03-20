package com.lxt.core.entity;

import com.lxt.core.enums.DeleteEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private Integer id;

    @Column(name = "DEL")
    private Short del = DeleteEnum.NORMAL.getValue(); //是否删除，1为正常，0为已删除

    @Column(name = "CREATE_TIME")
    private Date createTime; //创建时间

    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime; //最后一次更新时间

    @Column(name = "CREATE_BY")
    private String createBy; //创建人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDel() {
        return del;
    }

    public void setDel(Short del) {
        this.del = del;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
