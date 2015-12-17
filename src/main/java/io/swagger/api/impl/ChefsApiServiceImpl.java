package io.swagger.api.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.util.Base64;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.ChefsApiService;
import io.swagger.api.NotFoundException;
import io.swagger.dao.ChefDao;
import io.swagger.model.Chef;
import io.swagger.model.NewChef;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-11T13:31:24.120Z")
public class ChefsApiServiceImpl extends ChefsApiService {

	private static ChefDao chefDao = new ChefDao();
	private SecureRandom random = new SecureRandom();
	
	@Override
	public Response getChefs(String token, Double size) throws NotFoundException {
		try {
			List<Chef> chefs = chefDao.getAllChefs();
			GenericEntity<List<Chef>> list = new GenericEntity<List<Chef>>(chefs) {};
			
			if (size != null) {
				chefs.subList(0, Integer.valueOf(size.toString()));
				list = new GenericEntity<List<Chef>>(chefs) {};
			}
			
			return Response.ok(list).build();
		} catch (NullPointerException npe) {
			return Response.status(501).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, " PARAMETER MISSING!")).build();
		}
	}

	@Override
	public Response postChef(NewChef newChef) throws NotFoundException {
		try {
			ChefDao chefDao = new ChefDao();
			Chef chef = new Chef();
			
			BigInteger id = new BigInteger(130, random);
			
			chef.setId(id.longValue());
			chef.setPassword(cryptWithMD5(newChef.getPassword()));
			chef.setBirthDate(newChef.getBirthDate());
			chef.setName(newChef.getName());
			chef.setGender(newChef.getGender());
	
			//Post entity sent by parameter. It is free for everyone.
			chefDao.saveChef(chef);
			
			return Response.ok().entity(chef).build();
		} catch (NullPointerException npe) {
			return Response.status(501).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, " PARAMETER MISSING!")).build();
		}
	}

	@Override
	public Response getChefById(BigDecimal chefId) throws NotFoundException {
		try {
			Chef chef = new ChefDao().getChefById(chefId);
			return Response.ok().entity(chef).build();
		} catch (NullPointerException npe) {
			return Response.status(501).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, " PARAMETER MISSING!")).build();
		}
	}

	@Override
	public Response putChefById(BigDecimal chefId, String token, NewChef newChef) {
		try {
			//Auth test
			String[] userPass = getUsernameAndPassword(token);
			
			Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
			if (chefTest == null) 
				return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
			else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
				return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
			
			ChefDao chefDao = new ChefDao();
			Chef chef = new Chef();
			chef.setId(chefId.longValue());
			chef.setPassword(cryptWithMD5(newChef.getPassword()));
			chef.setBirthDate(newChef.getBirthDate());
			chef.setName(newChef.getName());
			chef.setGender(newChef.getGender());
	
			//Only the owner can update its own data.
			chefDao.updateItem(chef);
			return Response.ok().entity(chef).build();
			
		} catch (NullPointerException npe) {
			return Response.status(501).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, " PARAMETER MISSING!")).build();
		}
	}

	@Override
	public Response deleteChefById(BigDecimal chefId, String token) throws NotFoundException {
		try {
			//Auth test
			String[] userPass = getUsernameAndPassword(token);
			
			Chef chefTest = new ChefDao().getChefById(new BigDecimal(Long.valueOf(userPass[0])));
			if (chefTest == null) 
				return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
			else if (!chefTest.getPassword().equals(cryptWithMD5(userPass[1])))
				return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "unauthorized!")).build();
			
			//Only the owner can delete its own data.
			chefDao.deleteChef(chefId);
			return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "deleted!")).build();
			
		} catch (NullPointerException npe) {
			return Response.status(501).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, " PARAMETER MISSING!")).build();
		}
	}
	
	//Encrypt password for security
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
