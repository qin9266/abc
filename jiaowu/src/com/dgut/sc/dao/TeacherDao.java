package com.dgut.sc.dao;

import java.util.List;

import com.dgut.sc.domain.Teacher;

public interface TeacherDao {
	/**
	 * 增加一条教师信息
	 * 
	 * @param student
	 * @return
	 */
	boolean addTeacher(Teacher teacher);

	/**
	 * 删除一条教师信息
	 * 
	 * @param sno
	 * @return
	 */
	boolean deleteTeacher(String tno);

	/**
	 * 更新一条教师信息
	 * 
	 * @param student
	 * @return
	 */
	boolean updateTeacher(Teacher teacher);

	/**
	 * 查询所有教师信息
	 * 
	 * @return
	 */
	List<Teacher> queryAllTeacher(int startIndex, int pagesize);

	/**
	 * 查询一条教师信息
	 * 
	 * @param sno
	 * @return
	 */
	Teacher queryTeacher(String tno);

	/**
	 * 查询一条教师信息
	 * 
	 * @param sno
	 * @return
	 */
	Teacher queryTeacher(String tno, String password);

	/**
	 * 更新一条教师密码
	 * 
	 * @param tno
	 * @param password
	 * @return
	 */
	boolean updateTeacherPwd(String tno, String password);

	int getAllTeacherCounts();
}
