package com.dgut.sc.dao;

import java.util.List;

import com.dgut.sc.domain.Score;

public interface ScoreDao {
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
	 * 得到成绩记录总数
	 * 
	 * @return
	 */
	int getAllScoreCounts();

	List<Score> queryAllScoreByTno(String tno, int startIndex, int pageSize);

	int getAllScoreCountsByTno(String tno);

	int getAllScoreCountsBySno(String sno);

}
