package com.nyeong.spring.ex.lifecycle;

public class Person {
	
	// 이름, 나이
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 멤버변수 접근 가능할 수 있게
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
	

	
}
