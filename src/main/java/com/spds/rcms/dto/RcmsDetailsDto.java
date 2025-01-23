package com.spds.rcms.dto;

import java.util.Date;

import java.util.List;

import com.spds.rcms.entity.Address;
import com.spds.rcms.entity.Others;
import com.spds.rcms.entity.MemberDetails;

import lombok.Data;

@Data
public class RcmsDetailsDto {
	private Long Id;
	private Long rcId;
	private String fullNameEn;
	private String fullNamell;
    private Date dob;
    private Integer age;
	private Long genderId;
	private String motherNameEn;
    private String fatherNameEn;
	private Long maritalStatusId;
	private String spouseName  ;
    private String mobileNumber;
	private String emailId;
    private Long nationality;
	private Long schemeId   ;
	private String groupName;
	private String applicationId;
	private String existingRcNumber;
    private String fpsId;
    
	private List<MemberDetails> memberDetails;
	private List<Address> addressDetails;
	private List<Others> othersDetails;
	
	
	
	

}
