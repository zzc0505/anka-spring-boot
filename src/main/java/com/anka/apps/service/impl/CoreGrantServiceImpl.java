package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreGrantMapper;
import com.anka.apps.model.CoreGrant;
import com.anka.apps.service.CoreGrantService;
import com.anka.base.service.CrudBaseServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: (CoreGrantService)接口实现类
* @author AnkaRebirth
* @date 2019-11-11 16:05
* @version 1.0.0
*/
@Service
public class CoreGrantServiceImpl extends CrudBaseServiceSupport<CoreGrant> implements CoreGrantService {

    @Resource
    private CoreGrantMapper coreGrantMapper;
    

}