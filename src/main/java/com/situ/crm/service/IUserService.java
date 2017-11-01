package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.User;

public interface IUserService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @param userName 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows, User user);

	ServerResponse delete(String ids);

	ServerResponse addUser(User user);

	ServerResponse updateUser(User user);

	List<User> findRoleName();

	Boolean checkName(String name);

	Boolean checkPassowrd(String password, String name);

	ServerResponse updateUserByName(User user);

	User login2(String name, String password);

	List<User> getCustomerManagerList();
}
