package com.dgut.sc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dgut.sc.dao.CourseDao;
import com.dgut.sc.domain.Course;
import com.dgut.sc.domain.Teacher;
import com.sc.util.DBCPUtil;

public class CourseDaoImpl implements CourseDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public boolean addCourse(Course course) {
		try {
			qr.update(
					"insert into course (cno,cname,tno,tname,credit) values(?,?,?,?,?)",
					course.getCno(), course.getCname(), course.getTno(),
					course.getTname(), course.getCredit());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCourse(String cno) {
		try {
			int num = qr.update("delete from course where cno=?", cno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCourse(Course course) {
		try {
			int num = qr
					.update("update course set cname=?,tno=?,tname=?,credit=? where cno=?",
							course.getCname(), course.getTno(),
							course.getTname(), course.getCredit(),course.getCno());
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Course queryCourse(String cno) {
		try {
			return qr.query("select * from course where cno=? ",
					new BeanHandler<Course>(Course.class), cno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Course> queryAllCourse(int startIndex, int pagesize) {
		try {
			return qr.query("select * from course order by cno asc limit ?,?",
					new BeanListHandler<Course>(Course.class), startIndex,
					pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getAllCourseCounts() {
		try {
			Long num = (Long) qr.query("select count(*) from course ",
					new ScalarHandler(1));
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
