package io.swagger.dao;

import io.swagger.model.Application;
import io.swagger.model.JobOffer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.*;
import com.googlecode.objectify.cmd.*;

public class ApplicationDao {
	
	public List<Application> getApplicationsByJobOffer (BigDecimal jobOfferId) {
		
		List<Application> applications  = ObjectifyService.ofy().load().type(Application.class).list();
		
		if (jobOfferId == null) {
			return applications;
		} else {
			List<Application> result = new ArrayList<Application>();
			
			for (Application app : applications) {
				if (app.getJobOfferId().longValue() == jobOfferId.longValue()) 
					result.add(app);
			}
			
			return result;
		}
		
	}
	
	public Key<Application> saveApplication(Application application) {
		Key<Application> key = ObjectifyService.ofy().save().entity(application).now();
		
		return key;
	}
	
	public Application getApplicationById(BigDecimal id)
	{
		Application application = ObjectifyService.ofy().load().type(Application.class).id(id.longValueExact()).now();
		return application;
	}
	
	public void deleteApplication(BigDecimal applicationId)
	{
		Application application = ObjectifyService.ofy().load().type(Application.class).id(applicationId.longValueExact()).now();
		ObjectifyService.ofy().delete().entity(application).now();
	}


	
}
