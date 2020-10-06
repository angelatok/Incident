package com.cms.incident.covic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.incident.repos.IncidentModel;
import com.cms.incident.repos.IncidentRepos;

@Service
public class IncidentCovicService {
	
	private IncidentCovicRepos repos;
	
	@Autowired
	public IncidentCovicService(IncidentCovicRepos repos) {
		this.repos = repos;
		
	}
	
	public List<IncidentModel> getByPatientName(String name){
		return repos.findAllByDataPatientInfoName(name);
	}
	

}
