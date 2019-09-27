package com.JFS.Criminal.Record.Management.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Criminal")
public class Criminal {
	
	private Long criminalNo;
	private String CriminalName;
	private String bloodGroup;
	private String jailName;
	private String cellNo;
	private String assignWork;
	private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    
    private MeetingWithOutsider meetingWithOutsider;
    private HealthCondition healthCondition;
	
    @Id
	public Long getCriminalNo() {
		return criminalNo;
	}
	public void setCriminalNo(Long criminalNo) {
		this.criminalNo = criminalNo;
	}
	public String getCriminalName() {
		return CriminalName;
	}
	public void setCriminalName(String criminalName) {
		CriminalName = criminalName;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getJailName() {
		return jailName;
	}
	public void setJailName(String jailName) {
		this.jailName = jailName;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getAssignWork() {
		return assignWork;
	}
	public void setAssignWork(String assignWork) {
		this.assignWork = assignWork;
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
	
	@OneToOne(optional = true)
	@JoinColumn(name = "meetingId")
	public MeetingWithOutsider getMeetingWithOutsider() {
		return meetingWithOutsider;
	}
	public void setMeetingWithOutsider(MeetingWithOutsider meetingWithOutsider) {
		this.meetingWithOutsider = meetingWithOutsider;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "healthId")
	public HealthCondition getHealthCondition() {
		return healthCondition;
	}
	public void setHealthCondition(HealthCondition healthCondition) {
		this.healthCondition = healthCondition;
	}
	
	
        
    
}
