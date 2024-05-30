package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Premium;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Long> {
	
	

}
