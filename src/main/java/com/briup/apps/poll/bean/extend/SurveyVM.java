package com.briup.apps.poll.bean.extend;


import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;
import io.swagger.annotations.ApiModel;
/**
 * POJO中间类    课调
 * @author WE
 */
@ApiModel(value="课调")
public class SurveyVM {
	//survey的基础属性
    private Long id;
    private double average;
    private String status;
    private String code;
    private String surveydate;
    //survey的关联属性
	private Course course;
	//查询班级所属的年级，要用ClazzVM
	private ClazzVM clazzVM;
	private User user;
	//预览时要查询问卷下的问题和选项，要用QuestionnaireVM
	private QuestionnaireVM questionnaireVM;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSurveydate() {
		return surveydate;
	}
	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ClazzVM getClazzVM() {
		return clazzVM;
	}
	public void setClazzVM(ClazzVM clazzVM) {
		this.clazzVM = clazzVM;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public QuestionnaireVM getQuestionnaireVM() {
		return questionnaireVM;
	}
	public void setQuestionnaireVM(QuestionnaireVM questionnaireVM) {
		this.questionnaireVM = questionnaireVM;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
}
