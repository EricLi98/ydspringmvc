package com.ydspringmvc.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class UserBean {
	private String id;
	private boolean grant;
	private List<String> hobbies;
	private List<String> deptIds;
	private String hobby;
	private String country;
	private Department oneDept;
	public Department getOneDept() {
		return oneDept;
	}
	public void setOneDept(Department oneDept) {
		this.oneDept = oneDept;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public List<String> getDeptIds() {
		return deptIds;
	}
	public void setDeptIds(List<String> deptIds) {
		this.deptIds = deptIds;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public boolean isGrant() {
		return grant;
	}
	public void setGrant(boolean grant) {
		this.grant = grant;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Size(min=6,max=20,message="{userbean.username}")
	private String userName;
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message="{userbean.password}")//密码由大写字母，小写字母和数字组成，最少8位
	private String password;
	@NotNull(message="{userbean.address}")
	@Length(message="{userbean.address}",min=1)
	private String address;
	private Department dept;
	private Tel tel;
	private FormatterModel fm;
	public FormatterModel getFm() {
		return fm;
	}
	public void setFm(FormatterModel fm) {
		this.fm = fm;
	}
	public Tel getTel() {
		return tel;
	}
	public void setTel(Tel tel) {
		this.tel = tel;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
