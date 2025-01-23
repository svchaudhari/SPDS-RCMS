package com.spds.rcms.dto;

import lombok.Data;

@Data
public class AddressDto {
	private Long Id;
	private Long rcId;
	private String addressType;
	private String houseNo;
    private String street;
    private String landmark;
	private String area;
    private String city;
	private String postOffice;
	private Long tehsilId  ;
    private Long districtId;
	private Long stateId;
	private Long villageId;
	private String pincode;
    private String gramPanchayat ;
	private String block;
	private String nagarPalika;
	
	//Permanent address
	private String permanentAddressType;
	private String permanentHouseNo;
    private String permanentStreet;
    private String permanentLandmark;
	private String permanentWardNumber;
	private String permanentArea;
    private String permanentCity;
	private String permanentPostOffice;
	private Long permanentTehsilId  ;
    private Long permanentDistrictId;
	private Long permanentStateId;
	private Long permanentVillageId;
	private String permanentPincode;
    private String permanentGramPanchayat ;
	private String permanentBlock;
	private String permanentNagarPalika   ;

}
