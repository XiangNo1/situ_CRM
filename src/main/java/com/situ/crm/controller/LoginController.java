package com.situ.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/loginout")
	@ResponseBody
	public ServerResponse loginout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");
		if (null == session.getAttribute("currentUser")) {
			return ServerResponse.createSuccess("退出成功");
		}else{
			return ServerResponse.createError("退出失败");
		}
		
	}
	
	@RequestMapping(value="/login2")
	@ResponseBody
	public ServerResponse login2(String name, String password, HttpServletRequest request){
		User user = userService.login2(name, password);
		if (null != user) {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			return ServerResponse.createSuccess("登陆成功");
		}else{
			return ServerResponse.createError("用户名或密码错误！");
		}
	}
	
	@RequestMapping(value="/login")
	public String Login(){
		return "login";
	}
	
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
