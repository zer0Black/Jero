package com.lxt.file.mapper;

import com.lxt.core.util.JeroMapper;
import com.lxt.file.entity.FileEntity;
import org.springframework.stereotype.Repository;

/**
 * 文件服务持久层
 *
 * @author zer0
 * @version 1.0
 */
@Repository
public interface FileMapper extends JeroMapper<FileEntity> {

}
