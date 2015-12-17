package io.swagger.api;

import io.swagger.api.JobOfferApiService;
import io.swagger.api.factories.JobOfferApiServiceFactory;
import io.swagger.annotations.ApiParam;

import io.swagger.model.JobOffer;

import java.math.BigDecimal;

import io.swagger.model.NewJobOffer;
import io.swagger.model.Work;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/jobOffer")


@io.swagger.annotations.Api(description = "the jobOffer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class JobOfferApi  {
   private final JobOfferApiService delegate = JobOfferApiServiceFactory.getJobOfferApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `jobOffer` objects.\nOptional query param of **size** determines size of returned array.\nOptional query param of **restaurantId**.", response = JobOffer.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = JobOffer.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No content", response = JobOffer.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = JobOffer.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = JobOffer.class, responseContainer = "List") })

    public Response getJobOffer(@ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "Size of array") @QueryParam("size") Double size,
    @ApiParam(value = "id of restaurant") @QueryParam("restaurantId") BigDecimal restaurantId)
    throws NotFoundException {
        return delegate.getJobOffer(token,size,restaurantId);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new job offer", response = Long.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Job Offer created", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Long.class) })

    public Response postJobOffer(@ApiParam(value = "new job offer" ,required=true) NewJobOffer newJobOffer,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.postJobOffer(newJobOffer,token);
    }
    @GET
    @Path("/{jobOfferId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `jobOffer` object.", response = JobOffer.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = JobOffer.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = JobOffer.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Job offer not found", response = JobOffer.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = JobOffer.class) })

    public Response getJobOfferById(@ApiParam(value = "id of the job offer",required=true) @PathParam("jobOfferId") BigDecimal jobOfferId)
    throws NotFoundException {
        return delegate.getJobOfferById(jobOfferId);
    }
    @PUT
    @Path("/{jobOfferId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Updates a job offer with his id", response = Work.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Work not found", response = Work.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Work.class) })

    public Response putJobOfferById(@ApiParam(value = "id of the job offer",required=true) @PathParam("jobOfferId") BigDecimal jobOfferId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "job offer with new information" ) NewJobOffer jobOffer)
    throws NotFoundException {
        return delegate.putJobOfferById(jobOfferId,token,jobOffer);
    }
    @DELETE
    @Path("/{jobOfferId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes one job offer", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Job offer deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Job offer not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Void.class) })

    public Response deleteJobOfferById(@ApiParam(value = "id of the job offer",required=true) @PathParam("jobOfferId") BigDecimal jobOfferId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.deleteJobOfferById(jobOfferId,token);
    }
    @POST
    @Path("/{jobOfferId}/apply")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply to a job offer", response = Long.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Application done", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Long.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Long.class) })

    public Response applyToAJobOffer(@ApiParam(value = "job offer",required=true) @PathParam("jobOfferId") BigDecimal jobOfferId,
    @ApiParam(value = "id of the chef who applies",required=true) @QueryParam("chefId") BigDecimal chefId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.applyToAJobOffer(jobOfferId,chefId,token);
    }
}

