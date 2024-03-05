package com.dgut.sc.domain;

public class Teacher {
	private String tno;
	private String tname;
	private String password;
	private String sex;
	private String department;
	private String degree;
	private String title;

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher(String tno, String tname, String password, String sex,
			String department, String degree, String title) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.password = password;
		this.sex = sex;
		this.department = department;
		this.degree = degree;
		this.title = title;
	}

	public Teacher() {

	}

	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", password="
				+ password + ", department=" + department + "]";
	}

}
