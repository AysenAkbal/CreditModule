package com.SpringBootFinalProject.FinalProject.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFinalProject.FinalProject.entities.concretes.LoanApproval;

public interface LoanApprovalRepository extends JpaRepository<LoanApproval, Integer> {

}
