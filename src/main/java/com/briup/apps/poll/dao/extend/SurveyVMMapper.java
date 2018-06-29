package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.SurveyVM;

/**
 * POJO中间类    课调Mapper
 * @author WE
 */
public interface SurveyVMMapper {
	/**
	 * 查询所有课调
	 * @return
	 */
	List<SurveyVM> selectAllSurvey();
	/**
	 * 根据id查询课调
	 * @return
	 */
	SurveyVM selectSurveyById(long id);
	

}
