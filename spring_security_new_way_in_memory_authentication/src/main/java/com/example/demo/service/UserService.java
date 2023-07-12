package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;

@Service
public class UserService {
	
	private List<User> store= new ArrayList<>();

	public UserService() {
	
		store.add(new User(UUID.randomUUID().toString(),"Durgesh Tiwari", "dergush@dev.in"));
		
		store.add(new User(UUID.randomUUID().toString(),"harsh Tiwari", "harsh@dev.in"));
		
		store.add(new User(UUID.randomUUID().toString(),"ankit Tiwari", "ankit@dev.in"));
		
		store.add(new User(UUID.randomUUID().toString(),"gautam Tiwari", "gautam@dev.in"));
		
	}
	
	public List<User> getUsers()
	{
		return this.store;
	}
	
	

}
