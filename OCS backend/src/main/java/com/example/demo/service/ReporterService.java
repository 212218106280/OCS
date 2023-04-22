package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CredentialsBean;
import com.example.demo.bean.LeaveBean;
import com.example.demo.dao.repoterdao;


@Service
public class ReporterService {
@Autowired
private repoterdao  adao;
public  String registerUser(CredentialsBean user)
{
	return adao.registerUser(user);
}
public boolean authenticate(CredentialsBean user) 
{
return  adao.authenticate(user);
}
public String addReporter(LeaveBean leaveBean) 
{
	return adao.addRepoter(leaveBean);
}
public ArrayList<LeaveBean> viewReporter()
{
	return adao.viewReporter();
}
public String updateReporter(LeaveBean reporterBean)
{
	return adao.updateReporter(reporterBean);
}
public String deleteReporter(int reporterId)
{
	return adao.deleteReporter(reporterId);
}
public LeaveBean viewReporterById(int reporterId)
{
	return adao.viewReporterById(reporterId);
}

}