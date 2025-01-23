package com.spds.rcms.service.impl;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.rcms.dto.RcmsDetailsDto;
import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.Others;
import com.spds.rcms.entity.MemberDetails;
import com.spds.rcms.entity.RcDetails;
import com.spds.rcms.repository.AddressRepository;
import com.spds.rcms.repository.OthersRepository;
import com.spds.rcms.repository.PersonalDetailsRepository;
import com.spds.rcms.repository.RcDetailsRepository;
import com.spds.rcms.service.PersonalDetailsService;


/**
 * 
 *@author prakash
 *created 30 Dec 2024
 */
@Service
public class MemberDetailsServiceImpl implements PersonalDetailsService{

	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
    private RcDetailsRepository rcDetailsRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OthersRepository othersRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public RcDetails createUpdate(MemberDetails memberDetails) {
		RcDetails rcDetails = new RcDetails();
		// Check if 'isHof' is true
        if (memberDetails.getIsHof()){
        	// Save to RcDetails
        	if(memberDetails.getRcId()!=null) {
        		rcDetails.setId(memberDetails.getRcId());
        	}
        	rcDetails.setFullNameEn(memberDetails.getFullNameEn());
        	rcDetails.setFullNameLl(memberDetails.getFullNamell());
        	rcDetails.setDob(memberDetails.getDob());
        	rcDetails.setAge(memberDetails.getAge());
        	rcDetails.setGenderId(memberDetails.getGenderId());
        	rcDetails.setMotherNameEn(memberDetails.getMotherNameEn());
        	rcDetails.setFatherNameEn(memberDetails.getFatherNameEn());
        	rcDetails.setMaritalStatusId(memberDetails.getMaritalStatusId());
        	rcDetails.setSpouseNameLl(memberDetails.getSpouseNameLl());
        	rcDetails.setMobileNumber(memberDetails.getMobileNumber());
        	rcDetails.setEmailId(memberDetails.getEmailId());
        	rcDetails.setNationality(memberDetails.getNationality());
        	rcDetails=rcDetailsRepository.save(rcDetails);

        	Optional<MemberDetails> person1=personalDetailsRepository.findHofByRcId(memberDetails.getRcId());
        	if(person1.isPresent()) {
        		memberDetails.setId(person1.get().getId());
        	}
        	memberDetails.setRcId(rcDetails.getId());
            personalDetailsRepository.save(memberDetails);
        }
        else {//For Member in case hof is false
        	personalDetailsRepository.save(memberDetails);
        }
        
      //Copy data from RcDetails to PersonalDetails
      return rcDetails;
	}
	
//	public RcDetails createUpdateAddress(Long id, RcDetails rcDetails) {
//		RcDetails rcDetail=rcDetailsRepository.findById(id).get();
//		rcDetail.setAddressType(rcDetails.getAddressType());
//		rcDetail.setHouseNo(rcDetails.getHouseNo());
//		rcDetail.setStreet(rcDetails.getStreet());
//		rcDetail.setLandmark(rcDetails.getLandmark());
//		rcDetail.setArea(rcDetails.getArea());
//		rcDetail.setCity(rcDetails.getCity());
//		rcDetail.setPostOffice(rcDetails.getPostOffice());
//		rcDetail.setTehsilId(rcDetails.getTehsilId());
//		rcDetail.setDistrictId(rcDetails.getDistrictId());
//		rcDetail.setStateId(rcDetails.getStateId());
//		rcDetail.setVillageId(rcDetails.getVillageId());
//		rcDetail.setPincode(rcDetails.getPincode());
//		rcDetail.setGramPanchayat(rcDetails.getGramPanchayat());
//		rcDetail.setBlock(rcDetails.getBlock());
//		rcDetail.setNagarPalika(rcDetails.getNagarPalika());
//		
//		return rcDetailsRepository.save(rcDetail);
//	}
		
	

	@Override
	public MemberDetails getPersonalDetailsById(Long id) {
		return personalDetailsRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("address not found with ID: "+id));
	}

	@Override
	public List<MemberDetails> getAllPersonalDetails(Boolean isActive) {
		if(isActive==true) {
			return personalDetailsRepository.findAllByIsActiveIsTrue();
		}else {
			return personalDetailsRepository.findAllIsDeletedIsFalse();
		}
	}

	@Override
	public MemberDetails deletePersonalDetails(Long id) {
		MemberDetails personalDetails=getPersonalDetailsById(id);
		personalDetails.setActive(false);
		personalDetails.setDeleted(true);
		return personalDetailsRepository.save(personalDetails);
	}

    @Override
	public List<MemberDetails> createUpdateMember(List<MemberDetails> personalDetails) {
		return personalDetailsRepository.saveAll(personalDetails);
	}
	
	@Override
    public RcmsDetailsDto getDetailsById(Long rcId) {
    	RcDetails rcDetails = rcDetailsRepository.findById(rcId).get();
                
        // Fetch related entities
         List<MemberDetails> memberDetails = personalDetailsRepository.findByRcId(rcId);
         List<Address> address = addressRepository.findByRcId(rcId);
         List<Others> others = othersRepository.findByRcId(rcId);

            // Map the main entity to DTO
            RcmsDetailsDto rcmsDetailsDto = modelMapper.map(rcDetails, RcmsDetailsDto.class);

            // Manually map the lists (as ModelMapper handles nested objects)
            rcmsDetailsDto.setMemberDetails(memberDetails);
            rcmsDetailsDto.setAddressDetails(address);
            rcmsDetailsDto.setOthersDetails(others);
            return rcmsDetailsDto;
   }

	@Override
	public List<MemberDetails> getMemberDetailsByRcId(Long rcId) {
		List<MemberDetails> memberList=personalDetailsRepository.findByRcId(rcId);
		return memberList;
	}
    	
}
