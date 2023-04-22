package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OCS_TBL_SCHEDULES")

public class ScheduleBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long scheduleID;
	@ManyToOne
	@JoinColumn(name="doctorID")
	private DoctorBean doctor;
	
	
	public DoctorBean getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}
	public void setScheduleID(Long scheduleID) {
		this.scheduleID = scheduleID;
	}

	private String availableDays;
	private String slots;
	
//	public String getDoctorID() {
//		return doctorID;
//	}
//	public void setDoctorID(String doctorID) {
//		this.doctorID = doctorID;
//	}
	public String getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	

}
