package io.swagger.api.factories;

import io.swagger.api.RestaurantsApiService;
import io.swagger.api.impl.RestaurantsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class RestaurantsApiServiceFactory {

   private final static RestaurantsApiService service = new RestaurantsApiServiceImpl();

   public static RestaurantsApiService getRestaurantsApi()
   {
      return service;
   }
}
