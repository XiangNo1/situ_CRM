package com.situ.crm.service;

import com.situ.crm.common.EasyUIDataGrideResult;

public interface IUserService {
	/**
	 * 返回所有数据
	 * @param rows 
	 * @param page 
	 * @return 分装好的EasyUIDataGrideResult对象
	 */
	EasyUIDataGrideResult findAll(Integer page, Integer rows);
}
