package com.lxt.core.entity;

import com.lxt.core.enums.DeleteEnum;
import com.lxt.core.enums.YesOrNoEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseEntity implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private Integer id;

    @Column(name = "DEL")
    private Integer del = DeleteEnum.NORMAL.getValue(); //是否删除，1为正常，0为已删除

    @Column(name = "CREATE_TIME")
    private Date createTime; //创建时间

    @Column(name = "CREATE_BY")
    private String createBy; //创建人

}
