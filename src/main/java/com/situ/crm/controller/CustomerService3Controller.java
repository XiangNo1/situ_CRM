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
import com.situ.crm.service.ICustomerService3Service;

@Controller
@RequestMapping("/customerService3")
public class CustomerService3Controller {
	@Autowired
	private ICustomerService3Service customerService3Service;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/updateCustomerService3")
	@ResponseBody
	public ServerResponse updateCustomerService3(CustomerService customerService3){
		return customerService3Service.updateCustomerService3(customerService3);
	}
	
	@RequestMapping(value="/addCustomerService3")
	@ResponseBody
	public ServerResponse addCustomerService3(CustomerService customerService3){
		return customerService3Service.addCustomerService3(customerService3);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerService3Service.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customerService3_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService3) {
		System.out.println(page + "+" + rows);
		return customerService3Service.findAll(page, rows, customerService3);
	}
}
