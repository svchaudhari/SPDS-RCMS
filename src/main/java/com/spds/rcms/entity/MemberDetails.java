package com.spds.rcms.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 *@author prakash
 *This class was creaded on 30-Dec-2024.
 */
@Data
@Entity
@Table(schema = "rcms", name = "member_details")
@NoArgsConstructor
public class MemberDetails extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -25365148147119768L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_details_seq_id")
	@SequenceGenerator(name = "personal_details_seq_id", sequenceName = "personal_details_seq_id", schema = "rcms", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "full_name_en",length = 60)
	private String fullNameEn;
	
	@Column(name = "full_name_ll",length = 254)
	private String fullNamell;

	@Column(name = "dob",length = 255)
	private Date dob;

	@Column(name = "age",length = 20)
	private Integer age;
	
	@Column(name = "gender_id",length = 100)
	private Long genderId;
	
	@Column(name = "mother_name_en",length = 255)
	private String motherNameEn;
	
	@Column(name = "mother_name_ll",length = 255)
	private String motherNameLl;

	@Column(name = "father_name_en",length = 20)
	private String fatherNameEn;
	
	@Column(name = "father_name_ll",length = 20)
	private String fatherNameLl;
	
	@Column(name = "marital_status_id",length = 100)
	private Long maritalStatusId;
	
	@Column(name = "spouse_name_en ",length = 255)
	private String spouseNameEn;
	
	@Column(name = "spouse_name_ll ",length = 255)
	private String spouseNameLl;

	@Column(name = "mobile_number",length = 20)
	private String mobileNumber;
	
	@Column(name = "relationship_id",length = 20)
	private Long relationshipId;
	
	@Column(name = "email_id",length = 255)
	private String emailId;

	@Column(name = "nationality",length = 20)
	private Long nationality;
	
	@Column(name = "photograph",length = 100)
	private Long photograph;
	
	@Column(name = "scheme_id",length = 20)
	private Long schemeId   ;
	
	@Column(name = "group_id",length = 20)
	private Long groupId;
	
	@Column(name = "is_hof")
	private Boolean isHof;
	
	@Column(name = "uid_reference_number",length = 20)
	private String uidReferenceNumber;
	
	@Column(name = "epic_number",length = 20)
	private String epicNumber;
	
	@Column(name = "ration_lifting_eligibility")
	private String rationLiftingEligibility;
	
	@Column(name = "occupation",length = 60)
	private String occupation;

	@Column(name = "total_annual_income",length = 255)
	private Double totalAnnualIncome;
	
	@Column(name = "income_certificate_id",length = 100)
	private String incomeCertificateId;
	
	@Column(name = "family_total_annual_income",length = 255)
	private Double familyTotalAnnualIncome;
	
	@Column(name = "do_you_have_any_disability",length = 20)
	private Boolean doYouHaveAnyDisability;
	
	@Column(name = "disability_id",length = 255)
	private Long disabilityId;
	
	@Column(name = "disability_type",length = 255)
	private String disabilityType;

	@Column(name = "disability_percentage",length = 20)
	private Double disabilityPercentage;
	
	@Column(name = "disability_since",length = 100)
	private String disabilitySince;
	
	@Column(name = "disability_since_year",length = 255)
	private String disabilitySinceYear;

	@Column(name = "upload_certificate_of_disability",length = 20)
	private String uploadCertificateOfDisability;
	
	@Column(name = "rc_id",length = 100)
	private Long rcId;
	
	@JsonIgnore
	@Column(name = "ip_address",length = 20)
	private String ipAddress;
	
}
