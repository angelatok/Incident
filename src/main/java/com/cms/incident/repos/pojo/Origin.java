package com.cms.incident.repos.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Origin {
	@NotNull	
	@NonNull
	private String from;
	private String id;
	private String deviceID;
	private String updatedAt;

}
