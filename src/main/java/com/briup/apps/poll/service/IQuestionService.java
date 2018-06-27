package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

/**
 * 业务逻辑接口    问题
 * @author WE
 *
 */
public interface IQuestionService {
	/**
	 * 基础查询所有问题信息
	 * @return
	 * @throws Exception
	 */
	List<Question> findAllQuestion() throws Exception;
	/**
	 * 一对多关联查询选项信息
	 * @return
	 * @throws Exception
	 */
	List<QuestionVM> selectAllQuestion() throws Exception; 

}
