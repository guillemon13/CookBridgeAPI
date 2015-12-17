package io.swagger.api.factories;

import io.swagger.api.JobOfferApiService;
import io.swagger.api.impl.JobOfferApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class JobOfferApiServiceFactory {

   private final static JobOfferApiService service = new JobOfferApiServiceImpl();

   public static JobOfferApiService getJobOfferApi()
   {
      return service;
   }
}
