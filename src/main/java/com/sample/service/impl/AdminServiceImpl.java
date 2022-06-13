package com.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.Exception.AdminNotFoundException;
import com.sample.Exception.ResourceNotFoundException;
import com.sample.entity.Admin;
import com.sample.repositary.AdminRepository;
import com.sample.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	

	@Override
	public Admin registerAdmin(Admin admin) {
    	System.out.println("this is admin: "+admin);

		return this.adminRepository.save(admin);
		 
	}

	@Override
	public Admin loginAdmin(Admin admin) {
       
		return this.adminRepository.findByUserNameAndPassword(admin.getUserName(),admin.getPassword()).orElseThrow(()->new ResourceNotFoundException("Invalid username or password"));
		
	}


	@Override
	public Admin updateAdmin(Admin admin, int aId) {
		Admin existingAdmin=this.adminRepository.findById(aId).orElseThrow(()->new AdminNotFoundException("Admin","aId",aId));
		existingAdmin.setfName(admin.getfName());
		existingAdmin.setlName(admin.getlName());
		existingAdmin.setPhoneNo(admin.getPhoneNo());
		existingAdmin.setUserName(admin.getUserName());
		existingAdmin.setPassword(admin.getPassword());
		this.adminRepository.save(existingAdmin);
		return existingAdmin;
	}


	@Override
	public void deleteAdminAccount(int aId) {
		this.adminRepository.findById(aId).orElseThrow(()->new AdminNotFoundException("Admin","aId",aId));
		this.adminRepository.deleteById(aId);
	}

	

}
