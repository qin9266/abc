package com.dgut.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dgut.sc.dao.AdminDao;
import com.dgut.sc.dao.CourseDao;
import com.dgut.sc.dao.ScoreDao;
import com.dgut.sc.dao.StudentDao;
import com.dgut.sc.dao.TeacherDao;
import com.dgut.sc.dao.impl.AdminDaoImpl;
import com.dgut.sc.dao.impl.CourseDaoImpl;
import com.dgut.sc.dao.impl.ScoreDaoImpl;
import com.dgut.sc.dao.impl.StudentDaoImpl;
import com.dgut.sc.dao.impl.TeacherDaoImpl;
import com.dgut.sc.domain.Admin;
import com.dgut.sc.domain.Course;
import com.dgut.sc.domain.Score;
import com.dgut.sc.domain.Student;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.service.BusinessService;
import com.sc.util.Page;

public class BusinessServiceImpl implements BusinessService {
	private StudentDao sDao = new StudentDaoImpl();
	private ScoreDao scDao = new ScoreDaoImpl();
	private AdminDao aDao = new AdminDaoImpl();
	private TeacherDao tDao = new TeacherDaoImpl();
	private CourseDao cDao = new CourseDaoImpl();

	@Override
	public boolean addStudent(Student student) {
		return sDao.addStudent(student);
	}

	@Override
	public boolean deleteStudent(String sno) {
		return sDao.deleteStudent(sno);
	}

	@Override
	public boolean updateStudentPwd(String sno, String password) {
		return sDao.updateStudentPwd(sno, password);
	}

	@Override
	public Student queryStudent(String sno, String password) {
		return sDao.queryStudent(sno, password);
	}

	@Override
	public Student queryStudent(String sno) {
		return sDao.queryStudent(sno);
	}

	public Page findStudentsRecords(String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = sDao.getAllStudentCounts();
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Student> recordList = sDao.queryAllStudent(
					page.getStartIndex(), page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Student>());
		}
		return page;
	}

	public Page findScoresRecords(String sno, String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = scDao.getAllScoreCountsBySno(sno);
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Score> recordList = scDao.queryAllScoreBySno(sno,
					page.getStartIndex(), page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Score>());
		}
		return page;
	}

	public Page findTeachersRecords(String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = tDao.getAllTeacherCounts();
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Teacher> recordList = tDao.queryAllTeacher(
					page.getStartIndex(), page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Teacher>());
		}
		return page;
	}

	public Page findCoursesRecords(String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = cDao.getAllCourseCounts();
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Course> recordList = cDao.queryAllCourse(page.getStartIndex(),
					page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Course>());
		}
		return page;
	}

	public Page findScoresRecords(String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = scDao.getAllScoreCounts();
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Score> recordList = scDao.queryAllScore(page.getStartIndex(),
					page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Score>());
		}
		return page;
	}

	public Page findScoresRecordsByTno(String tno, String pageNum) {
		int num = 1;// 默认页码
		if (pageNum != null && !"".equals(pageNum.trim())) {
			num = Integer.parseInt(pageNum);
		}
		int totalRecords = scDao.getAllScoreCountsByTno(tno);
		Page page = new Page(num, totalRecords);
		if (totalRecords != 0) {
			List<Score> recordList = scDao.queryAllScoreByTno(tno,
					page.getStartIndex(), page.getPageSize());
			page.setRecordList(recordList);
		} else {
			page.setRecordList(new ArrayList<Score>());
		}
		return page;
	}

	@Override
	public boolean addScore(Score score) {
		// TODO Auto-generated method stub
		return scDao.addScore(score);
	}

	@Override
	public boolean deleteScore(String sno,String cno) {
		// TODO Auto-generated method stub
		return scDao.deleteScore(sno,cno);
	}

	@Override
	public boolean updateScore(Score score) {
		// TODO Auto-generated method stub
		return scDao.updateScore(score);
	}

	@Override
	public List<Score> queryAllScore(int startIndex, int pagesize) {
		// TODO Auto-generated method stub
		return scDao.queryAllScore(startIndex, pagesize);
	}

	@Override
	public List<Score> queryAllScoreBySno(String sno, int startIndex,
			int pagesize) {
		// TODO Auto-generated method stub
		return scDao.queryAllScoreBySno(sno, startIndex, pagesize);
	}

	@Override
	public Score queryScore(String sno, String cno) {
		// TODO Auto-generated method stub
		return scDao.queryScore(sno, cno);
	}

	@Override
	public boolean updateAdmin(String admin, String password) {
		return aDao.updateAdmin(admin, password);
	}

	@Override
	public Admin queryAdmin(String admin) {
		return aDao.queryAdmin(admin);
	}

	@Override
	public Admin queryAdmin(String admin, String password) {
		return aDao.queryAdmin(admin, password);
	}

	@Override
	public boolean updateStudent(String sno, String password, String sname,
			String sex, String major, String department, String sclass) {
		return sDao.updateStudent(sno, password, sname, sex, major, department,
				sclass);
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		return tDao.addTeacher(teacher);
	}

	@Override
	public boolean deleteTeacher(String tno) {
		return tDao.deleteTeacher(tno);
	}

	@Override
	public Teacher queryTeacher(String tno) {
		return tDao.queryTeacher(tno);
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		return tDao.updateTeacher(teacher);
	}

	@Override
	public boolean addCourse(Course course) {
		return cDao.addCourse(course);
	}

	@Override
	public boolean deleteCourse(String cno) {
		return cDao.deleteCourse(cno);
	}

	@Override
	public boolean updateCourse(Course course) {
		return cDao.updateCourse(course);
	}

	@Override
	public Course queryCourse(String cno) {
		return cDao.queryCourse(cno);
	}

	@Override
	public Teacher queryTeacher(String tno, String password) {
		return tDao.queryTeacher(tno, password);
	}

	@Override
	public boolean updateScore(String sno, String cno, String grade,
			String get_credit, String gPA, String credit_GPA) {
		return scDao.updateScore(sno, cno, grade, get_credit, gPA, credit_GPA);
	}

	@Override
	public boolean updateTeacherPwd(String tno, String password) {
		return tDao.updateTeacherPwd(tno, password);
	}
}
