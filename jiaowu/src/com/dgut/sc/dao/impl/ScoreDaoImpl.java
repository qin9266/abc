package com.dgut.sc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dgut.sc.dao.ScoreDao;
import com.dgut.sc.domain.Score;
import com.dgut.sc.domain.Student;
import com.sc.util.DBCPUtil;

public class ScoreDaoImpl implements ScoreDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public boolean addScore(Score score) {
		try {
			qr.update(
					"insert into score (sno,sname,cno,cname,credit,type,exam_method,property,grade,get_credit,GPA,credit_GPA,note,tno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					score.getSno(), score.getSname(), score.getCno(),
					score.getCname(), score.getCredit(), score.getType(),
					score.getExam_method(), score.getProperty(),
					score.getGrade(), score.getGet_credit(), score.getGPA(),
					score.getCredit_GPA(), score.getNote(), score.getTno());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteScore(String sno, String cno) {
		try {
			int num = qr.update("delete from score where cno=? and sno=?", cno,
					sno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateScore(Score score) {
		try {
			int num = qr
					.update("update score set grade=?,get_credit=?,GPA=?,credit_GPA=? where cno=? and sno=?",
							score.getGrade(), score.getGet_credit(),
							score.getGPA(), score.getCredit_GPA(),
							score.getCno(), score.getSno());
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Score> queryAllScore(int startIndex, int pagesize) {
		try {
			return qr.query("select * from score order by sno desc limit ?,?",
					new BeanListHandler<Score>(Score.class), startIndex,
					pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Score queryScore(String sno, String cno) {
		try {
			return qr.query("select * from score where sno=? and cno=?",
					new BeanHandler<Score>(Score.class), sno, cno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getAllScoreCounts() {
		try {
			Long num = (Long) qr.query("select count(*) from score ",
					new ScalarHandler(1));
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getAllScoreCountsBySno(String sno) {
		try {
			Long num = (Long) qr.query(
					"select count(*) from score where sno=?",
					new ScalarHandler(1),sno);
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Score> queryAllScoreBySno(String sno, int startIndex,
			int pagesize) {
		try {
			return qr
					.query("select * from score where sno = ? order by cno asc limit ?,?",
							new BeanListHandler<Score>(Score.class), sno,
							startIndex, pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getAllScoreCountsByTno(String tno) {
		try {
			Long num = (Long) qr.query(
					"select count(*) from score where tno=?",
					new ScalarHandler(1), tno);
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Score> queryAllScoreByTno(String tno, int startIndex,
			int pageSize) {
		try {
			return qr
					.query("select * from score where tno = ? order by cno asc limit ?,?",
							new BeanListHandler<Score>(Score.class), tno,
							startIndex, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateScore(String sno, String cno, String grade,
			String get_credit, String gPA, String credit_GPA) {
		try {
			int num = qr
					.update("update score set grade=?,get_credit=?,GPA=?,credit_GPA=? where sno=? and cno=?",
							grade, get_credit, gPA, credit_GPA, sno, cno);
			return num == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
