package com.cms.incident.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.incident.audit.ResourceNotFoundException;
import com.cms.incident.repos.IIncidentModel;
import com.cms.incident.repos.IncidentModel;
import com.cms.incident.repos.IncidentService;

@RestController
@RequestMapping("/incident")
public class IncidentGetController {
	private IncidentService service;
	
	
	@Autowired
	public IncidentGetController(IncidentService incidentService) {
		this.service = incidentService;
	}
	@GetMapping
	public List<IncidentModel> getAll(){
		return service.getAll();
	}
	/**
	 * This should return list of incident in a workspace.
	 * if user does not project workspace detail, only incident that is pubilc is return.
	 * 
	 * @return
	 */
	@GetMapping("/wsid/{wsid}")
	public List<IncidentModel> getAll(@PathVariable("wsid") String workspaceId){
		//TODO  assuming cxtOrigin is the workspace he is currently login
		return service.getAllByWs(workspaceId);
	}
	
	@GetMapping("/shortList/{wsid}")
	public List<IIncidentModel> getSummeryAll(@PathVariable("wsid") String workspaceId){
		return service.getIncidentSummery(workspaceId);
	}
	
	@GetMapping("/page")
	public List<IIncidentModel> getSummeryPage(
			@RequestParam(value="pgnum", required = false) Integer page,
			@RequestParam(value="pgsize", required = false) Integer size,
			@RequestParam(value="wsid") String id){
		return service.getIncidentSummeryPg(id, page, size);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<IncidentModel> getName(@PathVariable("name") String name){
		
		IncidentModel model = service.getByName(name).orElseThrow(() ->
		new ResourceNotFoundException("Not found with name = " + name));
		
	    return new ResponseEntity<>(model, HttpStatus.OK);

// Solution 2	this does not return a json error    
//		if(service.existsByName(name)){
//			Optional<IncidentShort> result = service.getByName(name);
//			return ResponseEntity.accepted().body(result.get());
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
	}
	
	
	
	@GetMapping("/name/{name}")
	public IncidentModel getMyName(@PathVariable("name") String name){
		
			Optional<IncidentModel> result = service.getByName(name);
			IncidentModel m = result.get();
			return m;
	}
	
	@GetMapping("/security")
	public List<IncidentModel> getAllSecurityType(){
		return service.getAllSecurityType();
	}
	
	@GetMapping("/safety")
	public List<IncidentModel> getAllSafetyType(){
		return service.getAllSafetyType();
	}
	
	@GetMapping("/medical")
	public List<IncidentModel> getAllMedicalType(){
		return service.getAllMedicalTyoe();
	}
	@GetMapping("/public")
	public List<IncidentModel> getAllPublicType(){
		return service.getAllPublicType();
	}
	@GetMapping("/traffic")
	public List<IncidentModel> getAllTrafficType(){
		return service.getAllTrafficType();
	}
	@GetMapping("/others")
	public List<IncidentModel> getAllOthersype(){
		return service.getAllOthersType();
	}
	@GetMapping("/open")
	public List<IncidentModel> getAllOpenStatus(){
		return service.getAllOpenStatus();
	}
	@GetMapping("/pending")
	public List<IncidentModel> getAllPendingStatus(){
		return service.getAllPendingStatus();
	}
	@GetMapping("/closed")
	public List<IncidentModel> getAllCloseStatus(){
		return service.getdAllClosedStatus();
	}
	@GetMapping("/rejected")
	public List<IncidentModel> getAllRejectedStatus(){
		return service.getAllRejectedStatus();
	}	

}
