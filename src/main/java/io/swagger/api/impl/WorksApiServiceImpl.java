package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.swagger.model.NewWork;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import io.swagger.api.NotFoundException;
import io.swagger.dao.ChefDao;
import io.swagger.dao.WorkDao;

import com.sun.jersey.core.util.Base64;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-11T13:31:24.120Z")
public class WorksApiServiceImpl extends WorksApiService {

	private static WorkDao workDao = new WorkDao();
	private SecureRandom random = new SecureRandom();
	
	@Override
	public Response getWorks(String token, Double size, BigDecimal restaurantId,
			BigDecimal chefId) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		List<Work> works = workDao.getWorkByChefAndRestaurant(chefId, restaurantId);
		GenericEntity<List<Work>> list = new GenericEntity<List<Work>>(works) {};
		
		return Response.ok(list).build();
	}

	@Override
	public Response postWorks(NewWork newWork, String token) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		Work work = new Work();
		
		BigInteger id = new BigInteger(130, random);
		work.setId(id.longValue());
		
		work.setChefId(newWork.getChefId());
		work.setRestaurantId(newWork.getRestaurantId());
		work.setPosition(newWork.getPosition());
		work.setBeginDate(newWork.getBeginDate());
		work.setEndDate(newWork.getEndDate());
		
		workDao.saveWork(work);
		return Response.ok().entity(work).build();
	}

	@Override
	public Response getWorksById(BigDecimal workId, String token) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		Work work = workDao.getWorkById(workId);
		return Response.ok().entity(work).build();
	}

	@Override
	public Response putWorksById(BigDecimal workId, String token, NewWork newWork) throws NotFoundException {
		
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		Work work = new Work();
		
		work.setId(workId.longValue());
		work.setChefId(newWork.getChefId());
		work.setRestaurantId(newWork.getRestaurantId());
		work.setPosition(newWork.getPosition());
		work.setBeginDate(newWork.getBeginDate());
		work.setEndDate(newWork.getEndDate());
		
		workDao.updateWork(work);
		return Response.ok().entity(work).build();
	}

	@Override
	public Response deleteWorksById (BigDecimal workId, String token) throws NotFoundException {
	
		//Auth test
		String[] userPass = getUsernameAndPassword(token);
		
		Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
		if (chefTest == null) 
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
			return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
		
		workDao.deleteWork(workId);
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
