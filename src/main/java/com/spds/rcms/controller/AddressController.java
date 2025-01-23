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

import com.spds.rcms.dto.GenericResponse;
import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.MemberDetails;
import com.spds.rcms.service.AddressService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address/create-update")
	ResponseEntity<GenericResponse<Address>> saveAddress(@RequestBody Address address) throws Exception{
		Address savedAddress=addressService.createUpdate(address);
		if (savedAddress != null) {
	        GenericResponse<Address> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            savedAddress      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Address> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/address/get")
	ResponseEntity<GenericResponse<Address>> getAddress(@RequestParam Long id){
		Address getAddress=addressService.getAddressById(id);
		if (getAddress != null) {
	        GenericResponse<Address> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            getAddress      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Address> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/address/get-all")
	ResponseEntity<GenericResponse<List<Address>>> getAddress(@RequestParam Boolean isActive){
		List<Address> getAllAddress=addressService.getAllAddress(isActive);
		if (getAllAddress != null) {
	        GenericResponse<List<Address>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            getAllAddress      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<List<Address>> response = new GenericResponse<>(
	            true,                
	            "Address details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	
	@GetMapping("/address/delete")
	ResponseEntity<GenericResponse<Address>> deleteAddress(@RequestParam Long id){
		Address deleteAddress=addressService.deleteAddress(id);
		if (deleteAddress != null) {
	        GenericResponse<Address> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            deleteAddress      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Address> response = new GenericResponse<>(
	            true,                
	            "Address details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
	@GetMapping("/address/get-by-rcid")
	ResponseEntity<GenericResponse<Address>> getAddressByRcId(@RequestParam Long rcId){
		Address getAddress=addressService.getAddressByRcId(rcId);
		if (getAddress != null) {
	        GenericResponse<Address> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "Details retrieved successfully",  
	            getAddress      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        GenericResponse<Address> response = new GenericResponse<>(
	            true,                
	            "Personal details not found", 
	            "",                  
	            null                 
	        );
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	    }
		
	}
	
}
