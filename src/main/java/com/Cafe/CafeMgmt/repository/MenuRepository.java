package com.Cafe.CafeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cafe.CafeMgmt.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
