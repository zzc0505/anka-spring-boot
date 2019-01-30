package com.anka.base.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.anka.base.mapper.CrudBaseMapper;
import com.anka.base.model.BaseModel;

import tk.mybatis.mapper.entity.Example;

public abstract class CrudBaseServiceSupport<T extends BaseModel<T>> implements CrudBaseService<T>{
	
	@Autowired
	protected CrudBaseMapper<T> mapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer save(T model) {
		return mapper.insertSelective(model);
	}

	@Override
	public Integer batchSave(T model) {
		Integer count = null;
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		List<Object> list = model.getObjList();
		try {
			for (Object object : list) {
				count = session.insert(model.getClass().getName().replace("model", "mapper")+"Mapper.insertSelective", object);
			}
			session.commit();
			session.clearCache();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
        }
		return count;
	}

	@Override
	public Integer delete(T model) {
		return mapper.deleteByPrimaryKey(model);
	}

	@Override
	public Integer batchDelete(T model) {
		String ids = StringUtils.collectionToCommaDelimitedString(model.getStrList());
		return mapper.deleteByIds(ids);
	}

	@Override
	public Integer update(T model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public Integer batchUpdate(T model) {
		Integer count = null;
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		List<Object> list = model.getObjList();
		try {
			for (Object object : list) {
				count = session.insert(model.getClass().getName().replace("model", "mapper")+"Mapper.updateByPrimaryKeySelective", object);
			}
			session.commit();
			session.clearCache();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
        }
		return count;
	}

	@Override
	public T get(String id) {
		 return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> selectModelList(T model) {
         return mapper.select(model);
	}

	@Override
	public List<T> selectModelListByIds(T model) {
		String ids = StringUtils.collectionToCommaDelimitedString(model.getStrList());
		return mapper.selectByIds(ids);
	}

	@Override
	public List<T> selectByExample(Example example) {
		return mapper.selectByExample(example);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}
	
}
