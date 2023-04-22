package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CredentialsBean;
import com.example.demo.bean.PatientBean;
import com.example.demo.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/Patient")
public class PatientController {
	@Autowired
	private PatientService adserv;
	@GetMapping("/selectUser/{userID}/{password}")
	@ResponseBody
	public boolean auth(@PathVariable String userID,@PathVariable String password)
{

		System.out.println("Under Controller "+userID+" "+password);
		CredentialsBean cb=new CredentialsBean();
		cb.setcid(userID);
		cb.setPassword(password);
		System.out.println(adserv.authenticate(cb));;
		return adserv.authenticate(cb);
	}
	@PostMapping("/registerUser")
	public String reg(@RequestBody CredentialsBean cb)
	{
		adserv.registerUser(cb);
		return "<h1>User Added Successfully</h1>";
	}
@PostMapping("/addPatient")
public String meth1(@RequestBody PatientBean pb)
{
	System.out.println("Under controller "+pb);
	adserv.addPatient(pb);
	return "<h1>Patient Added Successfully</h1>";
}
@GetMapping("/selectAllPatient")	
public List<PatientBean> meth2()
{
	
	return adserv.viewPatient();
	

}
@PutMapping("/updatePatient")
public String meth3(@RequestBody PatientBean pb)
{
	adserv.updatePatient(pb);
	return "<h1> Patient Updated successfully</h1>";
}
@GetMapping("/patient/{id}")
public PatientBean meth4(@PathVariable(value = "id") int patientId)
{
	return adserv.viewPatientById(patientId);
	
}
@DeleteMapping("/deletePatient/{id}")
public String meth5(@PathVariable(value="id") int PatientId)
{
	System.out.println(PatientId);
	return "<h1>"+adserv.deletePatient(PatientId)+" record deleted successfully</h1>";
}
}