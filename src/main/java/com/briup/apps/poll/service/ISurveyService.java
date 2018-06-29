package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;


/**
 * 业务逻辑接口实现    课调
 * @author WE
 */
public interface ISurveyService {
	/**
	 * 保存或修改课调
	 * @param survey
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateSurvey(Survey survey) throws Exception;
	/**
	 * 查询所有课调
	 * @return
	 * @throws Exception
	 */
	List<SurveyVM> selectAllSurvey() throws Exception;
	/**
	 * 通过id查询课调
	 * @param id
	 * @return
	 * @throws Exception
	 */
	SurveyVM selectSurveyById(long id) throws Exception;
	/**
	 * 通过id删除课调信息
	 * @param id
	 * @throws Exception
	 */
	void deleteSurveyById(long id) throws Exception;
	/**
	 * 批量删除课调信息
	 * @param ids
	 * @throws Exception
	 */
	void batchDeleteSurvey(long[] ids) throws Exception;
	

}
