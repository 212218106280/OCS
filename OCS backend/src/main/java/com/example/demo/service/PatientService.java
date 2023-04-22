package com.example.demo.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bean.CredentialsBean;
import com.example.demo.bean.PatientBean;
import com.example.demo.dao.patientdao;
@Service
public class PatientService {
@Autowired
private patientdao adao;
public  String registerUser(CredentialsBean user)
{
	return adao.registerUser(user);
}
public boolean authenticate(CredentialsBean user) 
{
return  adao.authenticate(user);
}
public String addPatient(PatientBean patientBean) 
{
	return adao.addPatient(patientBean);
}
public ArrayList<PatientBean> viewPatient()
{
	return adao.viewPatient();
}
public String updatePatient(PatientBean patientBean)
{
	return adao.updatePatient(patientBean);
}
public String deletePatient(int PatientId)
{
	return adao.deletePatient(PatientId);
}
public PatientBean viewPatientById(int PatientId)
{
	return adao.viewPatientById(PatientId);
}

}