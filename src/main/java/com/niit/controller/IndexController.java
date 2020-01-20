package com.niit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

//Rest API
//Representational State Transfer
//JSON - Javascript Object Notation

@RestController
public class IndexController 
{
	UserDAOImpl udi=new UserDAOImpl();
	
	@GetMapping("/displayusers")
	//@ResponseBody
	public ResponseEntity<List<User>>  m1()
	{
		return new ResponseEntity<List<User>>(udi.displayUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/displayuser/{userid}/{apikey}")
	//@ResponseBody
	public ResponseEntity<User> m1(@PathVariable("userid") int id,@PathVariable("apikey") String apikey)
	{
		if(apikey.equals("govind123"))
		{
			return new ResponseEntity<User>(udi.displayUserById(id),HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/displayuser/{username}")
	public ResponseEntity<User> m3(@PathVariable("username") String username)
	{
		return new ResponseEntity<User>(udi.displayUserByName(username),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> m1(@RequestBody User user)
	{
		udi.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> m2(@RequestBody User user)
	{
		udi.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> m3(@RequestBody User user)
	{
		udi.deleteUser(user.getUserid());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
