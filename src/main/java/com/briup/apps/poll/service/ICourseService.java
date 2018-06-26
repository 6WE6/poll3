package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

/**
 * 业务逻辑处理接口    课程
 * @author WE
 *
 */
public interface ICourseService {
	/**
	 * 查询所有课程
	 * @return
	 * @throws Exception
	 */
	List<Course> findAllCourse() throws Exception;
	/**
	 * 通过id查询课程
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Course findCourseById(long id) throws Exception;
	/**
	 * 通过关键字查询课程
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Course> findCourseByKeyword(String keywords) throws Exception;
	/**
	 * 保存或修改课程信息
	 * @param course
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateCourse(Course course) throws Exception;
	/**
	 * 通过id删除课程信息
	 * @param id
	 * @throws Exception
	 */
	void deleteCourseById(long id) throws Exception;
	/**
	 * 批量删除课程信息
	 * @param course
	 * @throws Exception
	 */
	void batchDeleteCourse(Long[] ids) throws Exception;
	

}
