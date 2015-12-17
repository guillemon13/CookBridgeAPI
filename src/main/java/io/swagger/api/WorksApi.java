package io.swagger.api;

import io.swagger.api.WorksApiService;
import io.swagger.api.factories.WorksApiServiceFactory;
import io.swagger.annotations.ApiParam;

import io.swagger.model.Work;

import java.math.BigDecimal;

import io.swagger.model.NewWork;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/works")


@io.swagger.annotations.Api(description = "the works API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class WorksApi  {
   private final WorksApiService delegate = WorksApiServiceFactory.getWorksApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `work` objects.\nOptional query param of **size** determines size of returned array.\nOptional query param of **restaurantId** specifies the restaurant.\nOptional query param of **chefId** specifies the chef.", response = Work.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Work.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No content", response = Work.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Work.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Work.class, responseContainer = "List") })

    public Response getWorks(@ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "Size of array") @QueryParam("size") Double size,
    @ApiParam(value = "id of restaurant") @QueryParam("restaurantId") BigDecimal restaurantId,
    @ApiParam(value = "id of chef") @QueryParam("chefId") BigDecimal chefId)
    throws NotFoundException {
        return delegate.getWorks(token,size,restaurantId,chefId);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new work", response = Long.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Work created", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Long.class) })

    public Response postWorks(@ApiParam(value = "new work" ,required=true) NewWork newWork,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.postWorks(newWork,token);
    }
    @GET
    @Path("/{workId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `work` object.", response = Work.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Work not found", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Work.class) })

    public Response getWorksById(@ApiParam(value = "id of the work",required=true) @PathParam("workId") BigDecimal workId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.getWorksById(workId,token);
    }
    @PUT
    @Path("/{workId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Updates a work with his id", response = Work.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Work not found", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Work.class) })

    public Response putWorksById(@ApiParam(value = "id of the work",required=true) @PathParam("workId") BigDecimal workId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "work with new information" ) NewWork work)
    throws NotFoundException {
        return delegate.putWorksById(workId,token,work);
    }
    @DELETE
    @Path("/{workId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes one work", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Work deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Work not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Void.class) })

    public Response deleteWorksById(@ApiParam(value = "id of the work",required=true) @PathParam("workId") BigDecimal workId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.deleteWorksById(workId,token);
    }
}

