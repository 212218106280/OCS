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
import com.example.demo.bean.DoctorBean;
import com.example.demo.service.DoctorService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admin")
public class DoctorController {
	@Autowired
	private DoctorService adserv;
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
@PostMapping("/AddDoctor")
public String meth1(@RequestBody DoctorBean db)
{
	System.out.println("Under controller "+db);
	adserv.addDoctor(db);
	return "<h1>Doctor Added Successfully</h1>";
}
@GetMapping("/selectAll")	
public List<DoctorBean> meth2()
{
	
	return adserv.viewDoctor();
}
@PutMapping("/updateDoctor")
public String meth3(@RequestBody DoctorBean db)
{
	adserv.updateDoctor(db);
	return "<h1> Doctor Updated successfully</h1>";
}
@GetMapping("/doctor/{id}")
public DoctorBean meth4(@PathVariable(value = "id") int doctorId)
{
	return adserv.viewDoctorById(doctorId);
	
}
@DeleteMapping("/deleteDoctor/{id}")
public String meth5(@PathVariable(value="id") int doctorId)
{
	System.out.println(doctorId);
	return "<h1>"+adserv.deleteDoctor(doctorId)+" record deleted successfully</h1>";
}

}