package io.swagger.api.factories;

import io.swagger.api.ChefsApiService;
import io.swagger.api.impl.ChefsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class ChefsApiServiceFactory {

   private final static ChefsApiService service = new ChefsApiServiceImpl();

   public static ChefsApiService getChefsApi()
   {
      return service;
   }
}
