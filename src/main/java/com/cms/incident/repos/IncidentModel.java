package com.cms.incident.repos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cms.incident.repos.pojo.Chalet;
import com.cms.incident.repos.pojo.Context;
import com.cms.incident.repos.pojo.Location;
import com.cms.incident.repos.pojo.Origin;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "incident")
public class IncidentModel {
	@Id
	private String id;

	@NotNull // validation
	@NonNull //lombok
	private String name;

	@NotNull
	@NonNull
	private String type; 

	@NotNull
	@NonNull
	private String status; 

	
	private String description;

	private Date openAt;
	private Date closeAt;
	private Date rejectedAt;
	
	private String[] actionParty;
	private String manager;
	private Location location;

	private Chalet template;
	private String reportedBy;

	private Context context;
	private Date pendingAt;
	
	@NotNull
	@NonNull
	private Date occuredAt; // Date.now 
	
	private Origin origin;
	
	private String createdBy; // createInfo in outreach?
	private String updatedBy; // updateInfo in outreach?


	
    private Map<String, Object> data;

	
    @JsonAnySetter
    public void addData(String key, Object value) {
        if (null == data) {
        	data = new HashMap<>();
        }
        data.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }
	
	
	

}
