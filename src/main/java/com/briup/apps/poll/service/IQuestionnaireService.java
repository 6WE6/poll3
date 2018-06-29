package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

/**
 * 业务逻辑处理接口    问卷
 * @author WE
 *
 */
public interface IQuestionnaireService {
	/**
	 * 查询所有问卷信息
	 * @return
	 * @throws Exception
	 */
	List<Questionnaire> findAllQuestionnaire() throws Exception;
	/**
	 * 通过id查找问卷
	 * @param id
	 * @return 返回一个QuestionnaireVM
	 * @throws Exception
	 */
	QuestionnaireVM selectQunById(long id) throws Exception;
	/**
	 * 保存或更新问卷
	 * @param questionnaire
	 * @param questionIds
	 * @throws Exception
	 */
	void saveOrUpdate(Questionnaire questionnaire,long[] questionIds) throws Exception;
	/**
	 * 通过id删除问卷
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;
	/**
	 * 批量删除问卷
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(long[] ids) throws Exception;

}
