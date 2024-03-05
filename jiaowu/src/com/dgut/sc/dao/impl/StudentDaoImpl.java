package com.dgut.sc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dgut.sc.dao.StudentDao;
import com.dgut.sc.domain.Student;
import com.sc.util.DBCPUtil;

public class StudentDaoImpl implements StudentDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public boolean addStudent(Student student) {
		try {
			qr.update(
					"insert into student (sno,sname,password,sex,major,department,sclass) values(?,?,?,?,?,?,?)",
					student.getSno(), student.getSname(),
					student.getPassword(), student.getSex(),
					student.getMajor(), student.getDepartment(),
					student.getSclass());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(String sno) {
		try {
			int num = qr.update("delete from student where sno=?", sno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStudentPwd(String sno, String password) {
		try {
			int num = qr.update("update student set password=? where sno=?",
					password, sno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> queryAllStudent(int startIndex, int pagesize) {
		try {
			return qr.query(
					"select * from student order by sno asc limit ?,?",
					new BeanListHandler<Student>(Student.class), startIndex,
					pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student queryStudent(String sno, String password) {
		try {
			return qr.query("select * from student where sno=? and password=?",
					new BeanHandler<Student>(Student.class), sno, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getAllStudentCounts() {
		try {
			Long num = (Long)qr.query("select count(*) from student ",new ScalarHandler(1));
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Student queryStudent(String sno) {
		try {
			return qr.query("select * from student where sno=? ",
					new BeanHandler<Student>(Student.class), sno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateStudent(String sno, String password, String sname,
			String sex, String major, String department, String sclass) {
		try {
			int num = qr.update("update student set sname=?,password=?,sex=?,major=?,department=?,sclass=? where sno=?",
					sname,password, sex,major,department,sclass,sno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}
