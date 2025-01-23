package com.spds.rcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.rcms.dto.GenericResponse;
import com.spds.rcms.dto.RcmsDetailsDto;
import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.MemberDetails;
import com.spds.rcms.entity.RcDetails;
import com.spds.rcms.service.AddressService;
import com.spds.rcms.service.PersonalDetailsService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PersonalDetailsController {

	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@PostMapping("/personalDetails/create-update-hof")
	ResponseEntity<GenericResponse<RcDetails>> savePersonalDetails(@RequestBody MemberDetails memberDetails) {
		RcDetails personalDetail=personalDetailsService.createUpdate(memberDetails);
		if (personalDetail != null) {
	        GenericResponse<RcDetails> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            personalDetail      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<RcDetails> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
	}
	@PostMapping("/personalDetails/create-update-member")
	ResponseEntity<GenericResponse<List<MemberDetails>>> saveMemberDetails(@RequestBody List<MemberDetails> memberDetails) throws Exception{
		
		List<MemberDetails> personalDetail=personalDetailsService.createUpdateMember(memberDetails);
		if (personalDetail != null) {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            personalDetail      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
	}
	
//	@GetMapping("/personalDetails/create-update-address")
//	ResponseEntity<GenericResponse<RcDetails>> saveAddressDetails(@RequestParam Long id, @RequestBody RcDetails rcDetails) {
//		RcDetails addressDetails = personalDetailsService.createUpdateAddress(id,rcDetails);
//		if (addressDetails != null) {
//	        GenericResponse<RcDetails> response = new GenericResponse<>(
//	            false,               
//	            "",                  
//	            "Details retrieved successfully",  
//	            addressDetails      
//	        );
//	        return new ResponseEntity<>(response, HttpStatus.OK);
//	    } else {
//	        GenericResponse<RcDetails> response = new GenericResponse<>(
//	            true,                
//	            "Personal details not found", 
//	            "",                  
//	            null                 
//	        );
//	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
//	    }
//	}
	
	@GetMapping("/personalDetails/get")
	ResponseEntity<GenericResponse<MemberDetails>> getPersonalDetails(@RequestParam Long id) {
	    MemberDetails personalDetails = personalDetailsService.getPersonalDetailsById(id);

	    if (personalDetails != null) {
	        GenericResponse<MemberDetails> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            personalDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<MemberDetails> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
	}

	@GetMapping("/personalDetails/get-all")
	ResponseEntity<GenericResponse<List<MemberDetails>>> getPersonalDetails(@RequestParam Boolean isActive){
		List<MemberDetails> personalDetails= personalDetailsService.getAllPersonalDetails(isActive);
		if (personalDetails != null) {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            personalDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	
	@DeleteMapping("/personalDetails/delete")
	ResponseEntity<GenericResponse<MemberDetails>> deletePersonalDetails(@RequestParam Long id){
		MemberDetails deletedPerson = personalDetailsService.deletePersonalDetails(id);
		if (deletedPerson != null) {
	        GenericResponse<MemberDetails> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            deletedPerson      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<MemberDetails> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/personalDetails/getDetails")
	ResponseEntity<RcmsDetailsDto> getDetails(@RequestParam Long rcId) {
	    RcmsDetailsDto personalDetails = personalDetailsService.getDetailsById(rcId);
		return new ResponseEntity<>(personalDetails, HttpStatus.OK); 

	 }
	
	@GetMapping("/personalDetails/get-member-details")
	ResponseEntity<GenericResponse<List<MemberDetails>>> getMemberDetails(@RequestParam Long rcId) {
	    List<MemberDetails> personalDetails = personalDetailsService.getMemberDetailsByRcId(rcId);

	    if (personalDetails != null) {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            personalDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<List<MemberDetails>> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
	}
}
