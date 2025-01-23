package com.spds.rcms.dto;

import lombok.Data;

@Data
public class AdditionalDto {
	private Long Id;
	private Long rcId;
	private Long bankId;
	private Long branchId;
	private String bankAccountNumber ;
	private String ifscCode;
	private Boolean govWaterSupply;
	private Boolean gotHomeUsingGovScheme;
	private Boolean govtPension;
	private String electricityConsumerNo;
	private String currentBill;
	private String wetLandDetails;
	private String dryLandDetails;

}
