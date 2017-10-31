package com.situ.crm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.UserMapper;
import com.situ.crm.pojo.User;
import com.situ.crm.pojo.UserExample;
import com.situ.crm.pojo.UserExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, User user) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		UserExample userExample = new UserExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = userExample.createCriteria();
		if (StringUtils.isNotEmpty(user.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(user.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(user.getTrueName())) {
			try {
				createCriteria.andTrueNameLike(Util.formatLike(new String(user.getTrueName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(user.getRoleName())) {
			try {
				createCriteria.andRoleNameEqualTo(new String(user.getRoleName().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<User> userList = userMapper.selectByExample(userExample);
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(userList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(userMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addUser(User user) {
		try {
			if(userMapper.insert(user) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateUser(User user) {
		try {
			if(userMapper.updateByPrimaryKey(user) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public List<User> findRoleName() {
		// TODO Auto-generated method stub
		return userMapper.findRoleName();
	}

	@Override
	public Boolean checkName(String name) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (StringUtils.isNotEmpty(name)) {
			try {
				createCriteria.andNameEqualTo(new String(name.getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<User> userList = userMapper.selectByExample(userExample);
		for (User user : userList) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkPassowrd(String password, String name) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (StringUtils.isNotEmpty(name)) {
			try {
				createCriteria.andNameEqualTo(new String(name.getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(password)) {
			try {
				createCriteria.andPasswordEqualTo(new String(password.getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<User> userList = userMapper.selectByExample(userExample);
		for (User user : userList) {
			return true;
		}
		return false;
	}

	@Override
	public ServerResponse updateUserByName(User user) {
		try {
			if(userMapper.updateUserByName(user) < 1){
				return ServerResponse.createError("修改数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("修改数据失败！");
		}
		return ServerResponse.createSuccess("修改数据成功！");
	}

}
