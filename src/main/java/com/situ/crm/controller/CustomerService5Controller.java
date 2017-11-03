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
import com.situ.crm.service.ICustomerService5Service;

@Controller
@RequestMapping("/customerService5")
public class CustomerService5Controller {
	@Autowired
	private ICustomerService5Service customerService5Service;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/updateCustomerService5")
	@ResponseBody
	public ServerResponse updateCustomerService5(CustomerService customerService5){
		return customerService5Service.updateCustomerService5(customerService5);
	}
	
	@RequestMapping(value="/addCustomerService5")
	@ResponseBody
	public ServerResponse addCustomerService5(CustomerService customerService5){
		return customerService5Service.addCustomerService5(customerService5);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerService5Service.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customerService5_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Date startTime, Date endTime, CustomerService customerService5) {
		System.out.println(page + "+" + rows);
		return customerService5Service.findAll(page, rows, customerService5, startTime, endTime);
	}
}
