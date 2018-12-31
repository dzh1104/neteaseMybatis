package com.netease.entity;

public class Person1 {

private int id;

private String name;

private int age;

public Person1() {

}

public Person1(int id, String name, int age) {
	
	this.id = id;
	this.name = name;
	this.age = age;
}

@Override
public String toString() {
	
	return "Person1{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
}

}
