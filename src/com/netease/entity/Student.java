package com.netease.entity;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	private String graName;
	private Boolean stuSex;

public Student() {

}

public Student(int stuNo, String stuName, int stuAge, String graName, Boolean stuSex) {
	
	this.stuNo = stuNo;
	this.stuName = stuName;
	this.stuAge = stuAge;
	this.graName = graName;
	this.stuSex = stuSex;
}

public int getStuNo() {

	return stuNo;
}

public void setStuNo(int stuNo) {

	this.stuNo = stuNo;
}

public String getStuName() {

	return stuName;
}

public void setStuName(String stuName) {

	this.stuName = stuName;
}

public int getStuAge() {

	return stuAge;
}

public void setStuAge(int stuAge) {

	this.stuAge = stuAge;
}

public String getGraName() {

	return graName;
}

public void setGraName(String graName) {

	this.graName = graName;
}

public Boolean getStuSex() {
	
	return stuSex;
}

public void setStuSex(Boolean stuSex) {
	
	this.stuSex = stuSex;
}

public Student(int stuNo, String stuName, int stuAge, String graName) {
	
	this.stuNo = stuNo;
	this.stuName = stuName;
	this.stuAge = stuAge;
	this.graName = graName;
}

@Override
public String toString() {
	
	return "Student{" + "stuNo=" + stuNo + ", stuName='" + stuName + '\'' + ", stuAge=" + stuAge + ", graName='" + graName + '\'' + ", stuSex=" + stuSex + '}';
}

}
