package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 按模板查询所有用户(QBC查询)
	 */
	@Override
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}
	/**
	 * 通过id查询用户信息
	 */
	@Override
	public User findUserById(long id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}
	/**
	 * 通过关键字查询用户信息
	 */
	@Override
	public List<User> findUserByKeyword(String keywords) throws Exception {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		//添加条件：name属性中包含keywords关键字
		example.createCriteria().andNameLike("%"+keywords+"%");
		return userMapper.selectByExample(example);
	}
	/**
	 * 保存或更新用户信息
	 */
	@Override
	public void saveOrUpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User count= userMapper.selectByPrimaryKey(user.getId());
		if(count!=null){
			//更新
			userMapper.updateByPrimaryKey(user);
		}else{
			//插入
			userMapper.insert(user);
		}
	}
	/**
	 * 通过id删除用户信息
	 */
	@Override
	public void deleteUserById(long id) throws Exception {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);	
	}
	/**
	 * 批量删除用户信息
	 */
	@Override
	public void batchDeleteUser(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		//forEach循环遍历数组或集合
		for(long id : ids){
			userMapper.deleteByPrimaryKey(id);
		}		
	}

}
