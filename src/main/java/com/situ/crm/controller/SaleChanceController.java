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
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.service.ISaleChanceService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@Autowired
	private ISaleChanceService saleChanceService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@RequestMapping(value="/updateDevResult")
	@ResponseBody
	public ServerResponse updateDevResult(Integer saleChanceId, Integer devResult){
		return saleChanceService.updateDevResult(saleChanceId, devResult);
	}
	
	@RequestMapping(value="/cusDevPlan")
	public String cusDevPlan(){
		return "cus_dev_plan_manager";
	}
	
	
	@RequestMapping(value="/updateSaleChance")
	@ResponseBody
	public ServerResponse updateSaleChance(SaleChance saleChance){
		return saleChanceService.updateSaleChance(saleChance);
	}
	
	@RequestMapping(value="/addSaleChance")
	@ResponseBody
	public ServerResponse addSaleChance(SaleChance saleChance){
		return saleChanceService.addSaleChance(saleChance);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return saleChanceService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "saleChance_manager";
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public ServerResponse findById(Integer id) {
		return saleChanceService.findById(id);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance, Date startTime, Date endTime) {
		System.out.println(startTime);
		System.out.println(endTime);
		return saleChanceService.findAll(page, rows, saleChance, startTime, endTime);
	}
}
