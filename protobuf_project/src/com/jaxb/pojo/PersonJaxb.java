package com.jaxb.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;  
  
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(name = "Person", propOrder = { "id","name","email", "phones" })  
@XmlRootElement(name = "person")  
public class PersonJaxb {  
    @XmlElement(name = "id")  
    private int id;
    @XmlElement(name = "name")  
    private String name;
    @XmlElement(name = "email")  
    private String email;
  
    @XmlElementWrapper(name = "PhoneSet")  
    @XmlElement(name = "phone")  
    private List<PhoneJaxb> phones;  
  
    public PersonJaxb() {  
        super();  
    }

	public PersonJaxb(int id, String name, String email, List<PhoneJaxb> phones) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phones = phones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhoneJaxb> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneJaxb> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "PersonJaxb [id=" + id + ", name=" + name + ", email=" + email + ", phones=" + phones + "]";
	}  
 
  
    
}  