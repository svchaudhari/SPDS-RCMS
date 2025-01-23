package com.spds.rcms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.Others;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Transactional
public interface OthersRepository extends JpaRepository<Others, Long>{
	@Query(value="select * from master.others where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	
    List<Others> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Others> findByRcId(Long rcId);

	@Query(value="select * from master.others where rc_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	Others findByRcIdSingle(Long rcId);


	@Query(value="select * from rcms.other_details where rc_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	Others getByRcId(Long rcId);





	
}
