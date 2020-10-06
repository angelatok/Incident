package com.cms.incident.repos.pojo;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Context {
	@NotNull	
	@NonNull
	private String type;
	@NotNull	
	@NonNull
	private String origin;
	
	private String[] ids;

}
