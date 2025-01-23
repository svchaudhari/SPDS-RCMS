package com.spds.rcms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.rcms.entity.Address;
import com.spds.rcms.repository.AddressRepository;
import com.spds.rcms.service.AddressService;


/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address createUpdate(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	@Override
	public Address getAddressById(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).orElseThrow(()-> new RuntimeException("address not found with ID: "+id));
	}

	@Override
	public List<Address> getAllAddress(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return addressRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return addressRepository.findAll();
			
		}
		
	}

	@Override
	public Address deleteAddress(Long id) {
		// TODO Auto-generated method stub
		Address address=getAddressById(id);
		address.setActive(false);
		address.setDeleted(true);
		return addressRepository.save(address);
	}

	@Override
	public Address getAddressByRcId(Long rcId) {
		// TODO Auto-generated method stub
		return addressRepository.getByRcId(rcId);
	}

}
