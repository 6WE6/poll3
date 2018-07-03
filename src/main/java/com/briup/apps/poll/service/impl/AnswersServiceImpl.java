package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.service.IAnswersService;

/**
 * 业务逻辑接口实现类    答卷
 * @author WE
 *
 */
@Service
public class AnswersServiceImpl implements IAnswersService{

	@Autowired
	private AnswersMapper answersMapper;
	/**
	 * 保存学生对课调的答卷信息
	 */
	@Override
	public void saveOrUpdateAnswers(Answers answers) throws Exception {
		if(answers.getId() != null){
			answersMapper.updateByPrimaryKey(answers);
		}else{
			answersMapper.insert(answers);
		}	
	}
	/**
	 * 通过课调id查询问卷答案
	 */
	@Override
	public List<Answers> findAnswersBySurveyId(long id) throws Exception {
		// TODO Auto-generated method stub
		AnswersExample example = new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(id);
		return answersMapper.selectByExample(example);
	}
	/**
	 * 根据id查询Answers
	 */
	@Override
	public Answers findAnswersById(long id) throws Exception {
		// TODO Auto-generated method stub
		return answersMapper.selectByPrimaryKey(id);
	}

}
