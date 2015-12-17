package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Application;
import java.math.BigDecimal;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public abstract class ApplicationsApiService {
  
      public abstract Response getApplication(String token,Double size,BigDecimal jobOfferId)
      throws NotFoundException;
  
      public abstract Response getApplicationById(BigDecimal applicationId,String token)
      throws NotFoundException;
  
      public abstract Response deleteApplicationById(BigDecimal applicationId,String token)
      throws NotFoundException;
  
}
