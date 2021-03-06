package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.JobOffer;
import java.math.BigDecimal;
import io.swagger.model.NewJobOffer;
import io.swagger.model.Work;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public abstract class JobOfferApiService {
  
      public abstract Response getJobOffer(String token,Double size,BigDecimal restaurantId)
      throws NotFoundException;
  
      public abstract Response postJobOffer(NewJobOffer newJobOffer,String token)
      throws NotFoundException;
  
      public abstract Response getJobOfferById(BigDecimal jobOfferId)
      throws NotFoundException;
  
      public abstract Response putJobOfferById(BigDecimal jobOfferId,String token,NewJobOffer jobOffer)
      throws NotFoundException;
  
      public abstract Response deleteJobOfferById(BigDecimal jobOfferId,String token)
      throws NotFoundException;
  
      public abstract Response applyToAJobOffer(BigDecimal jobOfferId,BigDecimal chefId,String token)
      throws NotFoundException;
  
}
