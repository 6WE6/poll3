package com.briup.apps.poll.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

/**
 * 业务逻辑处理实现类    题库(问题)
 * @author WE
 *
 */
@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	/**
	 * 基础查询所有题库信息
	 */
	@Override
	public List<Question> findAllQuestion() throws Exception {
		QuestionExample example = new QuestionExample();
		return questionMapper.selectByExample(example);
	}
	/**
	 * 一对多查询所有题库信息以及选项
	 */
	@Override
	public List<QuestionVM> selectAllQuestion() throws Exception {
		return questionVMMapper.selectAllQuestion();
	}
}
