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

import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.CustomerOrder;
import com.situ.crm.service.ICustomerOrderService;

@Controller
@RequestMapping("/customerOrder")
public class CustomerOrderController {

	@Autowired
	private ICustomerOrderService customerOrderService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/index")
	public String index(){
		return "customerOrder_manager";
	}
	
	
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return customerOrderService.deleteById(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerOrder customerOrder) {
		return customerOrderService.update(customerOrder);
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(CustomerOrder customerOrder){
		return customerOrderService.add(customerOrder);
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<CustomerOrder> findAll(Integer id){
		System.out.println(id);
		return customerOrderService.findAll(id);
	}
}
