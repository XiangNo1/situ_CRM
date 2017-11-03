package com.situ.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerService;
import com.situ.crm.service.ICustomerService2Service;

@Controller
@RequestMapping("/customerService2")
public class CustomerService2Controller {
	@Autowired
	private ICustomerService2Service customerService2Service;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/updateCustomerService2")
	@ResponseBody
	public ServerResponse updateCustomerService2(CustomerService customerService2){
		return customerService2Service.updateCustomerService2(customerService2);
	}
	
	@RequestMapping(value="/addCustomerService2")
	@ResponseBody
	public ServerResponse addCustomerService2(CustomerService customerService2){
		return customerService2Service.addCustomerService2(customerService2);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerService2Service.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customerService2_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService2) {
		System.out.println(page + "+" + rows);
		return customerService2Service.findAll(page, rows, customerService2);
	}
}
