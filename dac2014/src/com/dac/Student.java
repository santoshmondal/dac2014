package com.dac;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("ref8")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sname;
	private int id;
	private String email;
	private String message;
	
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
	
	
	private Address address;
	
	// private List<Address> addressList;
	
	
	public Student(){
		super();
	}
	
	public Student(String sname, int id) {
		this.sname = sname;
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public void willInit(){
		System.out.println("Initialisation....begins");
	}
	
	public void willDestory(){
		System.out.println("Destruction....!!");
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
