package com.mohitkumar.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohitkumar.crud.dao.CrudDao;
import com.mohitkumar.crud.model.DaoCrud;

@Service
public class CrudService {
	
	@Autowired
	private CrudDao crudDao;
	
	//Create user starts here

	public DaoCrud saveUser(DaoCrud user) {
		return crudDao.save(user);
	}
	
	//Create users Ends here
	
	//read user starts here
	public List<DaoCrud> getUsers(){
		return crudDao.findAll();
	}
	public DaoCrud getUsersById(int id){
		return crudDao.findById(id).orElse(null);
	}
	//read user ends here
	
	//delete user by id start here
	public String deleteUser(int id) {
		crudDao.deleteById(id);
		return "User with id = " + id + " has been deleted";
	}
	//delete user ends here
	
	//update user starts here
	public DaoCrud updateUser(DaoCrud user) {
		return crudDao.save(user);
	}
	
	//update users ended here
	
	
}
