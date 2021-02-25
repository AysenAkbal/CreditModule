package com.SpringBootFinalProject.FinalProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootFinalProject.FinalProject.business.abstracts.IBlackListService;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.BlackListRepository;
import com.SpringBootFinalProject.FinalProject.entities.concretes.BlackList;

@Service
public class BlackListManager implements IBlackListService {

	@Autowired
	BlackListRepository blackListRepo;
	
	@Override
	public List<BlackList> getAll() {
		
		return blackListRepo.findAll();
	}

}
