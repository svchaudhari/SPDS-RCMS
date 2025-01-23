package com.spds.rcms.service;

import java.util.List;

import com.spds.rcms.dto.RcmsDetailsDto;
import com.spds.rcms.entity.MemberDetails;
import com.spds.rcms.entity.RcDetails;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
public interface PersonalDetailsService {

	RcDetails createUpdate(MemberDetails personalDetails);
	MemberDetails getPersonalDetailsById(Long id);
	List<MemberDetails> getAllPersonalDetails(Boolean isActive);
	MemberDetails deletePersonalDetails(Long id);
	List<MemberDetails> createUpdateMember(List<MemberDetails> personalDetails);
	//RcDetails createUpdateAddress(Long id, RcDetails rcDetails);
	RcmsDetailsDto getDetailsById(Long rcId);
	List<MemberDetails> getMemberDetailsByRcId(Long rcId);
	
	
	
	
	
}