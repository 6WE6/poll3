package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;
/**
 * 业务逻辑接口    用户
 * @author WE
 *
 */
public interface IUserService {
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	List<User> findAllUser() throws Exception;
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User findUserById(long id) throws Exception;
	/**
	 * 通过关键字查询用户
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<User> findUserByKeyword(String keywords) throws Exception;
	/**
	 * 保存或修改用户信息
	 * @param user
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateUser(User user) throws Exception;
	/**
	 * 通过id删除用户信息
	 * @param id
	 * @throws Exception
	 */
	void deleteUserById(long id) throws Exception;
	/**
	 * 批量删除用户信息
	 * @param user
	 * @throws Exception
	 */
	void batchDeleteUser(Long[] ids) throws Exception;

}
