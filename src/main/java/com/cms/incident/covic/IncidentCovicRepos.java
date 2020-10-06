package com.cms.incident.covic;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cms.incident.repos.IncidentModel;

public interface IncidentCovicRepos extends MongoRepository<IncidentModel, String> {
	
	
	@Query(value = "{'data.patientInfo.name' : ?0}")
	List<IncidentModel> findAllByDataPatientInfoName(String name);
	

}
