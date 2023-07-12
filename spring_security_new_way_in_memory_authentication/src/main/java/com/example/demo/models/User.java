package com.example.demo.models;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	private String userId;
	
	private String name;
	
	private String email;

}
