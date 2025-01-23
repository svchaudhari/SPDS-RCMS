package com.spds.rcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.rcms.dto.AdditionalDto;
import com.spds.rcms.dto.GenericResponse;
import com.spds.rcms.dto.OthersDto;
import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.Others;
import com.spds.rcms.service.AddressService;
import com.spds.rcms.service.OthersService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class OthersController {

	@Autowired
	private OthersService othersService;
	
	@PostMapping("/others/create-other")
	ResponseEntity<GenericResponse<Others>> saveOthersDetails(@RequestBody OthersDto others) throws Exception{
		//Others saveDetails=othersService.createOthersDetails(others);
		Others saveDetails=othersService.saveOthers(others);
		
		if (saveDetails != null) {
	        GenericResponse<Others> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details saved successfully",  
	            saveDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Others> response = new GenericResponse<>(
	            true,                
	            "Details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@PostMapping("/others/create-additional")
	ResponseEntity<GenericResponse<Others>> saveAdditionalDetails(@RequestBody AdditionalDto additional) throws Exception{
		Others saveDetails=othersService.saveAdditionalDetails(additional);
		if (saveDetails != null) {
	        GenericResponse<Others> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details saved successfully",  
	            saveDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Others> response = new GenericResponse<>(
	            true,                
	            "Details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/others/get")
	ResponseEntity<GenericResponse<Others>> getAddress(@RequestParam Long id){
		Others getDetails=othersService.getDetailsById(id);
		if (getDetails != null) {
	        GenericResponse<Others> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details saved successfully",  
	            getDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Others> response = new GenericResponse<>(
	            true,                
	            "Details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/others/get-all")
	ResponseEntity<GenericResponse<List<Others>>> getDetails(@RequestParam Boolean isActive){
		List<Others> getDetails=othersService.getAllDetails(isActive);
		if (getDetails != null) {
	        GenericResponse<List<Others>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details saved successfully",  
	            getDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<List<Others>> response = new GenericResponse<>(
	            true,                
	            "Details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	
	@GetMapping("/others/delete")
	ResponseEntity<GenericResponse<Others>> deleteDetails(@RequestParam Long id){
		Others deleteId=othersService.deleteDetails(id);
		if (deleteId != null) {
	        GenericResponse<Others> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details deleted successfully",  
	            deleteId      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Others> response = new GenericResponse<>(
	            true,                
	            "Details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}


	@GetMapping("/other/get-by-rcid")
	ResponseEntity<GenericResponse<Others>> getAddressByRcId(@RequestParam Long rcId){
		Others getOthers =othersService.getOtherByRcId(rcId);
		if (getOthers != null) {
			GenericResponse<Others> response = new GenericResponse<>(
					false,
					"",
					"Details retrieved successfully",
					getOthers
			);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			GenericResponse<Others> response = new GenericResponse<>(
					true,
					"Personal details not found",
					"",
					null
			);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}
	
	
}
