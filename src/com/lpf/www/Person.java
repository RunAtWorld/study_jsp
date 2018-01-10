package com.lpf.www;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 2567283942398849L;
	public String name;
	private int age;
	public String dog;
	
	public Person(String name, int age, String dog) {
		super();
		this.name = name;
		this.age = age;
		this.dog = dog;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getDog() {
		return dog;
	}
	public void setDog(String dog) {
		this.dog = dog;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
	}
	
	public void  show(){
		System.out.println("姓名："+this.name+"     年龄:"+this.age);
	}
	
	public void  display(String nation){
		System.out.println("姓名："+this.name+"     年龄:"+this.age + "   国籍："+nation);
	}
}
