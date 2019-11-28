package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreRoleMapper;
import com.anka.apps.model.CoreRole;
import com.anka.apps.service.CoreRoleService;
import com.anka.base.service.CrudBaseServiceSupport;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: 角色表(CoreRoleService)接口实现类
* @author AnkaRebirth
* @date 2019-03-06 14:11
* @version 1.0.0
*/
@Service
public class CoreRoleServiceImpl extends CrudBaseServiceSupport<CoreRole> implements CoreRoleService {

    @Resource
    private CoreRoleMapper coreRoleMapper;

	@Override
	public CoreRole roleEdit(CoreRole model) {
		if(StringUtils.hasText(model.getCrreUuid())){
			model = super.get(model.getCrreUuid());
		}
		return model;
	}

	@Override
	public Integer doSave(CoreRole model) {
		if(StringUtils.hasText(model.getCrreUuid())){
			return super.update(model);
		}else{
			return super.save(model);
		}
	}

	@Override
	public Integer batchDelete(CoreRole model) {
		// TODO Auto-generated method stub
		return super.batchDelete(model);
	}

	@Override
	public List<CoreRole> getList(CoreRole model) {
		Example e = new Example(CoreRole.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrreName())){
			cn.andLike("crreName", "%"+model.getCrreName()+"%");
		}
		PageHelper.startPage(model.getPage(), model.getLimit());
		List<CoreRole> list = super.selectByExample(e);
		return list;
	}
    

}