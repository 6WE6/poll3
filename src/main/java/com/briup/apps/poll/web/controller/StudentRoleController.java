package com.briup.apps.poll.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="学生权限相关接口")
@RestController
@RequestMapping("/studentRole")
public class StudentRoleController {
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;
	/**
	 * 学生登录课调，进行答卷(实际上就是查询课调)
	 * @param id
	 * @return
	 */
	@ApiOperation(value="登录课调",notes="当课调状态为开启时，才能登录课调")
	@GetMapping("loginSurvey")
	public MsgResponse loginSurvey(long id){
		try {
			//1.通过id查找课调
			SurveyVM surveyVM = surveyService.selectSurveyById(id);
			//2.身份验证，判断用户ip，如果ip下的用户已经提交过了问卷就不允许二次提交
			
			//2.如果课调存在，并且课调的状态为"开启",才能返回课调信息，否则返回错误信息
			if(surveyVM !=null && surveyVM.getStatus().equals(Survey.STATUS_BEGIN)){
				return MsgResponse.success("success", null);
			}else{
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 提交答卷
	 * @param answers
	 * @return
	 */
	@ApiOperation(value="提交答卷")
	@PostMapping("submitAnswers")
	public MsgResponse submitAnswers(Answers answers){
		try {
			answersService.saveOrUpdateAnswers(answers);
			return MsgResponse.success("提交成功!您的意见是我们前进的动力!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	

}
