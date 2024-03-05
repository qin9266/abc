package com.dgut.sc.dao;


import com.dgut.sc.domain.Admin;

public interface AdminDao {

	/**
	 * 更新一条管理员信息
	 * @param student
	 * @return
	 */
	boolean updateAdmin(String admin,String password);
	
	/**
	 * 查询一条管理员信息
	 * @param sno
	 * @return
	 */
	Admin queryAdmin(String admin);
	/**
	 * 查询一条管理员信息
	 * @param sno
	 * @return
	 */
	Admin queryAdmin(String admin,String password);
}
