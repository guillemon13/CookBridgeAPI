package io.swagger.api.factories;

import io.swagger.api.WorksApiService;
import io.swagger.api.impl.WorksApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class WorksApiServiceFactory {

   private final static WorksApiService service = new WorksApiServiceImpl();

   public static WorksApiService getWorksApi()
   {
      return service;
   }
}
