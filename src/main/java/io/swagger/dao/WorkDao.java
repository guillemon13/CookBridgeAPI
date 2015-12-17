package io.swagger.dao;

import io.swagger.model.Work;

import java.math.BigDecimal;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;

public class WorkDao {
	
	public List<Work> getWorkByChefAndRestaurant(BigDecimal chefId, BigDecimal restaurantId) {
		Filter chefIdFilter = new FilterPredicate("chefId", FilterOperator.EQUAL, chefId);
		Filter restaurantIdFilter = new FilterPredicate("restaurantId", FilterOperator.EQUAL, restaurantId);
				 
	    Filter compoFilter = CompositeFilterOperator.and(chefIdFilter, restaurantIdFilter);
	    
		List<Work> work = ObjectifyService.ofy().load().type(Work.class).filter(compoFilter).list();
		return work;
	}
	
	public Work getWorkById(BigDecimal id)
	{
		Work work = ObjectifyService.ofy().load().type(Work.class).id(id.longValueExact()).now();
		return work;
	}
	
	public Key<Work> saveWork(Work work)
	{
		Key<Work> key = ObjectifyService.ofy().save().entity(work).now();
		return key;
	}
	
	public Work updateWork(Work updatedWork) {
		Key<Work> key = ObjectifyService.ofy().save().entity(updatedWork).now();
		Work work = ObjectifyService.ofy().load().type(Work.class).id(key.getId()).now();
		return work;
	}
	
	public void deleteWork(BigDecimal workId)
	{
		Work work = ObjectifyService.ofy().load().type(Work.class).id(workId.longValueExact()).now();
		ObjectifyService.ofy().delete().entity(work).now();
	}
}
