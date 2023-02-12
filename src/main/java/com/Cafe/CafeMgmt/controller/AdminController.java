package com.Cafe.CafeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cafe.CafeMgmt.model.Admin;
import com.Cafe.CafeMgmt.repository.AdminRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepo repo;
	
    @PostMapping("/login")
	public ResponseEntity<?> loginAdmin(@RequestBody Admin adminData){
    	Admin admin=repo.findByUserId(adminData.getUserId());
    	if(admin.getPassword().equals(adminData.getPassword()))
    		return ResponseEntity.ok(admin);
    	return (ResponseEntity<?>) ResponseEntity.internalServerError();
    	
    }

}
