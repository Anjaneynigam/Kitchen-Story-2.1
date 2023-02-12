package com.Cafe.CafeMgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cafe.CafeMgmt.exception.ResourceNotFoundException;
import com.Cafe.CafeMgmt.model.Menu;
import com.Cafe.CafeMgmt.repository.MenuRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@GetMapping("/menu")
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}
	//Create menu rest api
	
	  @PostMapping("/menu") 
	  public Menu createMenu(@RequestBody Menu menu) {
	  return menuRepository.save(menu);	
	}
	  //get menu by id rest api
	  @GetMapping("/menu/{id}")
	  public ResponseEntity<Menu> getMenuById(@PathVariable long id) {
		  Menu menu = menuRepository.findById(id)
		     .orElseThrow(()-> new ResourceNotFoundException("Item not exist withid:" + id));
		  return ResponseEntity.ok(menu);	  
	  }
	  //update menu rest api
	  @PutMapping("/menu/{id}")
	  public ResponseEntity<Menu> updateMenu(@PathVariable long id, @RequestBody Menu menuDetails){
		  Menu menu = menuRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Item not exist with id:" + id));
		  menu.setDishName(menuDetails.getDishName());
		  menu.setPrice(menuDetails.getPrice());
		  menu.setImageUrl(menuDetails.getImageUrl());
		  Menu updatedMenu = menuRepository.save(menu);
		  return ResponseEntity.ok(updatedMenu);
	  }
	  // Delete Menu api
	  @DeleteMapping("/menu/{id}")
	  public ResponseEntity<Map<String, Boolean>> deleteMenu(@PathVariable long id){
		  Menu menu = menuRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Item not exist withid:" + id));
		  menuRepository.delete(menu);
		  Map<String, Boolean> response = new HashMap<>();
		  response.put("deleted", Boolean.TRUE);
		  return ResponseEntity.ok(response);
	  }

}
