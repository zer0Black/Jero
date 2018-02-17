package com.lxt.core.entity;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * 分页实体
 *
 * @author zer0
 * @version 1.0
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -7405699269242583458L;

    private Integer pageNo = 1; //当前页
    private Integer pageSize = 20; //每页数，默认20
    private Long count; //总数
    private Long totalPage; //总页数
    private List<T> content = new ArrayList<T>();
    private Map<String, String> ext = new HashMap<>();  // 预留，用于传输分页时候需要传输的数据
    private String orderBy; // 排序字段
    private String orderWay = "asc"; //排序方式


    public Page(List<T> content){
        this.content.addAll(content);
    }

    public Page(List<T> content, long count){
        this.content.addAll(content);
        Assert.isTrue(count >= content.size(), "Total must not be less than the number of elements given!");
        this.count = count;
    }

    public int getTotalPage() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) count / (double) getPageSize());
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content.addAll(content);
    }

    public Map<String, String> getExt() {
        return ext;
    }

    public void setExt(Map<String, String> ext) {
        this.ext = ext;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(String orderWay) {
        this.orderWay = orderWay;
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

}
