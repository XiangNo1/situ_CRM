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
import com.situ.crm.pojo.CustomerLoss;
import com.situ.crm.service.ICustomerLossService;

@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {
	@Autowired
	private ICustomerLossService customerLossService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/findById")
	@ResponseBody
	public CustomerLoss findById(Integer id){
		return customerLossService.findById(id);
	}
	
	@RequestMapping(value="/updateCustomerLoss")
	@ResponseBody
	public ServerResponse updateCustomerLoss(CustomerLoss customerLoss){
		return customerLossService.updateCustomerLoss(customerLoss);
	}
	
	@RequestMapping(value="/addCustomerLoss")
	@ResponseBody
	public ServerResponse addCustomerLoss(CustomerLoss customerLoss){
		return customerLossService.addCustomerLoss(customerLoss);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return customerLossService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "customer_loss_manager";
	}
	@RequestMapping("/index2")
	public String index2() {
		return "customer_loss_manager2";
	}
	@RequestMapping("/findAll2")
	@ResponseBody
	public EasyUIDataGrideResult findAll2(Integer page, Integer rows, CustomerLoss customerLoss) {
		System.out.println(page + "+" + rows);
		return customerLossService.findAll2(page, rows, customerLoss);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerLoss customerLoss) {
		System.out.println(page + "+" + rows);
		return customerLossService.findAll(page, rows, customerLoss);
	}
}
