package com.JFS.Criminal.Record.Management.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HealthCondition")
public class HealthCondition {

	private int healthConditionId;
	private String disease;
	private String type;
	private String medicin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "healthId")
	public int getHealthConditionId() {
		return healthConditionId;
	}
	public void setHealthConditionId(int healthConditionId) {
		this.healthConditionId = healthConditionId;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedicin() {
		return medicin;
	}
	public void setMedicin(String medicin) {
		this.medicin = medicin;
	}
}
