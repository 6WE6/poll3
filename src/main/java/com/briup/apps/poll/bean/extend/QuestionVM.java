package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Options;

/**
 * 处理  问题与选项之间的一对多问题(一个问题的出现伴随着多个选项)
 * @author WE
 *
 */
public class QuestionVM {
	private Long id;
	private String name;
	private String questionType;
	/**
	 * 这里把选项信息包含进来
	 */
	List<Options> options;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	

	
	

}
