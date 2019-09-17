package com.JFS.Criminal.Record.Management.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity							//Entities in JPA are nothing but POJOs representing data that can be persisted to the database.
@Table(name="CBIOfficers")		//create table with given name in database
public class CBIOfficers {

	private String code;
	private String name;
	private String email;
	private String phone;
	private String unit;
	private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    
    @Id							////ID : define primary key class in database table
	public String getCode() {	
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public LocalDateTime getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public LocalDateTime getDateOfModification() {
		return dateOfModification;
	}
	public void setDateOfModification(LocalDateTime dateOfModification) {
		this.dateOfModification = dateOfModification;
	}
    
    
    
}
