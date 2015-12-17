package io.swagger.dao;

import java.math.BigDecimal;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import io.swagger.model.Chef;

public class ChefDao {

	private static DataFactory dataFactory = DataFactory.create();
	
	public List<Chef> getAllChefs()
	{
		List<Chef> chefs = ObjectifyService.ofy().load().type(Chef.class).list();
		return chefs;
	}
	
	public Chef getChefById(BigDecimal id)
	{
		Chef chef = ObjectifyService.ofy().load().type(Chef.class).id(id.longValueExact()).now();
		return chef;
	}
	
	public Key<Chef> saveChef(Chef chef)
	{
		Key<Chef> key = ObjectifyService.ofy().save().entity(chef).now();
		return key;
	}
	
	public Chef updateItem(Chef updatedChef) {
		Key<Chef> key = ObjectifyService.ofy().save().entity(updatedChef).now();
		Chef chef = ObjectifyService.ofy().load().type(Chef.class).id(key.getId()).now();
		return chef;
	}
	
	public void deleteChef(BigDecimal chefId)
	{
		Chef chef = ObjectifyService.ofy().load().type(Chef.class).id(chefId.longValueExact()).now();
		ObjectifyService.ofy().delete().entity(chef).now();
	}
	
	public Chef getDummyChef()
	{
		Chef chef = new Chef();
		chef.setBirthDate(dataFactory.getBirthDate());
		chef.setGender("Male");
		chef.setName(dataFactory.getName());
		chef.setId(123123l);
		
		return chef;
	}
}
