package io.swagger.api;

import io.swagger.api.ChefsApiService;
import io.swagger.api.factories.ChefsApiServiceFactory;
import io.swagger.annotations.ApiParam;

import io.swagger.model.Chef;
import io.swagger.model.NewChef;
import io.swagger.model.ResponsePostChef;

import java.math.BigDecimal;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/chefs")


@io.swagger.annotations.Api(description = "the chefs API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class ChefsApi  {
   private final ChefsApiService delegate = ChefsApiServiceFactory.getChefsApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `chef` objects.\nOptional query param of **size** determines\nsize of returned array", response = Chef.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Chef.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No content", response = Chef.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Chef.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Chef.class, responseContainer = "List") })

    public Response getChefs(@ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "Size of array") @QueryParam("size") Double size)
    throws NotFoundException {
        return delegate.getChefs(token,size);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new chef", response = ResponsePostChef.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Chef created.\n<br/> action=GetJobOffer\nmethod=\"GET\"\nhref=\"/jobOffer\"\n<br/> action=PostWork\nmethod=\"POST\"\nhref=\"/work\"", response = ResponsePostChef.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = ResponsePostChef.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = ResponsePostChef.class) })

    public Response postChef(@ApiParam(value = "new chef" ,required=true) NewChef newChef)
    throws NotFoundException {
        return delegate.postChef(newChef);
    }
    @GET
    @Path("/{chefId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `chef` object to see the profil.", response = Chef.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Chef.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Chef.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Chef not found", response = Chef.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Chef.class) })

    public Response getChefById(@ApiParam(value = "id of the chef",required=true) @PathParam("chefId") BigDecimal chefId)
    throws NotFoundException {
        return delegate.getChefById(chefId);
    }
    @PUT
    @Path("/{chefId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Updates a chef with his id", response = Chef.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Chef.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Chef.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Chef.class) })

    public Response putChefById(@ApiParam(value = "id of the chef",required=true) @PathParam("chefId") BigDecimal chefId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "chef with new information" ) NewChef chef)
    throws NotFoundException {
        return delegate.putChefById(chefId,token,chef);
    }
    @DELETE
    @Path("/{chefId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes one chef", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Chef deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Chef not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Void.class) })

    public Response deleteChefById(@ApiParam(value = "id of the chef",required=true) @PathParam("chefId") BigDecimal chefId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.deleteChefById(chefId,token);
    }
}

