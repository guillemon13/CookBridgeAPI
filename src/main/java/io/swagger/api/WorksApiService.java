package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Work;
import java.math.BigDecimal;
import io.swagger.model.NewWork;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public abstract class WorksApiService {
  
      public abstract Response getWorks(String token,Double size,BigDecimal restaurantId,BigDecimal chefId)
      throws NotFoundException;
  
      public abstract Response postWorks(NewWork newWork,String token)
      throws NotFoundException;
  
      public abstract Response getWorksById(BigDecimal workId,String token)
      throws NotFoundException;
  
      public abstract Response putWorksById(BigDecimal workId,String token,NewWork work)
      throws NotFoundException;
  
      public abstract Response deleteWorksById(BigDecimal workId,String token)
      throws NotFoundException;
  
}
