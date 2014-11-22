package java63.servlets.test04.domain;

import java.io.Serializable;

public class Student implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;


	protected String phNo;
	protected String name;
	protected String email;
	protected String sex;
	protected String subj;
	protected int age;

	public Student() {}



	public Student(String phNo, String name, String email, String sex,
			String subj, int age) {
		super();
		this.phNo = phNo;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.subj = subj;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Student [phNo=" + phNo + ", name=" + name + ", email=" + email
				+ ", sex=" + sex + ", subj=" + subj + ", age=" + age + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phNo == null) ? 0 : phNo.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((subj == null) ? 0 : subj.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phNo == null) {
			if (other.phNo != null)
				return false;
		} else if (!phNo.equals(other.phNo))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (subj == null) {
			if (other.subj != null)
				return false;
		} else if (!subj.equals(other.subj))
			return false;
		return true;
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
