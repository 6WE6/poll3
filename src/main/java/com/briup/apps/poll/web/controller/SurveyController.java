package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;
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

}