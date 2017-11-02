package com.situ.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Customer;
import com.situ.crm.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value="/findById")
	@ResponseBody
	public Customer findById(Integer id){
		return customerService.findById(id);
	}
	
	@RequestMapping(value="/updateCustomer")
	@ResponseBody
	public ServerResponse updateCustomer(Customer customer){
		return customerService.updateCustomer(customer);
	}
	
	@RequestMapping(value="/addCustomer")
	@ResponseBody
	public ServerResponse addCustomer(Customer customer){
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customer_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Customer customer) {
		System.out.println(page + "+" + rows);
		return customerService.findAll(page, rows, customer);
	}
}
