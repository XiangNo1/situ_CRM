package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.Product;
import com.situ.crm.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	
	@RequestMapping(value="/updateProduct")
	@ResponseBody
	public ServerResponse updateProduct(Product product){
		return productService.updateProduct(product);
	}
	
	@RequestMapping(value="/addProduct")
	@ResponseBody
	public ServerResponse addProduct(Product product){
		System.out.println(product);
		return productService.addProduct(product);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public ServerResponse delete(String ids){
		return productService.delete(ids);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "product_manager";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Product product) {
		System.out.println(page + "+" + rows);
		return productService.findAll(page, rows, product);
	}
}
