package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
/**
 * 业务逻辑处理接口     问卷答题信息
 * @author WE
 *
 */

public interface IAnswersService {
	/**
	 * 保存学生的答卷信息
	 * @param answers
	 * @throws Exception
	 */
	void saveOrUpdateAnswers(Answers answers) throws Exception;
	/**
	 * 通过surveyId查询answers
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Answers> findAnswersBySurveyId(long id) throws Exception;
	/**
	 * 根据id查询Answers
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Answers findAnswersById(long id) throws Exception;

}
