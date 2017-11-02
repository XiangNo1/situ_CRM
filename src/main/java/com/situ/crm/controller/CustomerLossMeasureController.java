package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerLossMeasure;
import com.situ.crm.service.ICustomerLossMeasureService;

@Controller
@RequestMapping("/customerLossMeasure")
public class CustomerLossMeasureController {

	@Autowired
	private ICustomerLossMeasureService customerLossMeasureService;
	@RequestMapping(value="/index")
	public String index(){
		return "customerLossMeasure_manager";
	}
	
	
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return customerLossMeasureService.deleteById(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerLossMeasure customerLossMeasure) {
		return customerLossMeasureService.update(customerLossMeasure);
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(CustomerLossMeasure customerLossMeasure){
		return customerLossMeasureService.add(customerLossMeasure);
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<CustomerLossMeasure> findAll(Integer id){
		System.out.println(id);
		return customerLossMeasureService.findAll(id);
	}
}
