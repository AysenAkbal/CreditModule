package com.SpringBootFinalProject.FinalProject.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ILoanApprovalService;
import com.SpringBootFinalProject.FinalProject.entities.concretes.LoanApproval;

@RestController
@RequestMapping("/api/v1")
public class LoanApprovalController {


	@Autowired
	ILoanApprovalService loanApprovalService;
	
	@GetMapping("/loan_approval")
	public List<LoanApproval> getAll(){
		
		return loanApprovalService.getAll();
	}
	
	@PutMapping("/loan_approval/{id}")
	public LoanApproval dowloadDoc(@PathVariable(value ="id") LoanApproval loanApproval) throws IOException {
		
		return loanApprovalService.approve(loanApproval);
	}
}
