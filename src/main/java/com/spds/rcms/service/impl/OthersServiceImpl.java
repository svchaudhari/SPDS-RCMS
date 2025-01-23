package com.spds.rcms.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.rcms.dto.AdditionalDto;
import com.spds.rcms.dto.OthersDto;
import com.spds.rcms.entity.Others;
import com.spds.rcms.repository.OthersRepository;
import com.spds.rcms.service.OthersService;


/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Service
public class OthersServiceImpl implements OthersService{

	@Autowired
	private OthersRepository othersRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	//Additional details saved
	@Override
	public Others createAdditionalDetails(Others others) {
		Long rcId=others.getRcId();
		Others othersDetails=othersRepository.findById(rcId).get();
		Others other=new Others();
		other.setBankId(othersDetails.getBankId());
		other.setBranchId(othersDetails.getBranchId());
		other.setBankAccountNumber(othersDetails.getBankAccountNumber());
		other.setIfscCode(othersDetails.getIfscCode());
		other.setGovWaterSupply(othersDetails.getGovWaterSupply());
		other.setGotHomeUsingGovScheme(othersDetails.getGotHomeUsingGovScheme());
		other.setGovtPension(othersDetails.getGovtPension());
		other.setElectricityConsumerNo(othersDetails.getElectricityConsumerNo());
		other.setCurrentBill(othersDetails.getCurrentBill());
		other.setWetLandDetails(othersDetails.getWetLandDetails());
		other.setDryLandDetails(othersDetails.getDryLandDetails());
		
		return othersRepository.save(other);
	}

	@Override
	public Others getDetailsById(Long id) {
        return othersRepository.findById(id).orElseThrow(()-> new RuntimeException("details not found with ID: "+id));
	}

	@Override
	public List<Others> getAllDetails(Boolean isActive){
		if(isActive==true) {
			return othersRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return othersRepository.findAll();
			}
		}

	@Override
	public Others deleteDetails(Long id) {
        Others others=getDetailsById(id);
		others.setActive(false);
		others.setDeleted(true);
		return othersRepository.save(others);
	}
	
	 @Override
	 public Others saveOthers(OthersDto oth) {
	    Others othDetails = othersRepository.findByRcIdSingle(oth.getRcId());
	    
	    if(othDetails==null) {
	    	othDetails = new Others();
	    }
	    
	    othDetails.setRcId(oth.getRcId());
	    othDetails.setQualificationId(oth.getQualification());
	    othDetails.setFarmerRegistrationDetails(oth.getFarmerRegistrationDetails());
	    othDetails.setEshramId(oth.getEshramId());
	    othDetails.setIsPanNumberAvailable(oth.getIsPanNumberAvailable());
	    othDetails.setPanNumber(oth.getPanNumber());
	    othDetails.setIsGovtEmployee(oth.getIsGovtEmployee());
	    othDetails.setGasConnectionStatus(oth.getGasConnectionStatus());
	    othDetails.setGasConsumerNumber(oth.getGasConsumerNumber());
	    othDetails.setGasConsumerName1(oth.getGasConsumerName1());
	    othDetails.setGasConsumerName2(oth.getGasConsumerName2());
	    othDetails.setGasCompanyId(oth.getGasCompanyId());
	    othDetails.setGasAgencyId(oth.getGasAgencyId());
	    othDetails.setNumbersOfGasCylinders(oth.getNumbersOfGasCylinders());
	    othDetails.setNationalPopulationRegisterNumber(oth.getNationalPopulationRegisterNumber());
	    othDetails.setCasteCategoryId(oth.getCasteCategoryId());
	    othDetails.setCasteCategoryCertificate(oth.getCasteCategoryCertificate());
	    //othDetails.setCriticalIllness(oth.getCriticalIllness());
	    //othDetails.setCriticalIllnessType(oth.getCriticalIllnessType());
	    //othDetails.setCriticalIllnessSince(oth.getCriticalIllnessSince());
	    //othDetails.setCriticalIllnessSinceYear(oth.getCriticalIllnessSinceYear());
	    //othDetails.setUploadIllnessDocument(oth.getUploadIllnessDocument());
	    othDetails.setSpecialCategory(oth.getSpecialCategory());
	    othDetails.setMgnregaStatus(oth.getMgnregaStatus());
	    othDetails.setMgnregaId(oth.getMgnregaId());
	    othDetails.setRemarks(oth.getRemarks());
	    return othersRepository.save(othDetails);
	   }

	 @Override
	 public Others saveAdditionalDetails(AdditionalDto additional) {
	    Others additionalDetails = othersRepository.findByRcIdSingle(additional.getRcId());
	    
	    if(additionalDetails==null) {
	    	additionalDetails = new Others();
	    }
	    additionalDetails.setRcId(additional.getRcId());  
	    additionalDetails.setBankId(additional.getBankId());
	    additionalDetails.setBranchId(additional.getBranchId());
	    additionalDetails.setBankAccountNumber(additional.getBankAccountNumber());
	    additionalDetails.setIfscCode(additional.getIfscCode());
	    additionalDetails.setGovWaterSupply(additional.getGovWaterSupply());  
	    additionalDetails.setGotHomeUsingGovScheme(additional.getGotHomeUsingGovScheme());
	    additionalDetails.setGovtPension(additional.getGovtPension());
	    additionalDetails.setElectricityConsumerNo(additional.getElectricityConsumerNo()); 
	    additionalDetails.setCurrentBill(additional.getCurrentBill());
	    additionalDetails.setWetLandDetails(additional.getWetLandDetails());
	    additionalDetails.setDryLandDetails(additional.getDryLandDetails());  
	    return othersRepository.save(additionalDetails);
	   }

	@Override
	public Others getOtherByRcId(Long rcId) {
		return this.othersRepository.getByRcId(rcId);
	}


}
