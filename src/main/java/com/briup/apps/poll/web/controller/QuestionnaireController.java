package com.briup.apps.poll.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层    问卷
 * @author WE
 *
 */
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireService qunService;
	/**
	 * 查询所有问卷
	 * @return
	 */
	@ApiOperation(value="查询所有问卷",notes="单表")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = qunService.findAllQuestionnaire();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过id查询问卷
	 * @return
	 */
	@ApiOperation(value="通过id查询问卷",notes="问卷下具有问题信息")
	@GetMapping("selectQunVMById")
	public MsgResponse selectQunVMById(long id){
		try {
            QuestionnaireVM questionnaireVM = qunService.selectQunById(id);
			return MsgResponse.success("success", questionnaireVM);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 批量删除问卷
	 * @param ids
	 * @return
	 */
	@ApiOperation(value="批量删除问卷",notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
	@PostMapping("batchDeleteQuestion")
	public MsgResponse batchDeleteQuestion(long[] ids){
		try {
			qunService.batchDelete(ids);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 根据id删除问卷
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据ID删除问卷信息",notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
	@GetMapping("deleteQuestionnaireById")
	public MsgResponse deleteQuestionnaireById(long id){
		try {
			qunService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 保存或修改问卷信息
	 * @param questionnaire
	 * @param questionIds
	 * @return
	 */
	@ApiOperation(value="保存或修改问卷信息",notes="如果问卷参数中包含id执行更新操作，否则执行修改操作")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
		try {
			qunService.saveOrUpdate(questionnaire, questionIds);
			return MsgResponse.success("保存或修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
