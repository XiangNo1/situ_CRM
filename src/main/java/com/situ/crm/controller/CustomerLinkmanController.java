package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLinkman;
import com.situ.crm.service.ICustomerLinkmanService;

@Controller
@RequestMapping("/customerLinkman")
public class CustomerLinkmanController {

	@Autowired
	private ICustomerLinkmanService customerLinkmanService;
	@RequestMapping(value="/index")
	public String index(){
		return "customerLinkman_manager";
	}
	
	
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return customerLinkmanService.deleteById(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerLinkman customerLinkman) {
		return customerLinkmanService.update(customerLinkman);
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(CustomerLinkman customerLinkman){
		return customerLinkmanService.add(customerLinkman);
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<CustomerLinkman> findAll(Integer id){
		System.out.println(id);
		return customerLinkmanService.findAll(id);
	}
}
