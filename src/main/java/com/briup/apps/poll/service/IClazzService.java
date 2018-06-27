package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
/**
 * 逻辑处理接口    班级
 * @author WE
 *
 */
public interface IClazzService {
	/**
	 * 查询所有班级信息(基础查询)
	 * @return
	 * @throws Exception
	 */
	List<Clazz> findAllClazz() throws Exception;
	/**
	 * 查询所有的班级信息(多对一)
	 * @return
	 * @throws Exception
	 */
	List<ClazzVM> selectAllClazz() throws Exception;

}
