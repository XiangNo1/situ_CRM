package com.situ.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.dao.UserMapper;
import com.situ.crm.pojo.User;
import com.situ.crm.pojo.UserExample;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows) {
		System.out.println(page + "+" + rows);
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		UserExample userExample = new UserExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//list
		List<User> userList = userMapper.selectByExample(userExample);
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(userList);
		return result;
	}

}
