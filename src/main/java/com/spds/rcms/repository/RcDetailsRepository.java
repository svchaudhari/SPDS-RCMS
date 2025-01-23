package com.spds.rcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spds.rcms.entity.MemberDetails;
import com.spds.rcms.entity.RcDetails;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RcDetailsRepository extends JpaRepository<RcDetails, Long> {

	
	
}



