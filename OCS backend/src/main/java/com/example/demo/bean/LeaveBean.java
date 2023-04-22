package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OCS_TBL_LEAVE")
public class LeaveBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long leaveID;
	 
	@ManyToOne
	@JoinColumn(name="doctorID")
	private DoctorBean doctor;

	public DoctorBean getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}
	public void setLeaveID(Long leaveID) {
		this.leaveID = leaveID;
	}
//	private String doctorID;
	private String leave_From;
	private String leave_To;
	private String reason;
	private String status;
//	public String getLeaveID() {
//		return leaveID;
//	}
//	public void setLeaveID(String leaveID) {
//		this.leaveID = leaveID;
//	}
//	public String getDoctorID() {
//		return doctorID;
//	}
//	public void setDoctorID(String doctorID) {
//		this.doctorID = doctorID;
//	}
	public String getLeave_From() {
		return leave_From;
	}
	public void setLeave_From(String leave_From) {
		this.leave_From = leave_From;
	}
	public String getLeave_To() {
		return leave_To;
	}
	public void setLeave_To(String leave_To) {
		this.leave_To = leave_To;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
