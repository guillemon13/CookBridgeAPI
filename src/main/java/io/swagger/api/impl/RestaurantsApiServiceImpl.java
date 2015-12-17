package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Chef;
import io.swagger.model.Restaurant;
import io.swagger.model.NewRestaurant;
import io.swagger.model.ResponsePostRestaurant;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ChefDao;
import io.swagger.dao.RestaurantDao;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.core.util.Base64;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-11T13:31:24.120Z")
public class RestaurantsApiServiceImpl extends RestaurantsApiService {

	private static RestaurantDao restDao = new RestaurantDao();
	private SecureRandom random = new SecureRandom();
	
	@Override
	public Response getRestaurants(String token, Double size) throws NotFoundException {
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = restDao.getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		List<Restaurant> restaurants = restDao.getAllRestaurants();
		GenericEntity<List<Restaurant>> list = new GenericEntity<List<Restaurant>>(restaurants) {};
		
		return Response.ok(list).build();
	}

	@Override
	public Response postRestaurant(NewRestaurant newRestaurant)
			throws NotFoundException {
		Restaurant restaurant = new Restaurant();
		
		BigInteger id = new BigInteger(130, random);
		
		restaurant.setId(id.longValue());
		
		restaurant.setAddress(newRestaurant.getAddress());
		restaurant.setPassword(cryptWithMD5(newRestaurant.getPassword()));
		restaurant.setName(newRestaurant.getName());
		restaurant.setCity(newRestaurant.getCity());
		restaurant.setWebsite(newRestaurant.getWebsite());
		
		restDao.saveRestaurant(restaurant);
		return Response.ok().entity(restaurant).build();
	}

	@Override
	public Response getRestaurantById(BigDecimal restaurantId)
			throws NotFoundException {
		Restaurant restaurant = restDao.getRestaurantById(restaurantId);
		return Response.ok().entity(restaurant).build();
	}

	@Override
	public Response putRestaurantById(BigDecimal restaurantId, String token, 
			NewRestaurant newRestaurant) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = restDao.getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(restaurantId.longValue());
		restaurant.setPassword(cryptWithMD5(newRestaurant.getPassword()));
		restaurant.setAddress(newRestaurant.getAddress());
		restaurant.setName(newRestaurant.getName());
		restaurant.setCity(newRestaurant.getCity());
		restaurant.setWebsite(newRestaurant.getWebsite());

		restDao.updateRestaurant(restaurant);
		return Response.ok().entity(restaurant).build();
	}

	@Override
	public Response deleteRestaurantById(BigDecimal restaurantId, String token) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurant = restDao.getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurant == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurant.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		restDao.deleteRestaurant(restaurantId);
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "deleted!")).build();
	}
	
	//For password?
	private String cryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
		}

		return null;
	}
	
	private String[] getUsernameAndPassword(String secret) {
		String[] result = null;
		if (secret != null && secret.toUpperCase().startsWith("BASIC ")) {
			try {
				result = Base64.base64Decode(secret.substring(6)).split(":");
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		
		return result;
	}

}
