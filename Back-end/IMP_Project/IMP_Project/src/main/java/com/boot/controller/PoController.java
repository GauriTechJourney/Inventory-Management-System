package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.boot.entity.Po;
import com.boot.service.PoService;

@RestController
@RequestMapping("/api/po")
@CrossOrigin
public 
class PoController {

	@Autowired
	private PoService poserv;
	
	@PostMapping("/adddata")
	public void addRecords(@RequestBody Po author) {
		
		poserv.addRecords(author);
	}
	@GetMapping("/get-all")

	public List<Po> getAll() {

		return poserv.getAll();
	}	
}
