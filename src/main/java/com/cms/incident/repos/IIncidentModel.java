package com.cms.incident.repos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.cms.incident.repos.pojo.Context;

public interface IIncidentModel {

	String getId();
	String getName();
	String getType();
	String getStatus();
	String getDescription();
	String getUpdatedBy();
	Date getOccuredAt();

    @Value("#{target.context}")
    Context getContext();}
