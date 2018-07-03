package com.briup.apps.poll.web.controller;

import java.util.List;

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
import com.briup.apps.poll.vm.SurveyAndAnswersVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层    课调
 * @author WE
 *
 */
@RestController
@RequestMapping("/survey")
@Api(description="课调相关接口")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;
	/**
	 * 教务处长审核课调
	 * @param id
	 * @return
	 */
	@ApiOperation(value="去审核课调",notes="返回课调信息以及课调下的所有答卷信息")
	@PostMapping("toCheckSurvey")
	public MsgResponse toCheckSurvey(long id){
		try {
			//1.通过id查询课调信息
			SurveyVM surveyVM = surveyService.selectSurveyById(id);
			//2.如果课调状态为未审核状态,才允许审核该课调
			if(surveyVM.getStatus().equals(Survey.STATUS_CHECK_UN)){
				//查询出该课调下所有答卷
				List<Answers> answers = answersService.findAnswersBySurveyId(id);
				//计算出课调的平均分
				//所有单个平均分的综合
				double total = 0;
				for(Answers answer : answers){
					//["5","4","5"]
					String[] arr = answer.getSelections().split("[|]");
					double singleTotal = 0;
					for(String a : arr){
						singleTotal +=Integer.parseInt(a);
					}
					//每个学生对于老师的平均分
					double singleAverage = singleTotal/arr.length;
					total += singleAverage;
 				}
				double average = total/answers.size();
				surveyVM.setAverage(average);
				
				//将平均分保存到数据库
				Survey survey = surveyService.findSurveyById(id);
				//如果数据库中的平均分没有设定，我们在进行设定，否则不做操作
				if(survey.getAverage()==null){
					survey.setAverage(average);
					surveyService.saveOrUpdateSurvey(survey);
				}
				
				//如何将surveyVM和answers返回,封装到SurveyAndAnswersVM中
				SurveyAndAnswersVM savm = new SurveyAndAnswersVM();
				savm.setSurveyVM(surveyVM);
				savm.setAnswers(answers);		
				return MsgResponse.success("success", savm);
			}
			else{
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 保存或更新课调信息
	 * @param survey
	 * @return
	 */
	@PostMapping("saveOrUpdateSurvey")
	@ApiOperation(value="保存或更新课调信息，如果参数中包含id表示修改，否则表示新增，只需要接收calzzId,userId,questionnaireId,courseId")
	public MsgResponse saveOrUpdateSurvey(Survey survey){
		try {
			surveyService.saveOrUpdateSurvey(survey);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 查询所有课调信息
	 * @param
	 * @return
	 */
	@GetMapping("selectAllSurvey")
	@ApiOperation(value="级联查询所有课调",notes="级联查询课调中的课程，用户，班级，问卷")
	public MsgResponse selectAllSurvey(){
		try {
			List<SurveyVM> list = surveyService.selectAllSurvey();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 根据id查询课调信息
	 * @param id
	 * @return
	 */
	@GetMapping("selectSurveyVMById")
	@ApiOperation(value="根据id查询所有课调",notes="级联查询课调中的课程，用户，班级，问卷")
	public MsgResponse selectSurveyVMById(long id){
		try {
			SurveyVM surveyVM =  surveyService.selectSurveyById(id);
			return MsgResponse.success("success", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过id删除课调信息
	 * @param id
	 * @return
	 */
	@GetMapping("deleteSurveyById")
	@ApiOperation(value="根据id删除课调信息",notes="级联删除课调下的答卷信息")
	public MsgResponse deleteSurveyById(long id){
		try {
			surveyService.deleteSurveyById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 批量删除课调信息
	 * @param id
	 * @return
	 */
	@GetMapping("BatchDeleteSurvey")
	@ApiOperation(value="批量删除课调信息",notes="级联删除课调下的答卷信息")
	public MsgResponse BatchDeleteSurvey(long[] ids){
		try {
			surveyService.batchDeleteSurvey(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 开启课调
	 * @param id
	 * @return
	 */
	@GetMapping("beginSurvey")
	@ApiOperation(value="开启课调",notes="只有在课调状态在未开启时，才能开启课调")
	public MsgResponse beginSurvey(long id){
		try {
			//1.通过id查询出课调
			Survey survey = surveyService.findSurveyById(id);
			//2.修改课调的状态和课调编号
			if(survey.getStatus().equals(Survey.STATUS_INIT)){
				//2.1将课调状态设置为开启
				survey.setStatus(Survey.STATUS_BEGIN);
				//2.2将课调的code设置为当前课调的id,后期要通过code找id
				survey.setCode(survey.getId().toString());
				//2.3执行保存或更新操作
				surveyService.saveOrUpdateSurvey(survey);
				return MsgResponse.success("课调开启成功！", null);
			}else{
				return MsgResponse.error("当前课调状态必须为未开启状态");
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@GetMapping("stopSurvey")
	@ApiOperation(value="关闭课调",notes="只有在课调状态在开启状态时，才能关闭课调")
	public MsgResponse stopSurvey(long id){
		try {
			//1.通过id查询出课调
			Survey survey = surveyService.findSurveyById(id);
			if(survey != null && survey.getStatus().equals(Survey.STATUS_BEGIN)){
				
				survey.setStatus(Survey.STATUS_CHECK_UN);
				surveyService.saveOrUpdateSurvey(survey);
				return MsgResponse.success("关闭课调成功！", null);
			}
			else{
				return MsgResponse.error("当前课调状态必须为开启状态");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	

}