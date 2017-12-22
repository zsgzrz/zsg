package com.chinasofti.easyUI.user.entity;

public class User {

	private Integer u_id;
	private String u_name;
	private String u_loginName;
	private String u_password;
	private Integer u_age;
	private String u_sex;
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_loginName() {
		return u_loginName;
	}
	public void setU_loginName(String u_loginName) {
		this.u_loginName = u_loginName;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Integer getU_age() {
		return u_age;
	}
	public void setU_age(Integer u_age) {
		this.u_age = u_age;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String u_name, String u_loginName, String u_password,
			Integer u_age, String u_sex) {
		super();
		this.u_name = u_name;
		this.u_loginName = u_loginName;
		this.u_password = u_password;
		this.u_age = u_age;
		this.u_sex = u_sex;
	}
	public User(Integer u_id, String u_name, String u_loginName,
			String u_password, Integer u_age, String u_sex) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_loginName = u_loginName;
		this.u_password = u_password;
		this.u_age = u_age;
		this.u_sex = u_sex;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_loginName="
				+ u_loginName + ", u_password=" + u_password + ", u_age="
				+ u_age + ", u_sex=" + u_sex + "]";
	}
	
	
}
