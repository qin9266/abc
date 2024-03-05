package com.dgut.sc.domain;

public class Score {
	private String sno;
	private String sname;
	private String cno;
	private String cname;
	private String credit;
	private String type;
	private String exam_method;
	private String property;
	private String grade;
	private String get_credit;
	private String GPA;
	private String credit_GPA;
	private String note;
	private String tno;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExam_method() {
		return exam_method;
	}

	public void setExam_method(String exam_method) {
		this.exam_method = exam_method;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getGet_credit() {
		return get_credit;
	}

	public void setGet_credit(String get_credit) {
		this.get_credit = get_credit;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	public String getCredit_GPA() {
		return credit_GPA;
	}

	public void setCredit_GPA(String credit_GPA) {
		this.credit_GPA = credit_GPA;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Score(String sno, String sname, String cno, String cname,
			String credit, String type, String exam_method, String property,
			String grade, String get_credit, String gPA, String credit_GPA,
			String note, String tno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.type = type;
		this.exam_method = exam_method;
		this.property = property;
		this.grade = grade;
		this.get_credit = get_credit;
		GPA = gPA;
		this.credit_GPA = credit_GPA;
		this.note = note;
		this.tno = tno;
	}

	public Score() {

	}

	@Override
	public String toString() {
		return "score [sno=" + sno + ", cno=" + cno + ", grade=" + grade + "]";
	}

}
