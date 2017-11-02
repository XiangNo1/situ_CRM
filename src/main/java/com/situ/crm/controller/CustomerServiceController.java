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
import com.situ.crm.service.ICustomerServiceService;

@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {
	@Autowired
	private ICustomerServiceService customerServiceService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/findRoleName")
	@ResponseBody
	public List<CustomerService> findRoleName(){
		return customerServiceService.findRoleName();
	}
	
	@RequestMapping(value="/updateCustomerService")
	@ResponseBody
	public ServerResponse updateCustomerService(CustomerService customerService){
		return customerServiceService.updateCustomerService(customerService);
	}
	
	@RequestMapping(value="/addCustomerService")
	@ResponseBody
	public ServerResponse addCustomerService(CustomerService customerService){
		return customerServiceService.addCustomerService(customerService);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerServiceService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customerService_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService) {
		System.out.println(page + "+" + rows);
		return customerServiceService.findAll(page, rows, customerService);
	}
}
