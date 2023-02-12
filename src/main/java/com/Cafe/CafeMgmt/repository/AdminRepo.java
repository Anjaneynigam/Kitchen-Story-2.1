package com.Cafe.CafeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cafe.CafeMgmt.model.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

	Admin findByUserId(String userId);

}
