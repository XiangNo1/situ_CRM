package com.situ.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.CustomerServiceMapper;
import com.situ.crm.pojo.CustomerService;
import com.situ.crm.pojo.CustomerServiceExample;
import com.situ.crm.pojo.CustomerServiceExample.Criteria;

@Service
public class CustomerService4ServiceImpl implements ICustomerService4Service{
	@Autowired
	private CustomerServiceMapper customerService4Mapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, CustomerService customerService4) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerServiceExample customerService4Example = new CustomerServiceExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerService4Example.createCriteria();
		/*if (StringUtils.isNotEmpty(customerService4.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(customerService4.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService4.getTrueName())) {
			try {
				createCriteria.andTrueNameLike(Util.formatLike(new String(customerService4.getTrueName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customerService4.getRoleName())) {
			try {
				createCriteria.andRoleNameEqualTo(new String(customerService4.getRoleName().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//list
		List<CustomerService> customerService4List = customerService4Mapper.selectByExample(customerService4Example);
		PageInfo<CustomerService> pageInfo = new PageInfo<>(customerService4List);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerService4List);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerService4Mapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomerService4(CustomerService customerService4) {
		try {
			if(customerService4Mapper.insert(customerService4) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomerService4(CustomerService customerService4) {
		try {
			if(customerService4Mapper.updateByPrimaryKey(customerService4) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}



}
