package com.dgut.sc.dao;


import java.util.List;

import com.dgut.sc.domain.Student;

public interface StudentDao {
	/**
	 * 增加一条学生信息
	 * @param student
	 * @return
	 */
	boolean addStudent(Student student);
	/**
	 * 删除一条学生信息
	 * @param sno
	 * @return
	 */
	boolean deleteStudent(String sno);
	/**
	 * 更新一条学生密码
	 * @param sno
	 * @param password
	 * @return
	 */
	boolean updateStudentPwd(String sno,String password);
	/**
	 * 更新一条学生信息
	 * @param sno
	 * @param password
	 * @param sname
	 * @param sex
	 * @param major
	 * @param department
	 * @param sclass
	 * @return
	 */
	boolean updateStudent(String sno,String password,String sname,String sex,String major,String department,String sclass);
	/**
	 * 查询所有学生信息
	 * @return
	 */
	List<Student> queryAllStudent(int startIndex, int pagesize);
	/**
	 * 查询一条学生信息
	 * @param sno
	 * @return
	 */
	Student queryStudent(String sno,String password);
	/**
	 * 查询一条学生信息
	 * @param sno
	 * @return
	 */
	public Student queryStudent(String sno);
	/**
	 * 获取学生总数
	 * @return
	 */
	public int getAllStudentCounts() ;
	
	
}
