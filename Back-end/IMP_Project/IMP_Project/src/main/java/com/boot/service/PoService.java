package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.entity.Po;
import com.boot.repository.PoReository;

@Service
public class PoService {
	@Autowired
	private PoReository poRep;
	
	public void addRecords(Po author) {

		poRep.save(author);

	}
	public List<Po> getAll() {

		return poRep.findAll();
	}
}
