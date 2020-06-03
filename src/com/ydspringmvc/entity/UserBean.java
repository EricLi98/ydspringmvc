package com.ydspringmvc.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Size(min=6,max=20,message="用户名长度有6至20之间")
	private String userName;
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message="密码由大写字母，小写字母和数字组成，最少8位")//密码由大写字母，小写字母和数字组成，最少8位
	private String password;
	@NotNull(message="地址不可为空")
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
