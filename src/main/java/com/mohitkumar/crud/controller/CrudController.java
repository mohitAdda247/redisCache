package com.mohitkumar.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohitkumar.crud.model.DaoCrud;
import com.mohitkumar.crud.service.CrudService;

@RestController
public class CrudController {
	@Autowired
	private  CrudService service;
	
	@PostMapping("/add")
	public DaoCrud addUser(@RequestBody DaoCrud user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<DaoCrud> findAllUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/user/{id}")
	@Cacheable(value="user", key="#id")
	public DaoCrud findUserById(@PathVariable int id) {
		System.out.println("Fetching from database");
		return service.getUsersById(id);
	}
	
	@PutMapping("/update/{id}")
	@CachePut(value="user",key="#id")
	public DaoCrud updateUser(@PathVariable int id,@RequestBody DaoCrud user) {
		user.setId(id);
		return service.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@CacheEvict(value="user",allEntries = true)
	public String deleteUser(@PathVariable int id) {
	   return service.deleteUser(id);
	}
}
