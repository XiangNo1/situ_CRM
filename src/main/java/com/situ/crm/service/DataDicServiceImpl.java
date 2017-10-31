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
import com.situ.crm.dao.DataDicMapper;
import com.situ.crm.pojo.DataDic;
import com.situ.crm.pojo.DataDicExample;
import com.situ.crm.pojo.DataDicExample.Criteria;
import com.situ.crm.util.Util;

@Service
public class DataDicServiceImpl implements IDataDicService{
	@Autowired
	private DataDicMapper dataDicMapper;

	@Override
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, DataDic dataDic) {
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		DataDicExample dataDicExample = new DataDicExample();
		//设置分页
		PageHelper.startPage(page, rows);
		//rows(分页之后的数据)
		Criteria createCriteria = dataDicExample.createCriteria();
		if (StringUtils.isNotEmpty(dataDic.getDataDicName())) {
			try {
				createCriteria.andDataDicNameEqualTo(new String(dataDic.getDataDicName().getBytes("iso-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(dataDic.getDataDicValue())) {
			try {
				createCriteria.andDataDicValueLike(Util.formatLike(new String(dataDic.getDataDicValue().getBytes("iso-8859-1"),"utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//list
		List<DataDic> dataDicList = dataDicMapper.selectByExample(dataDicExample);
		PageInfo<DataDic> pageInfo = new PageInfo<>(dataDicList);
		//total
		Integer total = (int) pageInfo.getTotal();
		result.setTotal(total);
		result.setRows(dataDicList);
		return result;
	}

	@Override
	public ServerResponse delete(String ids) {
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				if(dataDicMapper.deleteByPrimaryKey(Integer.parseInt(id)) <1){
					return ServerResponse.createError("删除数据失败！");
				}
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除数据失败！");
		}
		return ServerResponse.createSuccess("删除数据成功！");
	}

	@Override
	public ServerResponse addDataDic(DataDic dataDic) {
		try {
			if(dataDicMapper.insert(dataDic) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public ServerResponse updateDataDic(DataDic dataDic) {
		try {
			if(dataDicMapper.updateByPrimaryKey(dataDic) < 1){
				return ServerResponse.createError("添加数据失败！");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加数据失败！");
		}
		return ServerResponse.createSuccess("添加数据成功！");
	}

	@Override
	public List<DataDic> findDataDicName() {
		// TODO Auto-generated method stub
		return dataDicMapper.findDataDicName();
	}

}
