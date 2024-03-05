package com.dgut.sc.domain;

public class Student {
	private String sno;
	private String sname;
	private String password;
	private String sex;
	private String major;
	private String department;
	private String sclass;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public Student(String sno, String sname, String password, String sex,
			String major, String department, String sclass) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.password = password;
		this.sex = sex;
		this.major = major;
		this.department = department;
		this.sclass = sclass;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", password="
				+ password + ", sex=" + sex + ", major=" + major
				+ ", department=" + department + ", sclass=" + sclass + "]";
	}

}
