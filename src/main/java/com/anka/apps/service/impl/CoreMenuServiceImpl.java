package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreMenuMapper;
import com.anka.apps.model.CoreMenu;
import com.anka.apps.service.CoreMenuService;
import com.anka.base.service.TreeBaseServiceSupport;
import com.anka.base.utils.MyUtils;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
	public CoreMenu menuEdit(CoreMenu model) {
		if(StringUtils.hasText(model.getCrmeUuid())){
			model = super.get(model.getCrmeUuid());
		}
		if(StringUtils.hasText(model.getCrmeParentUuid())){
			CoreMenu parent = super.get(model.getCrmeParentUuid());
			model.getStrMap().put("parentName", parent.getCrmeName());
		}
		return model;
	}

	@Override
	public List<CoreMenu> getTreeList(CoreMenu model) {
		Example e = new Example(CoreMenu.class);
		Criteria cn = e.createCriteria();
		if(StringUtils.hasText(model.getCrmeName())){
			cn.andLike("crmeName", "%"+model.getCrmeName()+"%");
		}
		e.orderBy("crmeOrd").asc();
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
		e.orderBy("crmeOrd").asc();
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
		e.orderBy("crmeOrd").asc();
		return super.selectByExample(e);
	}

	@Override
	public Integer batchDelete(CoreMenu model) {
		List<String> strList = model.getStrList();
		if(strList.size()>0){
			List<CoreMenu> list = this.getAllChild(model);
			List<String> uuids = MyUtils.getProperties(list, "crmeUuid");
			uuids.addAll(strList);
			List<String> ids = MyUtils.removeDuplicate(uuids);
			model.setStrList(ids);
		}
		return super.batchDelete(model);
	}
	
	/**
	 * 递归查询所有菜单
	 * @param model
	 * @return
	 */
	private List<CoreMenu> getAllChild(CoreMenu model){
		Example e = new Example(CoreMenu.class);
		Criteria cn = e.createCriteria();
		cn.andIn("crmeParentUuid", model.getStrList());
		List<CoreMenu> list = super.selectByExample(e);
		if(list.size()>0){
			List<String> strList = MyUtils.getProperties(list, "crmeUuid");
			model.setStrList(strList);
			list.addAll(this.getAllChild(model));
		}
		return list;
	}
	
}