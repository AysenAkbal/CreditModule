package com.SpringBootFinalProject.FinalProject.business.concretes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ILoanApprovalService;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.CustomerLoanRepository;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.LoanApprovalRepository;
import com.SpringBootFinalProject.FinalProject.entities.concretes.LoanApproval;

@Service
public class LoanApprovalManager implements ILoanApprovalService {

	@Autowired
	LoanApprovalRepository loanApprovalRepo;
	
	
	@Autowired
	CustomerLoanRepository customerLoanRepo;
	
	@Override
	public List<LoanApproval> getAll() {
		
		return loanApprovalRepo.findAll();
	}
	

	@Override
	public LoanApproval approve(LoanApproval loanApproval) throws IOException {
		
		ClassPathResource jsaCoverImgFile = new ClassPathResource("files/mert_kimlik.png");
		byte[] arrayData = new byte[(int) jsaCoverImgFile.contentLength()];
		jsaCoverImgFile.getInputStream().read(arrayData);
		loanApproval.setName("JSA-Cover");
		loanApproval.setType("png");
		loanApproval.setPic(arrayData);
					
		
		// store files to PostgreSQL via SpringJPA
		loanApprovalRepo.saveAll(Arrays.asList(loanApproval));
		
		// retrieve image from PostgreSQL via SpringJPA
		for(LoanApproval model : loanApprovalRepo.findAll()){
			Files.write(Paths.get( "download/" + model.getName() + "." + model.getType()), model.getPic());
		
		}

		return loanApproval;
	}
}


	
