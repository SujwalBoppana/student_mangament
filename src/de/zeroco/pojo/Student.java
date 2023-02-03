package de.zeroco.pojo;

import java.util.List;

public class Student {
	public String name;
	public String email;
	public String phno;
	public String fatherName;
	public String dob;
	public List<String> hobbies;
	public Student(String name, String email, String phno, String fatherName, String dob, List<String> hobbies) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.fatherName = fatherName;
		this.dob = dob;
		this.hobbies = hobbies;
	}

	public Student() {
		super();
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

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", phno=" + phno + ", fatherName=" + fatherName + ", dob="
				+ dob + ", hobbies=" + hobbies + "]";
	}
	
}
