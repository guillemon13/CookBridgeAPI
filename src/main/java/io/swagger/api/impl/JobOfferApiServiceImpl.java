package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.JobOffer;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.swagger.model.Chef;
import io.swagger.model.NewJobOffer;
import io.swagger.model.Restaurant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import io.swagger.api.NotFoundException;
import io.swagger.dao.ApplicationDao;
import io.swagger.dao.ChefDao;
import io.swagger.dao.JobOfferDao;
import io.swagger.dao.RestaurantDao;

import com.sun.jersey.core.util.Base64;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-11T13:31:24.120Z")
public class JobOfferApiServiceImpl extends JobOfferApiService {

	private static JobOfferDao jobOfferDao = new JobOfferDao();
	private SecureRandom random = new SecureRandom();
	
	@Override
	public Response getJobOffer(String token, Double size, BigDecimal restaurantId)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		List<JobOffer> jobOffers = jobOfferDao.getRestaurantJobOffers(restaurantId);
		GenericEntity<List<JobOffer>> list = new GenericEntity<List<JobOffer>>(jobOffers) {};
		
		return Response.ok(list).build();
	}

	@Override
	public Response postJobOffer(NewJobOffer newJobOffer, String token)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = new RestaurantDao().getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		JobOffer jobOffer = new JobOffer();
		
		BigInteger id = new BigInteger(130, random);
		
		jobOffer.setId(id.longValue());
		jobOffer.setJobDescription(newJobOffer.getJobDescription());
		jobOffer.setName(newJobOffer.getName());
		jobOffer.setSalary(newJobOffer.getSalary());
		jobOffer.setRestaurantId(newJobOffer.getRestaurantId());
		
		jobOfferDao.saveJobOffer(jobOffer);
		
		return Response.ok().entity(jobOffer).build();
	}

	@Override
	public Response getJobOfferById(BigDecimal jobOfferId)
			throws NotFoundException {
		
		JobOffer jobOffer = jobOfferDao.getJobOfferById(jobOfferId);
		return Response.ok().entity(jobOffer).build();
	}

	@Override
	public Response putJobOfferById(BigDecimal jobOfferId, String token, NewJobOffer newJobOffer)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = new RestaurantDao().getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		JobOffer jobOffer = new JobOffer();
		
		jobOffer.setId(jobOfferId.longValue());
		jobOffer.setJobDescription(newJobOffer.getJobDescription());
		jobOffer.setName(newJobOffer.getName());
		jobOffer.setSalary(newJobOffer.getSalary());
		jobOffer.setRestaurantId(newJobOffer.getRestaurantId());
		
		jobOfferDao.updateJobOffer(jobOffer);
			
		return Response.ok().entity(jobOffer).build();
	}

	@Override
	public Response deleteJobOfferById(BigDecimal jobOfferId, String token) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Restaurant restaurantTest = new RestaurantDao().getRestaurantById(new BigDecimal(Integer.valueOf(userPass[0])));
		if (restaurantTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!restaurantTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		jobOfferDao.deleteJobOffer(jobOfferId);
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "deleted!")).build();
	}

	@Override
	public Response applyToAJobOffer(BigDecimal jobOfferId, BigDecimal chefId, String token)
			throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		//Check if jobOffer exists
		JobOffer jobOffer = jobOfferDao.getJobOfferById(jobOfferId);
		if (jobOffer == null)
			return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "job offer not exist!")).build();
		
		Application application = new Application();
		
		BigInteger id = new BigInteger(130, random);
		
		application.setApplicationId(id.longValue());
		application.setChefId(chefId.longValue());
		application.setJobOfferId(jobOfferId.longValue());
		application.setApplicationDate(new Date(System.currentTimeMillis()));
		
		ApplicationDao applicationDao = new ApplicationDao();
		applicationDao.saveApplication(application);
		
		return Response.ok().entity(application).build();
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
