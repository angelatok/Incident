package com.cms.incident;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cms.incident.controller.request.AddIncidentRequest;
import com.cms.incident.controller.request.util.EStatus;
import com.cms.incident.controller.request.util.EType;
import com.cms.incident.repos.IncidentService;
import com.cms.incident.repos.pojo.Context;
import com.cms.incident.repos.pojo.Origin;

@Component
public class MyCommandLineRunner  implements CommandLineRunner{

	@Autowired
	IncidentService dao;
    Random random ;

	@Override
	public void run(String... args) throws Exception {
	     random = new Random();
System.out.println("command line runner !!");
		dao.cleardb();
		buildIncidents();
		
	}
	public void buildIncidents() {
		for(int i = 0; i < 100; i++) {
			dao.addIncident(createBaseIncident());
		}

		AddIncidentRequest b = createBaseIncident();
		b.setType(EType.SAFETY);
		b.setStatus(EStatus.CLOSED);
		dao.addIncident(b);
		
		AddIncidentRequest c = createBaseIncident();
		c.setType(EType.SECURITY);
		c.setStatus(EStatus.PENDING);
		dao.addIncident(c);
		
		AddIncidentRequest d = createBaseIncident();
		d.setType(EType.TRAFFIC);
		d.setStatus(EStatus.REJECTED);
		dao.addIncident(d);
		
	}
	public AddIncidentRequest createBaseIncident() {
		String rString = randomString(4);
		
		AddIncidentRequest request = new AddIncidentRequest();
		
		request.setName(rString);
		request.setType(EType.MEDICAL);
		request.setStatus(EStatus.OPEN);
		request.setOccuredAt(new Date());
		
		//TODO move to commandline runner
		String[] contextId = {"default", rString, randomString(4), randomString(4), randomString(4), "default"};
		Context ctx = new Context(rString, rString);
		ctx.setIds(contextId);
		
		request.setContext(ctx);
		
		Origin origin = new Origin();
		origin.setDeviceID(rString);
		origin.setFrom(rString);
		origin.setId(rString);
		origin.setUpdatedAt(new Date().toString());
		request.setOrigin(origin);
		
		
		return request;
		
	}

	public String randomString(int targetStringLength) {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	  //  System.out.println(generatedString);

	    return generatedString;
	}
}
