package com.sample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.entity.Admin;
import com.sample.service.AdminService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	public AdminController(AdminService adminService)
	{
		super();
		this.adminService = adminService;
	}
	
	@PostMapping
    public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin)
	{
    	System.out.println("this is admin: "+admin);
    	return new ResponseEntity<Admin>(adminService.registerAdmin(admin),HttpStatus.CREATED);
    }
	
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin),HttpStatus.OK);
		
	}
	
	
	@PutMapping("{aId}")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,@PathVariable("aId") int aId)
	{
		 
		 return new ResponseEntity<Admin>(this.adminService.updateAdmin(admin,aId),HttpStatus.OK);
	}
	
	
	@DeleteMapping("{aId}")
	public ResponseEntity<String> deleteAdminAccount(@PathVariable("aId")int aId)
	{
		this.adminService.deleteAdminAccount(aId);
		return new ResponseEntity<String>("Your Account deleted successfully",HttpStatus.OK);

	}

	
}
