package com.rouge.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="works")
public class Works implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	int id;
	
	@Column(name = "work_name")
	String workName;
	
	
	@Column(name = "starting_date")
	Timestamp startingDate;
	
	@Column(name = "ending_date")
	Timestamp endingDate;
	
	@Column(name = "status")
	String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Timestamp getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Timestamp startingDate) {
		this.startingDate = startingDate;
	}
	public Timestamp getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Timestamp endingDate) {
		this.endingDate = endingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
