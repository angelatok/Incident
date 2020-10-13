package com.cms.incident.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.incident.controller.request.AddIncidentRequest;
import com.cms.incident.repos.IncidentModel;
import com.cms.incident.repos.IncidentService;

@RestController
@RequestMapping("/incident")
public class IncidentPostController {
	private IncidentService service;
	
	@Autowired
	public IncidentPostController(IncidentService incidentService) {
		this.service = incidentService;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public IncidentModel addIncident(@Valid @RequestBody AddIncidentRequest request){

		IncidentModel model = service.addIncident(request);
		return model;
		
	}
//	@PostMapping("/create")
//	@ResponseBody
//	public IncidentModel createIncident(@Valid @RequestBody NewIncidentRequest request){
//
//		IncidentModel model = service.createIncident(request);
//		return model;
//		
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>  deleteById(@PathVariable String id)
	{
		if(service.deleteById(id)){
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		

	}
	
	

}
