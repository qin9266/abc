package com.dgut.sc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dgut.sc.dao.TeacherDao;
import com.dgut.sc.domain.Teacher;
import com.sc.util.DBCPUtil;

public class TeacherDaoImpl implements TeacherDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public boolean addTeacher(Teacher teacher) {
		try {
			qr.update(
					"insert into teacher (tno,tname,password,sex,department,degree,title) values(?,?,?,?,?,?,?)",
					teacher.getTno(), teacher.getTname(),
					teacher.getPassword(), teacher.getSex(),
					teacher.getDepartment(), teacher.getDegree(),
					teacher.getTitle());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTeacher(String tno) {
		try {
			int num = qr.update("delete from teacher where tno=?", tno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		try {
			int num = qr
					.update("update teacher set tname=?,password=?,sex=?,department=?,degree=?,title=? where tno=?",
							teacher.getTname(), teacher.getPassword(),
							teacher.getSex(), teacher.getDepartment(),
							teacher.getDegree(), teacher.getTitle(),teacher.getTno());
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Teacher> queryAllTeacher(int startIndex, int pagesize) {
		try {
			return qr.query("select * from teacher order by tno asc limit ?,?",
					new BeanListHandler<Teacher>(Teacher.class), startIndex,
					pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Teacher queryTeacher(String tno) {
		try {
			return qr.query("select * from teacher where tno=? ",
					new BeanHandler<Teacher>(Teacher.class), tno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getAllTeacherCounts() {
		try {
			Long num = (Long) qr.query("select count(*) from teacher ",
					new ScalarHandler(1));
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Teacher queryTeacher(String tno, String password) {
		try {
			return qr.query("select * from teacher where tno=? and password=?",
					new BeanHandler<Teacher>(Teacher.class), tno, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateTeacherPwd(String tno, String password) {
		try {
			int num = qr.update("update teacher set password=? where tno=?",
					password, tno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
