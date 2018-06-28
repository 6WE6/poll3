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
	/**
	 * 一对多关联的保存或更新操作
	 * @param questionVM
	 * @throws Exception
	 */
	void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception;
	/**
	 * 根据id删除问题，删除问题的同时删除选项信息(这种情况下可以不在代码层次上做操作，在数据库中设置级联)
	 * @throws Exception
	 */
	void deleteQuestionById(long id) throws Exception;


}
