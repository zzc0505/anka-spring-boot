package com.anka.apps.mapper;

import com.anka.base.mapper.CrudBaseMapper;
import com.anka.apps.model.CoreSeq;

/**
 * @Description:(CoreSeqMapper)数据持久层接口
 * @author AnkaRebirth
 * @date 2019-11-27 14:37
 * @version 1.0.0
 */
public interface CoreSeqMapper extends CrudBaseMapper<CoreSeq>{
	
	/**
	 * 根据序列名称获取当前值
	 * @param name
	 * @return
	 */
	public Integer nextval(String name);
}
