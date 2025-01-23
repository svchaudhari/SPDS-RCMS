package com.spds.rcms.service;

import java.util.List;

import com.spds.rcms.entity.Address;
/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
public interface AddressService {

	Address createUpdate(Address address);
	Address getAddressById(Long id);
	List<Address> getAllAddress(Boolean isActive);
	Address deleteAddress(Long id);
	Address getAddressByRcId(Long rcId);
	
	
}