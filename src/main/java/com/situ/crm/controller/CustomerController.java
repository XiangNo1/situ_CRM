package com.situ.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Customer;
import com.situ.crm.service.ICustomerService;
import com.situ.crm.vo.CustomerContribute;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value="/getkhfw")
	public String getkhfw(){
		return "khfw";
	}
	
	@RequestMapping(value="/findkhfw")
	@ResponseBody
	public ServerResponse findkhfw(){
		return customerService.findkhfw();
	}
	
	@RequestMapping(value="/getkhgc")
	public String getkhgc(){
		return "khgc";
	}
	
	@RequestMapping(value="/findCustomerConstitute")
	@ResponseBody
	public ServerResponse findCustomerConstitute(){
		return customerService.findCustomerConstitute();
	}
	
	@RequestMapping(value="/findById")
	@ResponseBody
	public Customer findById(Integer id){
		return customerService.findById(id);
	}
	@RequestMapping(value="/getCustomerContributePage")
	public String getCustomerContributePage(){
		return "customer_contribute_manager";
	}
	
	@RequestMapping(value="/findCustomerContribute")
	@ResponseBody
	public EasyUIDataGrideResult findCustomerContribute(Integer page, Integer rows, CustomerContribute customerContribute){
		return customerService.findCustomerContribute(page, rows, customerContribute);
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
