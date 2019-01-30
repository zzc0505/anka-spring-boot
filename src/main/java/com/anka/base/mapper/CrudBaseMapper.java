package com.anka.base.mapper;

import com.anka.base.model.BaseModel;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CrudBaseMapper<T extends BaseModel<T>> extends Mapper<T>, IdsMapper<T>, MySqlMapper<T>{

}
