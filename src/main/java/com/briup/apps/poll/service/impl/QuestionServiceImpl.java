package com.briup.apps.poll.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
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
	@Autowired
	private OptionsMapper optionsMapper;
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
	/**
	 * 一对多的保存或更新操作(包含选项)
	 */
	@Override
	public void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception {
		//1。先分离questionVM,从中获取到Question Options
		  //1.1 从QuestionVM中取出options的信息，在返回给options
		List<Options> options = questionVM.getOptions();
		  //1.2 从questionVM中取出question的信息，在设置到question中去
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		//question 问题对象，options 所有问题的选项
		//2. 判断保存还是修改
		if(question.getId() == null){
			//2.1 保存
			if(question.getQuestiontype().equals("简答题")){
				//2.1.1 保存简答题，只需要保存题目相关信息
				questionMapper.insert(question);
			} else {
				//2.1.2 保存单选和多选题的时候需要先保存题目信息，再保存选项信息
				questionMapper.insert(question);
				//如何获取刚刚插入到问题的id
				long questionId = question.getId();
				if(options!=null){
				for(Options option : options){
					//为每个option设置question_id
					option.setQuestionId(questionId);
					//保存选项
					optionsMapper.insert(option);
				}
			  }
			} 
		} else {
			//2.2 修改
			//2.2.1 修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.2.2 修改选项信息（添加新选项，删除旧选项，对原来选项修改）
			//1. 删除该题目原有的选项
			OptionsExample example = new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//2. 重新添加选项
			long questionId = question.getId();
			if(options!=null){
			for(Options option : options){
				//为每个option设置question_id
				option.setQuestionId(questionId);
				//保存选项
				optionsMapper.insert(option);
			}
		  }
		}
	}
	/**
	 * 根据id删除问题以及选项(在数据库级别上，设置问题与选项的级联操作)
	 */
	@Override
	public void deleteQuestionById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
	}
}
