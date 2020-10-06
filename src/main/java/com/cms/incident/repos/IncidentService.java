package com.cms.incident.repos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cms.incident.controller.request.AddIncidentRequest;

@Service
public class IncidentService {
	
	private IncidentRepos repos;
	
	@Autowired
	public IncidentService(IncidentRepos repos) {
		this.repos = repos;
		
	}
	public List<IncidentModel> getAll(){
		return repos.findAll();
	}
	
	public List<IncidentModel> getAllByWs(String ws){
		return repos.findByCtxIds(ws);
	}

	public List<IIncidentModel> getIncidentSummery(String id){
		return repos.findByContextIds(id);
	}
	

	public List<IIncidentModel> getIncidentSummeryPg(String id, Integer page, Integer size){
	    Pageable paging = PageRequest.of(page, size);
		return repos.findByContextIdsPg(id, paging);
	}
	
	public Optional<IncidentModel> getByName(String name){
		return repos.findByName(name);
	}
	
	
	public 	boolean existsByName(String name) {
		return repos.existsByName(name);
	};
	
	public List<IncidentModel> getAllSecurityType(){
		return repos.findAllSecurity();
	}
	public List<IncidentModel> getAllSafetyType(){
		return repos.findAllSafety();
	}
	
	public List<IncidentModel> getAllMedicalTyoe(){
		return repos.findAllMedical();
	}
	public List<IncidentModel> getAllPublicType(){
		return repos.findAllPublic();
	}
	public List<IncidentModel> getAllTrafficType(){
		return repos.findAllTraffic();
	}
	public List<IncidentModel> getAllOthersType(){
		return repos.findAllOthers();
	}
	
	public List<IncidentModel> getAllOpenStatus(){
		return repos.findAllOpen();
	}
	public List<IncidentModel> getAllPendingStatus(){
		return repos.findAllPending();
	}
	public List<IncidentModel> getdAllClosedStatus(){
		return repos.findAllClosed();
	}
	public List<IncidentModel> getAllRejectedStatus(){
		return repos.findAllRejected();
	}
	public IncidentModel addIncident(AddIncidentRequest request) {
		
		IncidentModel incident = new IncidentModel();
		
		incident.setName(request.getName());
		
		
		incident.setType(request.getType().toString());
		
		incident.setStatus(request.getStatus().toString());
		
		incident.setOccuredAt(new Date());
			
		incident.setOrigin(request.getOrigin());
		incident.setContext(request.getContext());
		
		incident.addData("patientInfo", request.getPatientInfo());
		incident.addData("statusUpdate", request.getStatusUpdate());
		incident.addData("attachment", request.getAttachment());

		
		repos.save(incident);
		System.out.println("incident " + incident.toString());
		return incident;
	}

//	public IncidentModel createIncident(AddIncidentRequest request ) {
//	
//		IncidentModel incident = new IncidentModel();
//		
//		incident.setName(request.getName());
//		
//		
//		incident.setType(request.getType().toString());
//		
//		incident.setStatus(request.getStatus().toString());
//		
//		incident.setOccuredAt(new Date());
//			
//		incident.setOrigin(request.getOrigin());
//		
//	
//		
//		incident.setContext(request.getContext());
//		
//		repos.save(incident);
//				
//		return incident;
//	}
	
	
	public boolean deleteById(String id) {
		if(repos.findById(id) != null) {
			repos.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void cleardb() {
		repos.deleteAll();
	}

}
