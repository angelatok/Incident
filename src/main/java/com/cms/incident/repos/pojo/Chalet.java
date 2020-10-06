package com.cms.incident.repos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chalet {
	private String casualty;
	private String hazard;
	private String access;
	private String emergencyService;
	private String salute;

}
