package com.lxt.core.util;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Component("beanMapper")
public class BeanMapper {

    @Resource
    private Mapper dozer;

    public <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return dozer.map(source, destinationClass);
    }

    public <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destinationList = new ArrayList();
        if (sourceList == null) {
            return destinationList;
        }
        for (Iterator i$ = sourceList.iterator(); i$.hasNext(); ) {
            Object sourceObject = i$.next();
            Object destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public void copy(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }

}