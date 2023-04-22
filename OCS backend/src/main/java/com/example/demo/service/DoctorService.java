package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CredentialsBean;
import com.example.demo.bean.DoctorBean;
import com.example.demo.dao.doctordao;


@Service
public class DoctorService {
@Autowired
private doctordao adao;
public  String registerUser(CredentialsBean user)
{
	return adao.registerUser(user);
}
public boolean authenticate(CredentialsBean user) 
{
return  adao.authenticate(user);
}
public String addDoctor(DoctorBean doctorBean) 
{
	return adao.addDoctor(doctorBean);
}
public ArrayList<DoctorBean> viewDoctor()
{
	return adao.viewDoctor();
}
public String updateDoctor(DoctorBean doctorBean)
{
	return adao.updateDoctor(doctorBean);
}
public String deleteDoctor(int doctorId)
{
	return adao.deleteDoctor(doctorId);
}
public DoctorBean viewDoctorById(int doctorId)
{
	return adao.viewDoctorById(doctorId);
}

}