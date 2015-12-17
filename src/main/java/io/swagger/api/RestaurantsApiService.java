package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Restaurant;
import io.swagger.model.NewRestaurant;
import io.swagger.model.ResponsePostRestaurant;
import java.math.BigDecimal;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public abstract class RestaurantsApiService {
  
      public abstract Response getRestaurants(String token,Double size)
      throws NotFoundException;
  
      public abstract Response postRestaurant(NewRestaurant newRestaurant)
      throws NotFoundException;
  
      public abstract Response getRestaurantById(BigDecimal restaurantId)
      throws NotFoundException;
  
      public abstract Response putRestaurantById(BigDecimal restaurantId,String token,NewRestaurant chef)
      throws NotFoundException;
  
      public abstract Response deleteRestaurantById(BigDecimal restaurantId,String token)
      throws NotFoundException;
  
}
