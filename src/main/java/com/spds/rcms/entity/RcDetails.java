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

@Data
@Entity
@Table(schema = "rcms", name = "rc_details")
@NoArgsConstructor
public class RcDetails extends Auditable implements Serializable{

	private static final long serialVersionUID = -25365148147119768L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rc_details_seq_id")
	@SequenceGenerator(name = "rc_details_seq_id", sequenceName = "rc_details_seq_id", schema = "rcms", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "existing_rc_number",length = 20)
	private String existingRcNumber;
	
	@Column(name = "rc_number",length = 20)
	private String rcNumber;
	
	@JsonIgnore
	@Column(name = "ip_address",length = 20)
	private String ipAddress;
	
	@Column(name = "status",length = 20)
	private String status="DRAFT";
	
	@Column(name = "nationality",length = 20)
	private Long nationality;
	
    @Column(name = "scheme_id",length = 20)
	private Long schemeId;
	
	@Column(name = "fps_id",length = 20)
	private Long fpsId;
	
	@Column(name = "full_name_en",length = 60)
	private String fullNameEn;
	
	@Column(name = "full_name_ll",length = 254)
	private String fullNameLl;
	
	@Column(name = "spouse_name_en ",length = 255)
	private String spouseNameEn;
	
	@Column(name = "spouse_name_ll ",length = 255)
	private String spouseNameLl;
	
	@Column(name = "mother_name_en",length = 255)
	private String motherNameEn;
	
	@Column(name = "mother_name_ll",length = 255)
	private String motherNameLl;

	@Column(name = "father_name_en",length = 20)
	private String fatherNameEn;
	
	@Column(name = "father_name_ll",length = 20)
	private String fatherNameLl;
	
	@Column(name = "gender_id",length = 100)
	private Long genderId;
	
	@Column(name = "mobile_number",length = 20)
	private String mobileNumber;

	@Column(name = "dob",length = 255)
	private Date dob;

	@Column(name = "age",length = 20)
	private Integer age;
	
	@Column(name = "email_id",length = 255)
	private String emailId;

	@Column(name = "marital_status_id",length = 100)
	private Long maritalStatusId;
}