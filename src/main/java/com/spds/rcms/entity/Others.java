package com.spds.rcms.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 *@author prakash
 *This class was creaded on 30-Dec-2024.
 */
@Data
@Entity
@Table(schema = "rcms", name = "other_details")
@NoArgsConstructor
public class Others extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -25365148147119768L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "others_seq_id")
	@SequenceGenerator(name = "others_seq_id", sequenceName = "others_seq_id", schema = "rcms", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rc_id")
	private Long rcId;

	@Column(name = "qualification_id",length = 254)
	private String qualificationId;
	
	@Column(name = "farmer_registration_details",length = 20)
	private String farmerRegistrationDetails;
	
	@Column(name = "eshram_Id",length = 100)
	private String eshramId;
	
	@Column(name = "is_pan_number_available",length = 255)
	private Boolean isPanNumberAvailable;

	@Column(name = "pan_number ",length = 20)
	private String panNumber;
	
	@Column(name = "is_govt_employee",length = 255)
	private Boolean isGovtEmployee;

	@Column(name = "gas_connection_status",length = 255)
	private Boolean gasConnectionStatus;

	@Column(name = "gas_consumer_number",length = 20)
	private String gasConsumerNumber;
	
	@Column(name = "gas_consumer_name1",length = 50)
	private String gasConsumerName1;
	
	@Column(name = "gas_consumer_name2",length = 50)
	private String gasConsumerName2;
	
	@Column(name = "gas_company_id",length = 100)
	private String gasCompanyId;
	
	@Column(name = "gas_agency_id",length = 255)
	private String gasAgencyId;

	@Column(name = "number_of_gas_cylinders",length = 20)
	private Integer numbersOfGasCylinders;
	
	@Column(name = "national_population_register_number",length = 255)
	private String nationalPopulationRegisterNumber;
	
    @Column(name = "caste_category_id",length = 20)
	private Long casteCategoryId  ;
	
	@Column(name = "caste_category_certificate",length = 100)
	private String casteCategoryCertificate;
	
	
	
//	@Column(name = "critical_illness",length = 255)
//	private String criticalIllness;
//
//	@Column(name = "critical_illness_type",length = 20)
//	private Long criticalIllnessType;
//	
//	@Column(name = "critical_illness_since",length = 100)
//	private String criticalIllnessSince;
//	
//	@Column(name = "critical_illness_since_year",length = 255)
//	private String criticalIllnessSinceYear;
//
//	@Column(name = "upload_illness_document",length = 20)
//	private Long uploadIllnessDocument;
	
	
	
	@Column(name = "special_category  ",length = 100)
	private String specialCategory  ;
	
	@Column(name = "mgnrega_status",length = 100)
	private String mgnregaStatus;
	
	@Column(name = "mgnrega_id",length = 255)
	private String mgnregaId;
	
	@Column(name = "remarks",length = 255)
	private String remarks;
	
	@Column(name = "bank_id",length = 10)
	private Long bankId;
	
	@Column(name = "branch_id",length = 10)
	private Long branchId;
	
	@Column(name = "bank_account_number",length = 60)
	private String bankAccountNumber ;
	
	@Column(name = "ifsc_code",length = 254)
	private String ifscCode;
	
	@Column(name = "gov_water_supply",length = 254)
	private Boolean govWaterSupply;
	
	@Column(name = "got_home_using_gov_scheme",length = 254)
	private Boolean gotHomeUsingGovScheme;
	
	@Column(name = "govt_pension",length = 20)
	private Boolean govtPension;
	
	@Column(name = "electricity_consumer_no",length = 254)
	private String electricityConsumerNo;
	
	@Column(name = "current_bill",length = 254)
	private String currentBill;
	
	@Column(name = "wet_land_details",length = 254)
	private String wetLandDetails;
	
	@Column(name = "dry_land_details",length = 254)
	private String dryLandDetails;
	
	@JsonIgnore
	@Column(name = "ip_address",length = 20)
	private String ipAddress;
	
	
	
	
}
