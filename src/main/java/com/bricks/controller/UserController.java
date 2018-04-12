/**
 * 
 */
package com.bricks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.model.UserDetails;
import com.bricks.service.UserService;

/**
 * @author shubham
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	public List<UserDetails> getAll(){
		System.out.println("Call to fetch all users");
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public UserDetails getOne(@PathVariable long id) {
		return userService.getOne(id); 
	}
	
	@PostMapping("/save")
	public List<UserDetails> saveNew(@RequestBody UserDetails userDetails){
		userService.saveNew(userDetails);
		System.out.println("Call to save new users");
		return userService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public List<UserDetails> delete(@PathVariable long id){
		userService.delete(id);
		return userService.getAll();
	}
	
	@PutMapping("/update")
	public List<UserDetails> update(@RequestBody UserDetails userDetails){
		UserDetails user = userService.getOne(userDetails.getUserId());
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUserName(userDetails.getUserName());
		userService.saveNew(user);
		return userService.getAll();
	}
}
