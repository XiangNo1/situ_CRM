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
import com.situ.crm.service.ICustomerService4Service;

@Controller
@RequestMapping("/customerService4")
public class CustomerService4Controller {
	@Autowired
	private ICustomerService4Service customerService4Service;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/updateCustomerService4")
	@ResponseBody
	public ServerResponse updateCustomerService4(CustomerService customerService4){
		return customerService4Service.updateCustomerService4(customerService4);
	}
	
	@RequestMapping(value="/addCustomerService4")
	@ResponseBody
	public ServerResponse addCustomerService4(CustomerService customerService4){
		return customerService4Service.addCustomerService4(customerService4);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerService4Service.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customerService4_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService4) {
		System.out.println(page + "+" + rows);
		return customerService4Service.findAll(page, rows, customerService4);
	}
}
