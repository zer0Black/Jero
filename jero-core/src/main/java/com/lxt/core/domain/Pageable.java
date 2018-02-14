package com.lxt.core.domain;

import com.lxt.core.domain.sort.Sort;

import java.util.Map;

/**
 * 分页核心函数，处理分页请求
 *
 * @author zer0
 * @version 1.0
 */
public class Pageable {

    private int page;
    private int size;
    private Sort sort;

    public Pageable(int page, int size){
        this(page, size, null);
    }

    public Pageable(int page, int size, Sort sort) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public int getPageSize() {
        return size;
    }

    public int getPageNumber() {
        return page;
    }

    public int getOffset() {
        return page * size;
    }

    public Sort getSort() {
        return sort;
    }

    public Pageable next() {
        return new Pageable(getPageNumber() + 1, getPageSize(), getSort());
    }

    public Pageable previous() {
        return getPageNumber() == 0 ? this : new Pageable(getPageNumber() - 1, getPageSize(), getSort());
    }

    public Pageable first() {
        return new Pageable(0, getPageSize(), getSort());
    }

    public boolean hasPrevious() {
        return page > 0;
    }

    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }
}
