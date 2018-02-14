package com.lxt.core.entity;

import com.lxt.core.domain.Pageable;
import com.lxt.core.domain.sort.Sort;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页实体
 *
 * @author zer0
 * @version 1.0
 */
public class Page<T> {

    private int curPage; //当前页
    private int pageSize = 20; //每页数，默认20
    private long count; //总数
    private List<T> content = new ArrayList<T>();
    private Pageable pageable;
    public Page(List<T> content){

    }

    public Page(List<T> content, Pageable pageable, long count){
        this.content.addAll(content);
        this.pageable = pageable;
        Assert.isTrue(count >= content.size(), "Total must not be less than the number of elements given!");
        this.count = count;
    }

    public int getCurPage() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    public int getPageSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    public long getCount() {
        return count;
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    public int getTotalPage() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) count / (double) getPageSize());
    }

    public int getOffset() {
        return curPage * pageSize;
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public boolean hasPrevious() {
        return getCurPage() > 0;
    }

    public boolean hasNext() {
        return getCurPage() + 1 < getTotalPage();
    }

    public boolean isFirst() {
        return !hasPrevious();
    }

    public boolean isLast() {
        return !hasNext();
    }

    public Pageable nextPageable() {
        return hasNext() ? pageable.next() : null;
    }

    public Pageable previousPageable() {
        if (hasPrevious()) {
            return pageable.previousOrFirst();
        }
        return null;
    }

    public Sort getSort() {
        return pageable == null ? null : pageable.getSort();
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

}
