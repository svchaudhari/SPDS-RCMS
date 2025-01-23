package com.spds.rcms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.rcms.entity.Address;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long>{
	@Query(value="select * from master.address where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	
    List<Address> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Address> findByRcId(Long rcId);

	@Query(value="select * from master.address where rc_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	Address getByRcId(Long rcId);


	
}