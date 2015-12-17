package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Chef;
import io.swagger.model.NewChef;
import io.swagger.model.ResponsePostChef;
import java.math.BigDecimal;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public abstract class ChefsApiService {
  
      public abstract Response getChefs(String token,Double size)
      throws NotFoundException;
  
      public abstract Response postChef(NewChef newChef)
      throws NotFoundException;
  
      public abstract Response getChefById(BigDecimal chefId)
      throws NotFoundException;
  
      public abstract Response putChefById(BigDecimal chefId,String token,NewChef chef)
      throws NotFoundException;
  
      public abstract Response deleteChefById(BigDecimal chefId,String token)
      throws NotFoundException;
  
}
