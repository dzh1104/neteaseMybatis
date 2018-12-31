package com.netease.entity;

public class Person {

//	此时 类属性名 和 表中的字段名 不能合理识别 uid - id
private int uid;

private String name;

private int age;

public Person() {

}

public Person(int uid, String name, int age) {
	
	this.uid = uid;
	this.name = name;
	this.age = age;
}

public int getUid() {
	
	return uid;
}

public void setUid(int uid) {
	
	this.uid = uid;
}

public String getName() {
	
	return name;
}

public void setName(String name) {
	
	this.name = name;
}

public int getAge() {
	
	return age;
}

public void setAge(int age) {
	
	this.age = age;
}

@Override
public String toString() {
	
	return "Person{" + "uid=" + uid + ", name='" + name + '\'' + ", age=" + age + '}';
}

}
