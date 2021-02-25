package com.SpringBootFinalProject.FinalProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalProject.FinalProject.business.abstracts.IBlackListService;
import com.SpringBootFinalProject.FinalProject.entities.concretes.BlackList;

@RestController
@RequestMapping("/api/v1")
public class BlackListController {

	@Autowired
	IBlackListService blackListService;
	
	@GetMapping("/blacklist")
	public List<BlackList> getAll(){
		
		return blackListService.getAll();
	}
}
