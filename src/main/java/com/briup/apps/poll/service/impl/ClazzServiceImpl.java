package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;

/**
 * 逻辑处理实现类    班级
 * @author WE
 *
 */
@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;

	/**
	 * 查询所有班级(基础查询:按模板查询)
	 */
	@Override
	public List<Clazz> findAllClazz() throws Exception {
		ClazzExample example = new ClazzExample();
		return clazzMapper.selectByExample(example );
	}

	/**
	 * 查询所有班级(多对一)
	 */
	@Override
	public List<ClazzVM> selectAllClazz() throws Exception {
		return clazzVMMapper.selectAllClazz();
	}
	

}
