package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreUserMapper;
import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreUserService;
import com.anka.base.model.BaseTree;
import com.anka.base.service.CrudBaseServiceSupport;
import com.anka.base.utils.PassSecurity;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
* @Description: 用户表(CoreUserService)接口实现类
* @author AnkaRebirth
* @date 2019-01-28 17:01
* @version 1.0.0
*/
@Service
public class CoreUserServiceImpl extends CrudBaseServiceSupport<CoreUser> implements CoreUserService {

    @Resource
    private CoreUserMapper coreUserMapper;

	@Override
	public CoreUser checkLogin(CoreUser model) {
		Example e = new Example(CoreUser.class);
		e.createCriteria()
		.andEqualTo("crurName", model.getCrurName())
		.orEqualTo("crurMobile", model.getCrurName());
		e.and(e.createCriteria().andEqualTo("crurPassword", model.getCrurPassword()));
		List<CoreUser> list = super.selectByExample(e);
		return list.size()>0?list.get(0):null;
	}

	@Override
	public Boolean checkUser(CoreUser model) {
		Example e = new Example(CoreUser.class);
		e.createCriteria()
		.andEqualTo("crurName", model.getCrurName())
		.andEqualTo("crurMobile", model.getCrurName());
		List<CoreUser> list = super.selectByExample(e);
		return list.size()>0?true:false;
	}

	@Override
	public void userRegister(CoreUser model) {
		model.setCrurPassword(PassSecurity.getEncode(model.getCrurPassword(), "ANKA"));
		model.setCrurStatus("0");
		model.setCrurLockstatus("0");
		super.save(model);
	}

	@Override
	public Integer locked(CoreUser model) {
		model.setCrurLockstatus("1");
		return super.update(model);
	}

	@Override
	public Boolean unLocked(CoreUser model) {
		CoreUser bean = super.get(model.getCrurUuid());
		if(bean!=null&&bean.getCrurLockpassword().equals(model.getCrurLockpassword())){
			model.setCrurLockstatus("0");
			super.update(model);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean lockChecked(CoreUser model) {
		CoreUser bean = super.get(model.getCrurUuid());
		if(bean!=null&&bean.getCrurLockstatus().equals("1")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<CoreUser> getList(CoreUser model) {
		Example e = new Example(CoreUser.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrurName())){
			cn.andLike("crurName", "%"+model.getCrurName()+"%");
		}
		if(StringUtils.hasText(model.getCrurMobile())){
			cn.andLike("crurMobile",  "%"+model.getCrurMobile()+"%");
		}
		if(StringUtils.hasText(model.getCrurEmail())){
			cn.andLike("crurEmail",  "%"+model.getCrurEmail()+"%");
		}
		PageHelper.startPage(model.getPage(), model.getLimit());
		List<CoreUser> list = super.selectByExample(e);
		return list;
	}

	@Override
	public CoreUser getCoreUser(CoreUser model) {
		return coreUserMapper.getCoreUser(model);
	}

	@Override
	public List<BaseTree> treeList(CoreUser model) {
		List<BaseTree> treeList = new ArrayList<BaseTree>();
		Example e = new Example(CoreUser.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrurName())){
			cn.andLike("crurName", "%"+model.getCrurName()+"%");
		}
		List<CoreUser> list = super.selectByExample(e);
		for (CoreUser user : list) {
			BaseTree tree = new BaseTree();
			tree.setId(user.getCrurUuid());
			tree.setTitle(user.getCrurName());
			tree.setCheckArr("0");
			tree.setParentId("0");
			treeList.add(tree);
		}
		return treeList;
	}
}