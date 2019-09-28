package com.JFS.Criminal.Record.Management.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "MeetingDetails")
public class MeetingWithOutsider {

	private int meetingId;
	private String personName;
	private int phone;
	private String relation;
	private Date meetingDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	
	
	
}
