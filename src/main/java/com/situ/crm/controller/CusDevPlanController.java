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
import com.situ.crm.pojo.CusDevPlan;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.service.ICusDevPlanService;

import net.sf.jsqlparser.statement.create.table.Index;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.AddAliasesVisitor;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {

	@Autowired
	private ICusDevPlanService cusDevPlanService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return cusDevPlanService.deleteById(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CusDevPlan cusDevPlan) {
		return cusDevPlanService.update(cusDevPlan);
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(CusDevPlan cusDevPlan){
		return cusDevPlanService.add(cusDevPlan);
	}
	
	@RequestMapping(value="/findAllItem")
	@ResponseBody
	public List<CusDevPlan> findAllItem(Integer saleChanceId){
		return cusDevPlanService.findAllItem(saleChanceId);
	}
	
	@RequestMapping(value="/index")
	public String index(){
		return "cus_dev_plan_item_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance, Date startTime, Date endTime) {
		System.out.println(startTime);
		System.out.println(endTime);
		return cusDevPlanService.findAll(page, rows, saleChance, startTime, endTime);
	}
}
