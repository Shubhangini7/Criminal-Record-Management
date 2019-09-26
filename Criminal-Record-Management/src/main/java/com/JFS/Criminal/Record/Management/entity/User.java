package com.JFS.Criminal.Record.Management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	private long userid;
	private String password;
	private Credential credential;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}