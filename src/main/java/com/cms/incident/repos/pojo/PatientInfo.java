package com.cms.incident.repos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfo {
	
	private String patientId;
	private String name;
	private String bed;
	private String status;
	private String movement;
	private String swabOne;
	private String swabTwo;
	

}
