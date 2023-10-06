package com.ssafy.member.model;

public class MemberDto {

	private String userId;
	private String userName;
	private String userPass;
	private String userEmail;
	
	public MemberDto() {}
	
	public MemberDto(String userId, String userName, String userPass, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + "]";
	}

}
