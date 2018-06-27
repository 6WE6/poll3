package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="题库相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	/**
	 * 基础查询所有题库信息
	 * @return
	 */
	@ApiOperation(value="基础查询所有题库信息")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list = questionService.findAllQuestion();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 一对多关联查询所有题库信息
	 * @return
	 */
	@ApiOperation(value="基础查询所有题库信息")
	@GetMapping("selectAllQuestion")
	public MsgResponse selectAllQuestion(){
		try {
			List<QuestionVM> list = questionService.selectAllQuestion();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
