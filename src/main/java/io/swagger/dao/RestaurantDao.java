package io.swagger.dao;

import io.swagger.model.JobOffer;
import io.swagger.model.Restaurant;

import java.math.BigDecimal;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

public class RestaurantDao {
	
	public List<Restaurant> getAllRestaurants()
	{
		List<Restaurant> restaurants = ObjectifyService.ofy().load().type(Restaurant.class).list();
		return restaurants;
	}
	
	public Restaurant getRestaurantById(BigDecimal id)
	{
		Restaurant restaurant = ObjectifyService.ofy().load().type(Restaurant.class).id(id.longValueExact()).now();
		return restaurant;
	}
	
	public Key<Restaurant> saveRestaurant(Restaurant restaurant)
	{
		Key<Restaurant> key = ObjectifyService.ofy().save().entity(restaurant).now();
		return key;
	}
	
	public Restaurant updateRestaurant(Restaurant updatedRestaurant) {
		Key<Restaurant> key = ObjectifyService.ofy().save().entity(updatedRestaurant).now();
		Restaurant restaurant = ObjectifyService.ofy().load().type(Restaurant.class).id(key.getId()).now();
		return restaurant;
	}
	
	public void deleteRestaurant(BigDecimal restaurantId)
	{
		Restaurant restaurant = ObjectifyService.ofy().load().type(Restaurant.class).id(restaurantId.longValueExact()).now();
		ObjectifyService.ofy().delete().entity(restaurant).now();
		
		List<JobOffer> jobOffers = ObjectifyService.ofy().load().type(JobOffer.class).list();
		
		for (JobOffer jo : jobOffers) {
			if (jo.getRestaurantId().longValue() == restaurantId.longValue())
				ObjectifyService.ofy().delete().entity(jo).now();	
		}
		
		
	}
}
