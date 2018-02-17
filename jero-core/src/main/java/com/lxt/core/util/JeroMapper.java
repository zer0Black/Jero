package com.lxt.core.util;

import org.apache.poi.ss.formula.functions.T;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface JeroMapper extends Mapper<T>,MySqlMapper<T> {
    // FIXME 特别注意，该接口不能被扫描到，否则会出错
}
