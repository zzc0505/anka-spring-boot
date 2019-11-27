package com.anka.apps.service;

import com.anka.apps.model.CoreSeq;
import com.anka.base.service.CrudBaseService;
/**
* @Description: (CoreSeqService)接口
* @author AnkaRebirth
* @date 2019-11-27 14:37
* @version 1.0.0
*/
public interface CoreSeqService extends CrudBaseService<CoreSeq> {
	
	/**
	 * 根据序列名称获取当前值
	 * @param name
	 * @return
	 */
	public Integer nextval(String name);
}
