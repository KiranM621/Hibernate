package com.hibernate.practice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

// defines to use class as table
@Entity
//name : specifiys table name
public class Student {

	@Id //define primary key
	private int dep_id;
	
	private Name name;
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	@Column(name = "department_name")
	private String dep_name;
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Laptop> laptop = new ArrayList();

	
public List<Laptop> getLaptop() {
		return laptop;
	}
public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	//	@Transient //commented becoz while fetching field is showing null
	private String location;
	
	
	
	
	
	
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	@Override
	public String toString() {
		return "Student [dep_id=" + dep_id + ", name=" + name + ", dep_name=" + dep_name + ", laptop=" + laptop
				+ ", location=" + location + "]";
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}

