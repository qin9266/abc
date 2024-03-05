package com.dgut.sc.domain;

public class Course {
	private String cno;
	private String cname;
	private String tno;
	private String tname;
	private String credit;

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}


	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Course(String cno, String cname, String tno, String tname,
			String credit) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.tno = tno;
		this.tname = tname;
		this.credit = credit;
	}

	public Course() {

	}

	@Override
	public String toString() {
		return "course [cno=" + cno + ", cname=" + cname + ", tno=" + tno
				+ ", credit=" + credit + "]";
	}

}
