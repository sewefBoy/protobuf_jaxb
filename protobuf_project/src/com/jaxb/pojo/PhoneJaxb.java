package com.jaxb.pojo;

import javax.xml.bind.annotation.XmlAccessOrder;  
import javax.xml.bind.annotation.XmlAccessType;  
import javax.xml.bind.annotation.XmlAccessorOrder;  
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;  
  
@XmlType(propOrder = { "phoneNum", "phoneType"})  
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)  
@XmlAccessorType(XmlAccessType.NONE)  
@XmlRootElement(name = "phone")  
public class PhoneJaxb {  
    @XmlElement(name = "phoneNum") 
    private String phoneNum;
    @XmlElement(name = "phoneType") 
	private int phoneType;
    public PhoneJaxb() {  
        super();  
    }
	public PhoneJaxb(String phoneNum, int phoneType) {
		super();
		this.phoneNum = phoneNum;
		this.phoneType = phoneType;
	}
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
	@Override
	public String toString() {
		return "Phone [phoneNum=" + phoneNum + ", phoneType=" + phoneType + "]";
	}  
}  
