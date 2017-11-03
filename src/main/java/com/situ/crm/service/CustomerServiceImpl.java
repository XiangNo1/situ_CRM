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
import com.situ.crm.dao.CustomerLossMapper;
import com.situ.crm.dao.CustomerMapper;
import com.situ.crm.dao.CustomerOrderMapper;
import com.situ.crm.dao.CustomerServiceMapper;
import com.situ.crm.pojo.Customer;
import com.situ.crm.pojo.CustomerExample;
import com.situ.crm.pojo.CustomerExample.Criteria;
import com.situ.crm.pojo.CustomerLoss;
import com.situ.crm.pojo.CustomerOrder;
import com.situ.crm.pojo.CustomerService;
import com.situ.crm.pojo.User;
import com.situ.crm.pojo.UserExample;
import com.situ.crm.util.Util;
import com.situ.crm.vo.CustomerConstitute;
import com.situ.crm.vo.CustomerContribute;
import com.situ.crm.vo.khfu;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CustomerServiceMapper customerServiceMapper;
	@Autowired
 	private CustomerOrderMapper customerOrderMapper;
 	
 	@Autowired
 	private CustomerLossMapper customerLossMapper;
 	
 	@Override
 	 	public void checkCustomerLoss() {
 	 		System.out.println("CustomerServiceImpl.checkCustomerLoss()");
 	 		//1. 查找流失客户
 	 		List<Customer> customerList = customerMapper.findLossCustomer();
 	 		for (Customer customer : customerList) {
 	 			//2. 实例化CustomerLoss
 	 			CustomerLoss customerLoss = new CustomerLoss();
 	 			customerLoss.setCustomerNo(customer.getNum());//客户编号
 	 			customerLoss.setCustomerName(customer.getName());//客户名称
 	 			customerLoss.setCustomerManager(customer.getManagerName());//客户经理
 	 			//3.查找指定客户最近的一次订单
 	 			CustomerOrder customerOrder = customerOrderMapper.findLastOrderByCustomerId(customer.getId());
 	 			if (customerOrder == null) {
 	 				customerLoss.setLastOrderTime(null);
 	 			} else {
 	 				customerLoss.setLastOrderTime(customerOrder.getOrderDate());
 	 			}
 	 			//4.添加到客户流失表里面
 	 			customerLossMapper.insert(customerLoss);
 	 			//5、客户表中客户状态修改为1：流失状态
 	 			customer.setStatus(1);
 	 			customerMapper.updateByPrimaryKeySelective(customer);
 	 		}
 	 	}
 	
	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, Customer customer) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		CustomerExample customerExample = new CustomerExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = customerExample.createCriteria();
		if (StringUtils.isNotEmpty(customer.getName())) {
			try {
				createCriteria.andNameLike(Util.formatLike(new String(customer.getName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(customer.getNum())) {
			try {
				createCriteria.andNumLike(Util.formatLike(new String(customer.getNum().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<Customer> customerList = customerMapper.selectByExample(customerExample);
		PageInfo<Customer> pageInfo = new PageInfo<>(customerList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(customerList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(customerMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addCustomer(Customer customer) {
		try {
			if(customerMapper.insert(customer) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateCustomer(Customer customer) {
		try {
			if(customerMapper.updateByPrimaryKey(customer) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public EasyUIDataGrideResult findCustomerContribute(Integer page, Integer rows,
			CustomerContribute customerContribute) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		String name = customerContribute.getName();
		if (StringUtils.isNotEmpty(name)) {
			try {
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name);
		//list
		List<CustomerContribute> list = customerMapper.findCustomerContribute(name);
		PageInfo<CustomerContribute> pageInfo = new PageInfo<>(list);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(list);
		return result;
	}

	@Override
	public ServerResponse findCustomerConstitute() {
		// TODO Auto-generated method stub
		List<CustomerConstitute> list = customerMapper.findCustomerConstitute();
		return ServerResponse.createSuccess("查找成功", list);
	}

	@Override
	public ServerResponse findkhfw() {
		// TODO Auto-generated method stub
		List<khfu> list = customerServiceMapper.findkhfw();
		return ServerResponse.createSuccess("查找成功", list);
	}



}
