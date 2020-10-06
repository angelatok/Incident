package com.cms.incident.repos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	private String name;
	private String description;
	private int latInDegrees;
	private int lonInDegrees;
	private String graphicId;

}
