package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Profile;

@Entity
@Table(name="OCS_TBL_USER_CREDENTIALS")
public class CredentialsBean {
	@Id
	
	private String cid;
	 
	public String getcid() {
		return cid;
	}
	public void setcid(String cid) {
		this.cid = cid;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	private ProfileBean profile;

	public ProfileBean getProfile() {
		return profile;
	}
	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	@Column(name="password")
	private String Password;
	@Column(name="userType")
	private String UserType;
	@Column (name="loginStatus")
    private String Loginstatus;
	
	public CredentialsBean() {
		
	}
	public CredentialsBean(String Password,String UserType,String Loginstatus ) {
		super();
		this.Password=Password;
		this.UserType=UserType;
		this.Loginstatus=Loginstatus;
		
	}

	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public String getLoginstatus() {
		return Loginstatus;
	}
	public void setLoginstatus(String loginstatus) {
		Loginstatus = loginstatus;
	}
}
