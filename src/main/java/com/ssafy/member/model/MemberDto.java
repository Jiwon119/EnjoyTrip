package com.ssafy.member.model;

public class MemberDto {

	private String id;
	private String password;
	private int age;
	private String email;
	private String address;
	
	public MemberDto() {}
	
	public MemberDto(String id, String password, int age, String email, String address) {
		super();
		this.id = id;
		this.password = password;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", age=" + age + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
	
}
