package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	/**
	 * 查询所有班级(基础查询)
	 * @return
	 */
	@ApiOperation(value="基础查询所有班级")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try {
			List<Clazz> list = clazzService.findAllClazz();
			return MsgResponse.success("查找成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 查询所有班级(多对一关联查询)
	 * @return
	 */
	@ApiOperation(value="基础查询所有班级")
	@GetMapping("selectAllClazz")
	public MsgResponse SelectAllClazz(){
		try {
			List<ClazzVM> list = clazzService.selectAllClazz();
			return MsgResponse.success("查找成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 保存或修改班级信息，年级id和chargeid直接维护在clazz表中
	 * @param clazz
	 * @return
	 */
	@ApiOperation(value="保存或修改班级信息",notes="如果参数中包含id则表示修改操作，否则表示保存操作")
	@PostMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateClazz(Clazz clazz){
		try {
			clazzService.saveOrUpdteClazz(clazz);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	

}
