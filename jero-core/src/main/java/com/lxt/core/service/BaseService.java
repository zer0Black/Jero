package com.lxt.core.service;

import com.github.pagehelper.PageInfo;
import com.lxt.core.entity.Pager;

import java.util.List;

public interface BaseService<T> {

    /**
     * 查询
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);

    /**
     * 分页查询列表
     *
     * @param pager
     * @return
     */
    PageInfo<T> selectPage(Pager pager);

    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> selectListAll();

    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    int delete(T entity);

    /**
     * 根据Id删除
     *
     * @param id
     */
    int deleteById(Object id);


    /**
     * 根据id更新
     *
     * @param entity
     */
    int updateById(T entity);


    /**
     * 不update null
     *
     * @param entity
     */
    int updateSelectiveById(T entity);

}
