package java63.servlets.test04.domain;

import java.io.Serializable;

public class Student implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	protected int no;
	protected String phNo;
	protected String name;
	protected String email;
	protected String sex;
	protected String subj;
	protected int age;

	public Student() {}

	public Student(String phNo, String name, String email, String sex,
			String subj, int age) {
		this.phNo = phNo;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.subj = subj;
		this.age = age;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSubj() {
		return subj;
	}

	public void setSubj(String subj) {
		this.subj = subj;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
