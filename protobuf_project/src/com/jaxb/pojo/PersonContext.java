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
@XmlType(name = "Context", propOrder = { "persons"})  
@XmlRootElement(name = "context")  
public class PersonContext {  
  
    @XmlElementWrapper(name = "persons")  
    @XmlElement(name = "person")  
    private List<PersonJaxb> persons;

	public List<PersonJaxb> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonJaxb> persons) {
		this.persons = persons;
	}

	public PersonContext(List<PersonJaxb> persons) {
		super();
		this.persons = persons;
	}

	public PersonContext() {
		super();
	}  
  
}  