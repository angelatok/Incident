package com.cms.incident.covic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.incident.repos.IncidentModel;

@RestController
@RequestMapping("/incident")
public class IncidentCovicGetController {
	private IncidentCovicService patientService;
	
	
	@Autowired
	public IncidentCovicGetController(IncidentCovicService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping("/patient/{name}")
	public List<IncidentModel> getPatientName(@PathVariable("name") String name){
		
			List<IncidentModel> result = patientService.getByPatientName(name);
			return result;
	}
	
}
