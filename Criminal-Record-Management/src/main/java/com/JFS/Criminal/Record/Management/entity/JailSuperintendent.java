package com.JFS.Criminal.Record.Management.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "JailSuperintendent")
public class JailSuperintendent extends User{
	private String code;
	private String name;
	private String email;
	private String phone;
	private String jailName;
	private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    
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
	public String getJailName() {
		return jailName;
	}
	public void setJailName(String jailName) {
		this.jailName = jailName;
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
