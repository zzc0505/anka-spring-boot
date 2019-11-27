package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreSeqMapper;
import com.anka.apps.model.CoreSeq;
import com.anka.apps.service.CoreSeqService;
import com.anka.base.service.CrudBaseServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: (CoreSeqService)接口实现类
* @author AnkaRebirth
* @date 2019-11-27 14:37
* @version 1.0.0
*/
@Service
public class CoreSeqServiceImpl extends CrudBaseServiceSupport<CoreSeq> implements CoreSeqService {

    @Resource
    private CoreSeqMapper coreSeqMapper;

	@Override
	public Integer nextval(String name) {
		return coreSeqMapper.nextval(name);
	}

}