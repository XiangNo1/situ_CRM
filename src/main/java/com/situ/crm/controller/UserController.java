package com.situ.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.User;
import com.situ.crm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	
	@RequestMapping(value="/updateUser")
	@ResponseBody
	public ServerResponse updateUser(User user){
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="/addUser")
	@ResponseBody
	public ServerResponse addUser(User user){
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return userService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "user_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, User user) {
		System.out.println(page + "+" + rows);
		return userService.findAll(page, rows, user);
	}
}
