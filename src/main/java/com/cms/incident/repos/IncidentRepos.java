package com.cms.incident.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IncidentRepos extends MongoRepository<IncidentModel, String> {
	
	@Query(value="{'type': 'SECURITY'}")
	List<IncidentModel> findAllSecurity();
	@Query(value="{'type': 'SAFETY'}")
	List<IncidentModel> findAllSafety();
	@Query(value="{'type': 'MEDICAL'}")
	List<IncidentModel> findAllMedical();
	@Query(value="{'type': 'PUBLIC'}")
	List<IncidentModel> findAllPublic();
	@Query(value="{'type': 'TRAFFIC'}")
	List<IncidentModel> findAllTraffic();
	@Query(value="{'type': 'OTHERS'}")
	List<IncidentModel> findAllOthers();
	
	@Query(value="{'status': 'OPEN'}")
	List<IncidentModel> findAllOpen();	
	@Query(value="{'status': 'PENDING'}")
	List<IncidentModel> findAllPending();
	@Query(value="{'status': 'CLOSED'}")
	List<IncidentModel> findAllClosed();	
	@Query(value="{'status': 'REJECTED'}")
	List<IncidentModel> findAllRejected();
	

	Optional<IncidentModel> findByName(String name);
	
	@Query("{'context.ids': ?0}")
	List<IncidentModel> findByCtxIds(String ctxIds);

    List<IIncidentModel> findByContextIds(String lastName);
	
    @Query("{'context.ids': ?0}")
    List<IIncidentModel> findByContextIdsPg(String lastName, Pageable pageable);


	
	boolean existsByName(String name);

}
