package com.SpringBootFinalProject.FinalProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringBootFinalProject.FinalProject.entities.concretes.LoanApproval;

@Repository
public interface ILoanApprovalService {

	List<LoanApproval> getAll();
	LoanApproval approve(LoanApproval loanApproval) throws IOException;

}
