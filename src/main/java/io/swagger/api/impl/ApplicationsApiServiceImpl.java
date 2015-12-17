package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.Application;
import io.swagger.model.Chef;
import io.swagger.model.Restaurant;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ApplicationDao;
import io.swagger.dao.ChefDao;
import io.swagger.dao.RestaurantDao;

import javax.ws.rs.core.Response;

import com.sun.jersey.core.util.Base64;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-11T13:31:24.120Z")
public class ApplicationsApiServiceImpl extends ApplicationsApiService {

	private static ApplicationDao appDao = new ApplicationDao();
	
	@Override
	public Response getApplication(String token, Double size,
			BigDecimal jobOfferId) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = new RestaurantDao().getRestaurantById(new BigDecimal(Long.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		List<Application> applications = appDao.getApplicationsByJobOffer(jobOfferId);
		
		return Response.ok().entity(applications).build();
	}

	@Override
	public Response getApplicationById(BigDecimal applicationId, String token)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		Application application = appDao.getApplicationById(applicationId);
		return Response.ok().entity(application).build();
	}

	@Override
	public Response deleteApplicationById(BigDecimal applicationId, String token)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		appDao.deleteApplication(applicationId);
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
