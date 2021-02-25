package com.SpringBootFinalProject.FinalProject.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBootFinalProject.FinalProject.entities.concretes.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer>{

	@Query(value="select * from blacklist where customer_id=?1",nativeQuery= true)
	List<BlackList> checkBlackList(Integer custId);
	
}
