package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8080/home/users
	@GetMapping("/users")
	public List<User> getUser()
	{
		System.out.println("getting users");
		return userService.getUsers();

	}
	
	@GetMapping("/get-curren-user")
	public String getLogginUser(Principal principal)
	{
		return principal.getName();
		
	}
	
	@GetMapping("/getname")
	public String getname()
	{
		String ob = "i am rahul kumar";
		return ob;
	}

}
