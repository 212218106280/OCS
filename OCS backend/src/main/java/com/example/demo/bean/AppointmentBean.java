package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OCS_TBL_APPOINTMENTS")
public class AppointmentBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appointmentID;
	
	@ManyToOne
	@JoinColumn(name="doctorID")
	private DoctorBean doctor;
	@ManyToOne
	@JoinColumn(name="patientID")
	private PatientBean patient;
	

	public Long getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(Long appointmentID) {
		this.appointmentID = appointmentID;
	}
	public DoctorBean getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}
	public PatientBean getPatient() {
		return patient;
	}
	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}
	
	
	private String appointmentDate;
	private String appointmentTime;
	
//	public String getDoctorID() {
//		return doctorID;
//	}
//	public void setDoctorID(String doctorID) {
//		this.doctorID = doctorID;
//	}
//	public String getPatientID() {
//		return patientID;
//	}
//	public void setPatientID(String patientID) {
//		this.patientID = patientID;
//	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	

}
