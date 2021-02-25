package com.SpringBootFinalProject.FinalProject.business.abstracts;

import java.util.List;

import com.SpringBootFinalProject.FinalProject.entities.concretes.BlackList;

public interface IBlackListService {

	List<BlackList> getAll();
}
