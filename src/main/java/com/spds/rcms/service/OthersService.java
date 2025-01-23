package com.spds.rcms.service;

import java.util.List;

import com.spds.rcms.dto.AdditionalDto;
import com.spds.rcms.dto.OthersDto;
import com.spds.rcms.entity.Others;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
public interface OthersService {

	//Others createOthersDetails(Others others);
	Others getDetailsById(Long id);
	List<Others> getAllDetails(Boolean isActive);
	Others deleteDetails(Long id);
	Others createAdditionalDetails(Others others);
	Others saveOthers(OthersDto oth);
	Others saveAdditionalDetails(AdditionalDto additional);
	Others getOtherByRcId(Long rcId);
	
	
}