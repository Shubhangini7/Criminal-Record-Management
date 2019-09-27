package com.JFS.Criminal.Record.Management.dto;

public class CriminalDTO {

	private Long criminalNo;
	private String CriminalName;
	private String bloodGroup;
	private String jailName;
	private String cellNo;
	private String assignWork;
	
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
	
	
	
}
