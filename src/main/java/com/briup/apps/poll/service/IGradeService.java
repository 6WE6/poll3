package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

/**
 * 业务逻辑处理接口    年级
 * @author WE
 *
 */
public interface IGradeService {
	/**
	 * 查找所有年级
	 * @return 
	 * @throws Exception
	 */
	List<Grade> findAllGrade() throws Exception;
	
	/**
	 * 通过id查询年级
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Grade findGradeById(long id) throws Exception;
	
	/**
	 * 通过关键字查询年级信息
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Grade> findGradeByKeyword(String keywords) throws Exception;
	
	/**
	 * 保存或修改年级信息
	 * @param grade
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateGrade(Grade grade) throws Exception;
	/**
	 * 通过id删除年级信息
	 * @param id
	 * @throws Exception
	 */
	void deleteGradeById(long id) throws Exception;
	
	/**
	 * 批量删除年级信息
	 * @param grade
	 * @throws Exception
	 */
	void batchDeleteGrade(Long[] ids) throws Exception;

}
