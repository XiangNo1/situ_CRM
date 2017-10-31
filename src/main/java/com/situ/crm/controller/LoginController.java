package com.situ.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.User;
import com.situ.crm.service.IUserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/updatePassword")
	@ResponseBody
	public ServerResponse updatePassword(User user){
		return userService.updateUserByName(user);
	}
	
	@RequestMapping(value="/checkName")
	@ResponseBody
	public Boolean checkName(String name){
		return userService.checkName(name);
	}
	
	@RequestMapping(value="/checkPassword")
	@ResponseBody
	public Boolean checkPassword(String password, String name){
		return userService.checkPassowrd(password, name);
	}
}
