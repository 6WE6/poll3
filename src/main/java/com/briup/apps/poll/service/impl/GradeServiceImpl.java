package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;

/**
 * 业务逻辑接口实现    年级
 * @author WE
 *
 */
@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;

	/**
	 * 查找所有年级信息
	 */
	@Override
	public List<Grade> findAllGrade() throws Exception {
		// 查询语句方法为selectByExampleWithBLOBs
		GradeExample gradeExample=new GradeExample();
		return gradeMapper.selectByExampleWithBLOBs(gradeExample);
	}
	
	/**
	 * 根据id查找年级信息
	 */
	@Override
	public Grade findGradeById(long id) throws Exception {
		// 	
		return gradeMapper.selectByPrimaryKey(id);
		
	}

	/**
	 * 根据关键字查找年级信息
	 */
	@Override
	public List<Grade> findGradeByKeyword(String keywords) throws Exception {
		//添加条件：name属性中包含keywords关键字
		GradeExample gradeExample = new GradeExample();	
		gradeExample.createCriteria().andNameLike(keywords);
		return gradeMapper.selectByExampleWithBLOBs(gradeExample);
	}

	/**
	 * 保存年级信息
	 */
	@Override
	public void saveOrUpdateGrade(Grade grade) throws Exception { 
		if(grade.getId()!=null){
			//更新
			gradeMapper.updateByPrimaryKey(grade);
		}else{
			//插入
			gradeMapper.insert(grade);
		}
		
	}

	/**
	 * 根据id删除年级信息
	 */
	@Override
	public void deleteGradeById(long id) throws Exception {
		gradeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除年级信息
	 */
	@Override
	public void batchDeleteGrade(Long[] ids) throws Exception {
		// 迭代循环
		for(Long id: ids){
			gradeMapper.deleteByPrimaryKey(id);
		}
		
	}

}
