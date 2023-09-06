package com.example.SoftwareManagementUsingSpring.SoftwareInterface;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftwareManagementUsingSpring.SoftwareRepository.AdminRepository;
import com.example.SoftwareManagementUsingSpring.model.Admin;



@Service
public class AdminServiceImplementation{

	@Autowired
	private AdminRepository adminRepo;
	
	public void addadmin(Admin admin) {
		
		this.adminRepo.save(admin);
		
	}

	public Optional<Admin> getadminByEmail(String email) {
		
		return this.adminRepo.findByadminEmail(email);
		
	}


}