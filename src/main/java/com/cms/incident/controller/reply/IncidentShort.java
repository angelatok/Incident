package com.cms.incident.controller.reply;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cms.incident.controller.request.util.EStatus;
import com.cms.incident.controller.request.util.EType;
import com.cms.incident.repos.pojo.Chalet;
import com.cms.incident.repos.pojo.Context;
import com.cms.incident.repos.pojo.Location;
import com.cms.incident.repos.pojo.Origin;
import com.cms.incident.repos.pojo.PatientInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IncidentShort {

	private String name;
	private EStatus status; 
	private EType type; 
	private Date occuredAt; // Date.now 
	private String reportedBy;
	private String createdBy; // createInfo in outreach?
	private String description;


	

	private Date openAt;
	private Date closeAt;
	private Date rejectedAt;
	
	private String[] actionParty; // not seen in UI
	private String manager;
	private Location location;

	private Chalet template;

	private Context context;
	private Date pendingAt;
	
	
	
	private Origin origin;
	
	private String updatedBy; // updateInfo in outreach?


	
	private PatientInfo patientInfo;
	private String statusUpdate;
	private String attachment;
   
	
	
	

}
