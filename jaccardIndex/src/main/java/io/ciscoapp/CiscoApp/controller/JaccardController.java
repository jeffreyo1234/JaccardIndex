package io.ciscoapp.CiscoApp.controller;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ciscoapp.CiscoApp.service.JaccardServices;

@RestController
public class JaccardController {
	
	@Autowired
	JaccardServices services;
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello";
	}
	

	@RequestMapping("/hello1234/{urlA}&{urlB}")
	public void sayHi12345(@PathVariable URL urlA,@PathVariable URL urlB) {
		services.getJaccardIndex(urlA,urlB);
	}
	
}
