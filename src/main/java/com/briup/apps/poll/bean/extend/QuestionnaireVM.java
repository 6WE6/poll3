package com.briup.apps.poll.bean.extend;

import java.util.List;

import io.swagger.annotations.ApiModel;
/**
 * 问卷实体    问卷下包含多个问题，如果问题是单选或多选，也应包含包含多个选项信息
 * @author WE
 *
 */

@ApiModel(value="问卷模型，包含多个问题")
public class QuestionnaireVM {
	private Long id;
	private String name;
	private String description;
	//问题下包含多个选项
	private List<QuestionVM> questionVMs;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<QuestionVM> getQuestionVMs() {
		return questionVMs;
	}
	public void setQuestionVMs(List<QuestionVM> questionVMs) {
		this.questionVMs = questionVMs;
	}	

}
