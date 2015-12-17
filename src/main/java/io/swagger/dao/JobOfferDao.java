package io.swagger.dao;

import io.swagger.model.JobOffer;

import java.math.BigDecimal;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.*;

public class JobOfferDao {
	
	public List<JobOffer> getRestaurantJobOffers(BigDecimal restaurantId)
	{
		Query<JobOffer> jobOffers = ObjectifyService.ofy().load().type(JobOffer.class).filter("restaurantId", restaurantId.longValue());
		return jobOffers.list();
	}
	
	public JobOffer getJobOfferById(BigDecimal id)
	{
		JobOffer jobOffer = ObjectifyService.ofy().load().type(JobOffer.class).id(id.longValueExact()).now();
		return jobOffer;
	}
	
	public Key<JobOffer> saveJobOffer(JobOffer jobOffer)
	{
		Key<JobOffer> key = ObjectifyService.ofy().save().entity(jobOffer).now();
		return key;
	}
	
	public JobOffer updateJobOffer(JobOffer updatedJobOffer) {
		Key<JobOffer> key = ObjectifyService.ofy().save().entity(updatedJobOffer).now();
		JobOffer jobOffer = ObjectifyService.ofy().load().type(JobOffer.class).id(key.getId()).now();
		return jobOffer;
	}
	
	public void deleteJobOffer(BigDecimal jobOfferId)
	{
		JobOffer jobOffer = ObjectifyService.ofy().load().type(JobOffer.class).id(jobOfferId.longValueExact()).now();
		ObjectifyService.ofy().delete().entity(jobOffer).now();
	}
}