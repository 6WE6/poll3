package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层   用户
 * @author WE
 *
 */
@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	/**
	 * 查询所有用户信息
	 */
	@ApiOperation(value="查询所有用户信息",notes="保存用户信息时无需输入id")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list =userService.findAllUser();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}		
	}
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value="通过id查询用户信息")
	@GetMapping("findUserById")
	public MsgResponse findUserById(@RequestParam long id){
		User User = new User();
		try {
			User = userService.findUserById(id);
			return MsgResponse.success("success", User);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 通过id删除用户信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value="通过id删除用户信息")
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(@RequestParam long id){
		//调用service层代码完成用户信息的删除
		try {
			userService.deleteUserById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}
	/**
	 * 通过关键字查询用户信息
	 * @param keywords
	 * @return
	 */
	@ApiOperation(value="通过关键字查询用户信息")
	@GetMapping("findUserByKeyword")
	public MsgResponse findUserByKeyword(@RequestParam String keywords){
		try {
			List<User> user = userService.findUserByKeyword(keywords);
			return MsgResponse.success("success", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	/**
	 * 保存或更新用户信息
	 * @param User
	 * @return
	 */
	@ApiOperation(value="保存或更新用户信息")
	@PostMapping("saveOrUpdateUser")
	public MsgResponse saveOrUpdateUser(User user){
		try {
			userService.saveOrUpdateUser(user);
			return MsgResponse.success("success", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 批量删除用户信息
	 * @param ids
	 * @return
	 */
	@ApiOperation(value="批量删除用户信息")
	@GetMapping("batchDeleteUser")
	public MsgResponse batchDeleteCoure(Long[] ids){
		try {
			userService.batchDeleteUser(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	

}
