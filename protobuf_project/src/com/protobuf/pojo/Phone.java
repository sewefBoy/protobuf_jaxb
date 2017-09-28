package com.protobuf.pojo;

import java.io.Serializable;

public class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3147223688664873079L;
	private String phoneNum;
	private int phoneType;
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}
	
}
