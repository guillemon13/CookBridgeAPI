package io.swagger.api;

import io.swagger.api.ApplicationsApiService;
import io.swagger.api.factories.ApplicationsApiServiceFactory;
import io.swagger.annotations.ApiParam;

import io.swagger.model.Application;

import java.math.BigDecimal;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/applications")


@io.swagger.annotations.Api(description = "the applications API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class ApplicationsApi  {
   private final ApplicationsApiService delegate = ApplicationsApiServiceFactory.getApplicationsApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `application` objects.\nOptional query param of **size** determines size of returned array.\nOptional query param of **jobOfferId**.", response = Application.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Application.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No content", response = Application.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Application.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Application.class, responseContainer = "List") })

    public Response getApplication(@ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "Size of array") @QueryParam("size") Double size,
    @ApiParam(value = "id of jobOffer") @QueryParam("jobOfferId") BigDecimal jobOfferId)
    throws NotFoundException {
        return delegate.getApplication(token,size,jobOfferId);
    }
    @GET
    @Path("/{applicationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `application` object.", response = Application.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Application.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Application.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Application not found", response = Application.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Application.class) })

    public Response getApplicationById(@ApiParam(value = "id of the application",required=true) @PathParam("applicationId") BigDecimal applicationId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.getApplicationById(applicationId,token);
    }
    @DELETE
    @Path("/{applicationId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes one application", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Application deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Application not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Void.class) })

    public Response deleteApplicationById(@ApiParam(value = "id of the job application",required=true) @PathParam("applicationId") BigDecimal applicationId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.deleteApplicationById(applicationId,token);
    }
}

