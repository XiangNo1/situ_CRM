package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value="/findRoleName")
	@ResponseBody
	public List<SaleChance> findRoleName(){
		return saleChanceService.findRoleName();
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
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance) {
		System.out.println(page + "+" + rows);
		return saleChanceService.findAll(page, rows, saleChance);
	}
}
