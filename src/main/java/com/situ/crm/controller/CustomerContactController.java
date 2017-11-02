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
import com.situ.crm.pojo.CustomerContact;
import com.situ.crm.service.ICustomerContactService;

@Controller
@RequestMapping("/customerContact")
public class CustomerContactController {

	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@Autowired
	private ICustomerContactService customerContactService;
	@RequestMapping(value="/index")
	public String index(){
		return "customerContact_manager";
	}
	
	
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return customerContactService.deleteById(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerContact customerContact) {
		return customerContactService.update(customerContact);
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(CustomerContact customerContact){
		return customerContactService.add(customerContact);
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<CustomerContact> findAll(Integer id){
		System.out.println(id);
		return customerContactService.findAll(id);
	}
}
