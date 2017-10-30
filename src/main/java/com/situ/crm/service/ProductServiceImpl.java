package com.situ.crm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.ProductMapper;
import com.situ.crm.pojo.Product;
import com.situ.crm.pojo.ProductExample;
import com.situ.crm.pojo.ProductExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductMapper productMapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Product product) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		ProductExample productExample = new ProductExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = productExample.createCriteria();
		if (StringUtils.isNotEmpty(product.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(product.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<Product> productList = productMapper.selectByExample(productExample);
		PageInfo<Product> pageInfo = new PageInfo<>(productList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(productList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(productMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addProduct(Product product) {
		try {
			if(productMapper.insert(product) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateProduct(Product product) {
		try {
			if(productMapper.updateByPrimaryKey(product) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

}
