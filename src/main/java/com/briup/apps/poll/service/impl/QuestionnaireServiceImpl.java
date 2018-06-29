package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

/**
 * 业务逻辑接口实现类    问卷
 * @author WE
 *
 */
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{

	@Autowired
	private QuestionnaireMapper qunMapper;
	@Autowired
	private QuestionnaireVMMapper qunVMMapper;
	@Autowired
	private QuestionnaireQuestionMapper qqMapper;
	
	/**
	 * 通过模板查询所有问卷信息
	 */
	@Override
	public List<Questionnaire> findAllQuestionnaire() throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		return qunMapper.selectByExampleWithBLOBs(example);
	}

	/**
	 * 通过id查询问卷信息,返回QuestionnaireVM类型
	 */
	@Override
	public QuestionnaireVM selectQunById(long id) throws Exception {
		return qunVMMapper.selectQunById(id);
	}

	/**
	 * 保存或更新问卷
	 */
	@Override
	public void saveOrUpdate(Questionnaire questionnaire,long[] questionIds) throws Exception {
		//1. 判断是保存操作还是更新
		if(questionnaire.getId() == null){
			//1.1 保存
			//1.1.1 保存问卷信息 {id:null,name:'',description:''}
			qunMapper.insert(questionnaire);
			long  questionnaireId = questionnaire.getId();
			//1.1.2 维护问卷和问题的关系 qq
			for(long questionId : questionIds){
				QuestionnaireQuestion qq = new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
		} else {
			//1.2 修改
			//1.2.1 修改问卷信息
			qunMapper.updateByPrimaryKey(questionnaire);
			long questionnaireId = questionnaire.getId();
			//1.2.2 删除问卷下所有的问卷问题关系
			// delete from poll_qq where questionnaire_id = #{id}
			QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
			example.createCriteria().andQuestionnaireIdEqualTo(questionnaireId);
			qqMapper.deleteByExample(example);
			//1.2.3 保存新的问卷问题关系
			for(long questionId : questionIds){
				QuestionnaireQuestion qq = new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
		}
	}

	/**
	 * 根据id删除问卷
	 */
	@Override
	public void deleteById(long id) throws Exception {
		qunMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除问卷
	 */
	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids) {
			qunMapper.deleteByPrimaryKey(id);
		}
	}
	

}
