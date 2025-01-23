package com.spds.rcms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.rcms.entity.MemberDetails;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Transactional
public interface PersonalDetailsRepository extends JpaRepository<MemberDetails, Long>{

	Optional<MemberDetails> findByIsHof(MemberDetails personalDetails);

	List<MemberDetails> findByRcId(Long rcId);

	@Query(value="select * from rcms.member_details where is_active=true and is_deleted=false",nativeQuery=true)
	List<MemberDetails> findAllByIsActiveIsTrue();
	
	@Query(value="select * from rcms.member_details where is_deleted=false",nativeQuery=true)
	List<MemberDetails> findAllIsDeletedIsFalse();

	@Query(value="select * from rcms.member_details where rc_id=? and is_hof=true and is_deleted=false",nativeQuery=true)
	Optional<MemberDetails> findHofByRcId(Long rcId);

	
}