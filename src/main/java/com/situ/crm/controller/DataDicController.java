package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.DataDic;
import com.situ.crm.service.IDataDicService;

@Controller
@RequestMapping("/dataDic")
public class DataDicController {
	@Autowired
	private IDataDicService dataDicService;

	@RequestMapping(value="/findDataDicName")
	@ResponseBody
	public List<DataDic> findDataDicName(){
		return dataDicService.findDataDicName();
	}
	
	@RequestMapping(value="/updateDataDic")
	@ResponseBody
	public ServerResponse updateDataDic(DataDic dataDic){
		return dataDicService.updateDataDic(dataDic);
	}
	
	@RequestMapping(value="/addDataDic")
	@ResponseBody
	public ServerResponse addDataDic(DataDic dataDic){
		return dataDicService.addDataDic(dataDic);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return dataDicService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "dataDic_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, DataDic dataDic) {
		System.out.println(page + "+" + rows);
		return dataDicService.findAll(page, rows, dataDic);
	}
}
