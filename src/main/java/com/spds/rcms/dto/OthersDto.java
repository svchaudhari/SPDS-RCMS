package com.spds.rcms.dto;

import lombok.Data;

@Data
public class OthersDto {
	private Long Id;
    private Long rcId;
    private String qualification;
	private String farmerRegistrationDetails;
	private String eshramId;
	private Boolean isPanNumberAvailable;
    private String panNumber;
	private Boolean isGovtEmployee;
    private Boolean gasConnectionStatus;
    private String gasConsumerNumber;
	private String gasConsumerName1;
	private String gasConsumerName2;
	private String gasCompanyId;
	private String gasAgencyId;
    private Integer numbersOfGasCylinders;
	private String nationalPopulationRegisterNumber;
	private Long casteCategoryId  ;
	private String casteCategoryCertificate;
	private String criticalIllness;
    private String criticalIllnessType;
	private String criticalIllnessSince;
	private String criticalIllnessSinceYear;
    private String uploadIllnessDocument;
	private String specialCategory  ;
    private String mgnregaStatus;
	private String mgnregaId;
	private String remarks;
	
	
}
