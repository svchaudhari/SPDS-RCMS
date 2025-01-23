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
@Table(schema = "rcms", name = "address_details")
@NoArgsConstructor
public class Address extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -25365148147119768L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_id")
	@SequenceGenerator(name = "address_seq_id", sequenceName = "address_seq_id", schema = "rcms", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rc_id")
	private Long rcId;
	
	@Column(name = "current_house_no",length = 254)
	private String currentHouseNo;

	@Column(name = "current_street_en",length = 255)
	private String currentStreetEn;
	
	@Column(name = "current_street_ll",length = 255)
	private String currentStreetLl;
	
	@Column(name = "current_landmark_en",length = 20)
	private String currentLandmarkEn;

	@Column(name = "current_landmark_ll",length = 20)
	private String currentLandmarkLl;
	
	@Column(name = "current_area_en",length = 255)
	private String currentAreaEn;
	
	@Column(name = "current_area_ll",length = 255)
	private String currentAreaLl;

	@Column(name = "current_city_en",length = 20)
	private String currentCityEn;
	
	@Column(name = "current_city_ll",length = 20)
	private String currentCityLl;
	
	@Column(name = "current_post_office_en",length = 100)
	private String currentPostOfficeEn;
	
	@Column(name = "current_post_office_ll",length = 100)
	private String currentPostOfficeLl;
	
	@Column(name = "current_tehsil_id",length = 255)
	private Long currentTehsilId  ;

	@Column(name = "current_district_id",length = 20)
	private Long currentDistrictId;
	
	@Column(name = "current_state_id",length = 100)
	private Long currentStateId;
	
	@Column(name = "current_village_id",length = 100)
	private Long currentVillageId;
	
	@Column(name = "current_pincode",length = 255)
	private String currentPincode;

	@Column(name = "current_gram_panchayat_en",length = 20)
	private String currentGramPanchayatEn;
	
	@Column(name = "current_gram_panchayat_ll",length = 20)
	private String currentGramPanchayatLl;
	
	@Column(name = "current_block_en",length = 100)
	private String currentBlockEn;
	
	@Column(name = "current_block_ll",length = 100)
	private String currentBlockLl;
	
	@Column(name = "current_nagar_palika_en",length = 20)
	private String currentNagarPalikaEn;
	
	@Column(name = "current_nagar_palika_ll",length = 20)
	private String currentNagarPalikaLl;
	
	//Permanent address
	@Column(name = "permanent_house_no",length = 254)
	private String permanentHouseNo;

	@Column(name = "permanent_street_en",length = 255)
	private String permanentStreetEn;
	
	@Column(name = "permanent_street_ll",length = 255)
	private String permanentStreetLl;

	@Column(name = "permanent_landmark_en",length = 20)
	private String permanentLandmarkEn;
	
	@Column(name = "permanent_landmark_ll",length = 20)
	private String permanentLandmarkLl;
	
	@Column(name = "permanent_ward_number",length = 100)
	private String permanentWardNumber;
	
	@Column(name = "permanent_area_en",length = 255)
	private String permanentAreaEn;
	
	@Column(name = "permanent_area_ll",length = 255)
	private String permanentAreaLl;

	@Column(name = "permanent_city_en",length = 20)
	private String permanentCityEn;
	
	@Column(name = "permanent_city_ll",length = 20)
	private String permanentCityLl;
	
	@Column(name = "permanent_post_office_en",length = 100)
	private String permanentPostOfficeEn;
	
	@Column(name = "permanent_post_office_ll",length = 100)
	private String permanentPostOfficeLl;
	
	@Column(name = "permanent_tehsil_id",length = 255)
	private Long permanentTehsilId;

	@Column(name = "permanent_district_id",length = 20)
	private Long permanentDistrictId;
	
	@Column(name = "permanent_state_id",length = 100)
	private Long permanentStateId;
	
	@Column(name = "permanent_village_id",length = 100)
	private Long permanentVillageId;
	
	@Column(name = "permanent_pincode",length = 255)
	private String permanentPincode;

	@Column(name = "permanent_gram_panchayat_en",length = 20)
	private String permanentGramPanchayatEn;
	
	@Column(name = "permanent_gram_panchayat_ll",length = 20)
	private String permanentGramPanchayatLl;
	
	@Column(name = "permanent_block_en",length = 100)
	private String permanentBlockEn;
	
	@Column(name = "permanent_block_ll",length = 100)
	private String permanentBlockLl;
	
	@Column(name = "permanent_nagar_palika_en",length = 20)
	private String permanentNagarPalikaEn;
	
	@Column(name = "permanent_nagar_palika_ll",length = 20)
	private String permanentNagarPalikaLl;
	
	@JsonIgnore
	@Column(name = "ip_address",length = 20)
	private String ipAddress;
	

}
