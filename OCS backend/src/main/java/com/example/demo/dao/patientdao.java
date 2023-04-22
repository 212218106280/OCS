package com.example.demo.dao;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CredentialsBean;
import com.example.demo.bean.PatientBean;

@Repository
public class patientdao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<PatientBean> q; 
	public  String registerUser(CredentialsBean user)
	{
		System.out.println("Under Dao "+user.getcid()+" "+user.getPassword());
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	public boolean authenticate(CredentialsBean user) 
	{
		System.out.println("Under Dao "+user.getcid()+" "+user.getPassword());
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q3=session.createQuery("from CredentialsBean where cid=:uid and password=:pss");
		q3.setParameter("uid", user.getcid());
		q3.setParameter("pss", user.getPassword());
		ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q3.getResultList();
		int count=0;
		for(CredentialsBean cb:al)
		{
			if((cb.getcid()==(user.getcid()))&&(cb.getPassword().equals(user.getPassword())))
			{
				System.out.println("Record is  present"+cb.getcid()+" "+cb.getPassword());
			
				count++;
				if(count>0)
				{
		return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;	
	}
	public String addPatient(PatientBean patientBean) 
	{
		System.out.println("Under Dao "+patientBean);
		if(patientBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(patientBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(patientBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	public String updatePatient(PatientBean patientBean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(patientBean!=null)
		{
		session.update(patientBean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(patientBean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	public String deletePatient(int patientId)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(patientId>=0)
		{
		Query q1=session.createQuery("delete from PatientBean where patientID=:eid");
		q1.setParameter("eid", patientId);
		q1.executeUpdate();
transaction.commit();
session.close();
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	public ArrayList<PatientBean> viewPatient()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from PatientBean");
		return (ArrayList<PatientBean>) q.list();
	}
	public PatientBean viewPatientById(int patientId)
	{
		PatientBean elBean=new PatientBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<PatientBean> q2=session.createQuery("from PatientBean where patientID=:did");
	q2.setParameter("did", patientId);
	ArrayList<PatientBean> all=(ArrayList<PatientBean>) q2.getResultList();
	for(PatientBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}
}