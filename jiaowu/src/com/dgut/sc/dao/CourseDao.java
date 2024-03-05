package com.dgut.sc.dao;

import java.util.List;

import com.dgut.sc.domain.Course;

public interface CourseDao {
	/**
	 * 增加一条课程信息
	 * @param student
	 * @return
	 */
	boolean addCourse(Course course);
	/**
	 * 删除一条课程信息
	 * @param sno
	 * @return
	 */
	boolean deleteCourse(String cno);
	/**
	 * 更新一条课程信息
	 * @param student
	 * @return
	 */
	boolean updateCourse(Course course);
	/**
	 * 查询所有课程信息
	 * @return
	 */
	List<Course> queryAllCourse(int startIndex, int pagesize);
	/**
	 * 查询一条课程信息
	 * @param sno
	 * @return
	 */
	Course queryCourse(String cno);

	int getAllCourseCounts();
}
