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
import com.example.demo.bean.ProfileBean;
import com.example.demo.service.ProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private ProfileService adserv;
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
@PostMapping("/addProfile")
public String meth1(@RequestBody ProfileBean db)
{
	System.out.println("Under controller "+db);
	adserv.addProfile(db);
	return "<h1>Profile Added Successfully</h1>";
}
@GetMapping("/selectAll")	
public List<ProfileBean> meth2()
{
	
	return adserv.viewProfile();
}
@PutMapping("/updateProfile")
public String meth3(@RequestBody ProfileBean db)
{
	adserv.updateProfile(db);
	return "<h1> Profile Updated successfully</h1>";
}
@GetMapping("/profile/{id}")
public ProfileBean meth4(@PathVariable(value = "id") int userId)
{
	return adserv.viewProfileById(userId);
	
}
@DeleteMapping("/deleteProfile/{id}")
public String meth5(@PathVariable(value="id") int userId)
{
	System.out.println(userId);
	return "<h1>"+adserv.deleteProfile(userId)+" record deleted successfully</h1>";
}
}