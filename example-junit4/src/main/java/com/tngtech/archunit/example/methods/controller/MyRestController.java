package com.tngtech.archunit.example.methods.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.example.methods.domain.MyBusinessEntity;

@RestController
@RequestMapping("/my")
public class MyRestController {

	@GetMapping("/data")
	public MyBusinessEntity get() {
		return new MyBusinessEntity();
	}
	
	@DeleteMapping
	public void delete(MyBusinessEntity entity) {
		// demo method declaration.
	}
}
