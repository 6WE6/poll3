package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;

/**
 * 业务逻辑接口实现    课程
 * @author WE
 *
 */
@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;

	/**
	 * 按模板查询所有课程(QBC查询)
	 */
	@Override
	public List<Course> findAllCourse() throws Exception {
		// TODO Auto-generated method stub
		CourseExample example = new CourseExample();
		return courseMapper.selectByExampleWithBLOBs(example);
	}
	/**
	 * 通过id查询课程信息
	 */
	@Override
	public Course findCourseById(long id) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(id);
	}
	/**
	 * 通过关键字查询课程信息
	 */
	@Override
	public List<Course> findCourseByKeyword(String keywords) throws Exception {
		// TODO Auto-generated method stub
		CourseExample example = new CourseExample();
		//添加条件：name属性中包含keywords关键字,模糊查询
		example.createCriteria().andNameLike(keywords);
		return courseMapper.selectByExampleWithBLOBs(example);
	}
	/**
	 * 保存或更新课程信息
	 */
	@Override
	public void saveOrUpdateCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		Course count= courseMapper.selectByPrimaryKey(course.getId());
		if(count!=null){
			//更新
			courseMapper.updateByPrimaryKey(course);
		}else{
			//插入
			courseMapper.insert(course);
		}
	}
	/**
	 * 通过id删除课程信息
	 */
	@Override
	public void deleteCourseById(long id) throws Exception {
		// TODO Auto-generated method stub
		courseMapper.deleteByPrimaryKey(id);	
	}
	/**
	 * 批量删除课程信息
	 */
	@Override
	public void batchDeleteCourse(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		//forEach循环遍历数组或集合
		for(long id : ids){
			courseMapper.deleteByPrimaryKey(id);
		}		
	}

}
