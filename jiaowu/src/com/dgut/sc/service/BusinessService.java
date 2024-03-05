package com.dgut.sc.service;

import java.util.List;

import com.dgut.sc.domain.Admin;
import com.dgut.sc.domain.Course;
import com.dgut.sc.domain.Score;
import com.dgut.sc.domain.Student;
import com.dgut.sc.domain.Teacher;
import com.sc.util.Page;

public interface BusinessService {

	/**
	 *
	 * @param admin
	 * @param password
	 * @return
	 */
	boolean updateAdmin(String admin, String password);

	/**
	 *
	 * @param admin
	 * @return
	 */
	Admin queryAdmin(String admin);

	/**
	 *
	 * @param tno
	 * @param password
	 * @return
	 */
	Teacher queryTeacher(String tno, String password);

	/**
	 *
	 * @param tno
	 * @param password
	 * @return
	 */
	boolean updateTeacherPwd(String tno, String password);
	/**
	 * 查询一条管理员信息
	 * 
	 * @param sno
	 * @return
	 */
	Admin queryAdmin(String admin, String password);

	/**
	 * 增加一条学生信息
	 * 
	 * @param student
	 * @return
	 */
	boolean addStudent(Student student);

	/**
	 * 删除一条学生信息
	 * 
	 * @param sno
	 * @return
	 */
	boolean deleteStudent(String sno);

	/**
	 * 更新一条学生密码
	 * 
	 * @param student
	 * @return
	 */
	boolean updateStudentPwd(String sno, String password);

	/**
	 * 更新一条学生信息
	 * 
	 * @param sno
	 * @param password
	 * @param sname
	 * @param sex
	 * @param major
	 * @param department
	 * @param sclass
	 * @return
	 */
	boolean updateStudent(String sno, String password, String sname,
			String sex, String major, String department, String sclass);

	/**
	 * 查询一条学生信息
	 * 
	 * @param sno
	 * @return
	 */
	Student queryStudent(String sno, String password);

	Student queryStudent(String sno);

	/**
	 * 增加一条成绩信息
	 * 
	 * @param student
	 * @return
	 */
	boolean addScore(Score score);

	/**
	 * 删除一条成绩信息
	 * 
	 * @param sno
	 * @return
	 */
	boolean deleteScore(String sno, String cno);

	/**
	 * 更新一条成绩信息
	 * 
	 * @param student
	 * @return
	 */
	boolean updateScore(Score score);

	/**
	 * 更新一条成绩信息
	 * 
	 * @param student
	 * @return
	 */
	boolean updateScore(String sno, String cno, String grade,
			String get_credit, String gPA, String credit_GPA);

	/**
	 * 查询所有成绩信息
	 * 
	 * @return
	 */
	List<Score> queryAllScore(int startIndex, int pagesize);

	/**
	 * 查询某个人所有成绩信息
	 * 
	 * @return
	 */
	List<Score> queryAllScoreBySno(String sno, int startIndex, int pagesize);

	/**
	 * 查询一条成绩信息
	 * 
	 * @param sno
	 * @return
	 */

	Score queryScore(String sno, String cno);

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
	 * 查询一条教师信息
	 * 
	 * @param sno
	 * @return
	 */
	Teacher queryTeacher(String tno);

	/**
	 * 更新一条教师信息
	 * 
	 * @param student
	 * @return
	 */

	boolean updateTeacher(Teacher teacher);

	/**
	 * 增加一条课程信息
	 * 
	 * @param student
	 * @return
	 */
	boolean addCourse(Course course);

	/**
	 * 删除一条课程信息
	 * 
	 * @param sno
	 * @return
	 */
	boolean deleteCourse(String cno);

	/**
	 * 更新一条课程信息
	 * 
	 * @param student
	 * @return
	 */
	boolean updateCourse(Course course);

	/**
	 * 查询一条课程信息
	 * 
	 * @param sno
	 * @return
	 */
	Course queryCourse(String cno);

	Page findStudentsRecords(String pageNum);

	Page findScoresRecords(String sno, String pageNum);

	Page findTeachersRecords(String pageNum);

	Page findCoursesRecords(String pageNum);

	Page findScoresRecords(String pageNum);

	Page findScoresRecordsByTno(String tno, String pageNum);

}
