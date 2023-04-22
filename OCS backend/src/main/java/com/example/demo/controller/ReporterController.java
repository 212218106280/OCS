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
import com.example.demo.bean.LeaveBean;
import com.example.demo.service.ReporterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/reporter")
public class ReporterController {
	@Autowired
	private ReporterService adserv;
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
@PostMapping("/addReporter")
public String meth1(@RequestBody LeaveBean db)
{
	System.out.println("Under controller "+db);
	adserv.addReporter(db);
	return "<h1>Reporter Added Successfully</h1>";
}
@GetMapping("/selectAll")	
public List<LeaveBean> meth2()
{
	
	return adserv.viewReporter();
}
@PutMapping("/updateReporter")
public String meth3(@RequestBody LeaveBean db)
{
	adserv.updateReporter(db);
	return "<h1> Reporter Updated successfully</h1>";
}
@GetMapping("/reporter/{id}")
public LeaveBean meth4(@PathVariable(value = "id") int reporterId)
{
	return adserv.viewReporterById(reporterId);
	
}
@DeleteMapping("/deleteReporter/{id}")
public String meth5(@PathVariable(value="id") int ReporterId)
{
	System.out.println(ReporterId);
	return "<h1>"+adserv.deleteReporter(ReporterId)+" record deleted successfully</h1>";
}
}