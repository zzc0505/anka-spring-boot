package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreMenuMapper;
import com.anka.apps.model.CoreMenu;
import com.anka.apps.service.CoreMenuService;
import com.anka.base.service.TreeBaseServiceSupport;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

	@Override
	public List<CoreMenu> getTreeList(CoreMenu model) {
		Example e = new Example(CoreMenu.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrmeName())){
			cn.andLike("crmeName", "%"+model.getCrmeName()+"%");
		}
		return super.selectByExample(e);
	}

	@Override
	public List<CoreMenu> getList(CoreMenu model) {
		Example e = new Example(CoreMenu.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrmeName())){
			cn.andLike("crmeName", "%"+model.getCrmeName()+"%");
		}
		if(StringUtils.hasText(model.getCrmeParentUuid())){
			cn.andEqualTo("crmeParentUuid", model.getCrmeParentUuid());
		}
		PageHelper.startPage(model.getPage(), model.getLimit());
		return super.selectByExample(e);
	}

	@Override
	public Integer doSave(CoreMenu model) {
		if(StringUtils.hasText(model.getCrmeUuid())){
			return super.update(model);
		}else{
			return super.save(model);
		}
	}

	@Override
	public List<CoreMenu> getMenus(String type) {
		Example e = new Example(CoreMenu.class);
		Criteria cn = e.createCriteria();
		cn.andEqualTo("crmeType", type);
		return super.selectByExample(e);
	}
}