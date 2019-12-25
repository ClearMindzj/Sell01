package com.imooc.dataobject.mapper;


import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface ProductCategoryMapper {

    
    int insertByMap(Map<String,Object> map);

}
