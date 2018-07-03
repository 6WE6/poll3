package com.briup.apps.poll.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答卷相关接口")
@RestController
@RequestMapping("/answers")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;
	/**
	 * 删除答卷主观题
	 * @param id
	 * @return
	 */
	@ApiOperation(value="删除答卷主观题",notes="单选题和多选题不受影响")
	@GetMapping("deleteAnswersContent")
	public MsgResponse deleteAnswersContent(long id){
		try {
			//通过id查找答卷
			Answers answers = answersService.findAnswersById(id);
			//设置答卷为空
			answers.setContent("");
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 修改答卷主观题
	 * @param id
	 * @param content
	 * @return
	 */
	@ApiOperation(value="修改答卷主观题",notes="")
	@GetMapping("updateContent")
	public MsgResponse updateContent(long id,String content){
		try {
			//通过id查找答卷
			Answers answers = answersService.findAnswersById(id);
			//设置答卷为content
			answers.setContent("content");
			answersService.saveOrUpdateAnswers(answers);
			return MsgResponse.success("修改成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());	
	}

}
}
