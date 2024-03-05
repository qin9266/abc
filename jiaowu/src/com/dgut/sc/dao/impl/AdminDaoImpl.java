package com.dgut.sc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dgut.sc.dao.AdminDao;
import com.dgut.sc.domain.Admin;
import com.sc.util.DBCPUtil;

public class AdminDaoImpl implements AdminDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public boolean updateAdmin(String admin,String password) {
		try {
			int num = qr.update("update admin set password=? where admin=?",
					password, admin);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Admin queryAdmin(String admin) {
		try {
			return qr.query("select * from admin where admin=?",
					new BeanHandler<Admin>(Admin.class), admin);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Admin queryAdmin(String admin, String password) {
		try {
			return qr.query("select * from admin where admin=? and password=?",
					new BeanHandler<Admin>(Admin.class), admin, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
