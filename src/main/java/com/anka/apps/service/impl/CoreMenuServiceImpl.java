package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreMenuMapper;
import com.anka.apps.model.CoreMenu;
import com.anka.apps.service.CoreMenuService;
import com.anka.base.service.TreeBaseServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: (CoreMenuService)接口实现类
* @author AnkaRebirth
* @date 2019-03-12 12:00
* @version 1.0.0
*/
@Service
public class CoreMenuServiceImpl extends TreeBaseServiceSupport<CoreMenu> implements CoreMenuService {

    @Resource
    private CoreMenuMapper coreMenuMapper;
    

}