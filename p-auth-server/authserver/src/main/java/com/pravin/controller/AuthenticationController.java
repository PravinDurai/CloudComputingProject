package com.pravin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.model.User;
import com.pravin.service.JwtUserService;

import javassist.NotFoundException;

@RestController
public class AuthenticationController {
	
	@Autowired
	private JwtUserService service;
	
	@PostMapping("/generate")
	public ResponseEntity<Map<String, String>> generateToken(@RequestBody User user) throws NotFoundException{
		String token = service.generateToken(user);
		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/isexpired/{token}")
	public ResponseEntity<Boolean> isExpired(@PathVariable("token") String token){
		return new ResponseEntity<>(service.isExpired(token), HttpStatus.OK);		
	}

}
