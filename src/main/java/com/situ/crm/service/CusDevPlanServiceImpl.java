package com.situ.crm.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.dao.CusDevPlanMapper;
import com.situ.crm.dao.SaleChanceMapper;
import com.situ.crm.pojo.CusDevPlan;
import com.situ.crm.pojo.CusDevPlanExample;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.SaleChanceExample;
import com.situ.crm.pojo.SaleChanceExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class CusDevPlanServiceImpl implements ICusDevPlanService{
	@Autowired
	private SaleChanceMapper saleChanceMapper;
	@Autowired
	private CusDevPlanMapper cusDevPlanMapper;
	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, SaleChance saleChance, Date startTime, Date endTime) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		SaleChanceExample saleChanceExample = new SaleChanceExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = saleChanceExample.createCriteria();
		createCriteria.andStatusEqualTo(1);
		if (StringUtils.isNotEmpty(saleChance.getCustomerName())) {
			try {
				createCriteria.andCustomerNameLike(Util.formatLike(new String(saleChance.getCustomerName().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(saleChance.getAssignMan())) {
			try {
				createCriteria.andAssignManLike(Util.formatLike(new String(saleChance.getAssignMan().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != saleChance.getDevResult()) {
			createCriteria.andDevResultEqualTo(saleChance.getDevResult());
	}
		if (null != startTime && null != endTime) {
			createCriteria.andCreateTimeBetween(startTime, endTime);
		}
		//list
		List<SaleChance> saleChanceList = saleChanceMapper.selectByExample(saleChanceExample);
		PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChanceList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(saleChanceList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(saleChanceMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addSaleChance(SaleChance saleChance) {
		if (null != saleChance.getAssignTime()) {
			saleChance.setStatus(1);
			saleChance.setDevResult(0);
		}else{
			saleChance.setStatus(0);
		}
		try {
			if(saleChanceMapper.insert(saleChance) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateSaleChance(SaleChance saleChance) {
		if (null != saleChance.getAssignTime()) {
			saleChance.setStatus(1);
			saleChance.setDevResult(0);
		}else{
			saleChance.setStatus(0);
		}
		try {
			if(saleChanceMapper.updateByPrimaryKey(saleChance) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public List<CusDevPlan> findAllItem(Integer saleChanceId) {
		CusDevPlanExample cusDevPlanExample = new CusDevPlanExample();
		com.situ.crm.pojo.CusDevPlanExample.Criteria criteria = cusDevPlanExample.createCriteria();
		criteria.andSaleChanceIdEqualTo(saleChanceId);
		return cusDevPlanMapper.selectByExample(cusDevPlanExample);
	}

	@Override
	public ServerResponse add(CusDevPlan cusDevPlan) {
		// TODO Auto-generated method stub
		if (cusDevPlanMapper.insert(cusDevPlan) > 0) {
			return ServerResponse.createSuccess("添加成功! ");
		}
		return ServerResponse.createError("添加失败!");
	}

	@Override
	public ServerResponse update(CusDevPlan cusDevPlan) {
		if (cusDevPlanMapper.updateByPrimaryKey(cusDevPlan) > 0) {
			return ServerResponse.createSuccess("修改成功! ");
		}
		return ServerResponse.createError("修改失败!");
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		if (cusDevPlanMapper.deleteByPrimaryKey(id) > 0) {
			return ServerResponse.createSuccess("删除数据成功 ");
		}
		return ServerResponse.createSuccess("数据已经成功删除");
	}




}
