package io.swagger.api;

import io.swagger.api.RestaurantsApiService;
import io.swagger.api.factories.RestaurantsApiServiceFactory;
import io.swagger.annotations.ApiParam;

import io.swagger.model.Restaurant;
import io.swagger.model.NewRestaurant;
import io.swagger.model.ResponsePostRestaurant;

import java.math.BigDecimal;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/restaurants")


@io.swagger.annotations.Api(description = "the restaurants API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class RestaurantsApi  {
   private final RestaurantsApiService delegate = RestaurantsApiServiceFactory.getRestaurantsApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `restaurant` objects.\nOptional query param of **size** determines\nsize of returned array", response = Restaurant.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Restaurant.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No content", response = Restaurant.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Restaurant.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Restaurant.class, responseContainer = "List") })

    public Response getRestaurants(@ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "Size of array") @QueryParam("size") Double size)
    throws NotFoundException {
        return delegate.getRestaurants(token,size);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new restaurant", response = ResponsePostRestaurant.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Restaurant created.\n<br/> action=PostJobOffer\nmethod=\"POST\"\nhref=\"/jobOffer\"", response = ResponsePostRestaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = ResponsePostRestaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = ResponsePostRestaurant.class) })

    public Response postRestaurant(@ApiParam(value = "new restaurant" ,required=true) NewRestaurant newRestaurant)
    throws NotFoundException {
        return delegate.postRestaurant(newRestaurant);
    }
    @GET
    @Path("/{restaurantId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `restaurant` object to see the profil.", response = Restaurant.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Restaurant not found", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Restaurant.class) })

    public Response getRestaurantById(@ApiParam(value = "id of the restaurant require",required=true) @PathParam("restaurantId") BigDecimal restaurantId)
    throws NotFoundException {
        return delegate.getRestaurantById(restaurantId);
    }
    @PUT
    @Path("/{restaurantId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Updates a restaurant with his id", response = Restaurant.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Restaurant not found", response = Restaurant.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Restaurant.class) })

    public Response putRestaurantById(@ApiParam(value = "id of the restaurant",required=true) @PathParam("restaurantId") BigDecimal restaurantId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token,
    @ApiParam(value = "restaurant with new information" ) NewRestaurant chef)
    throws NotFoundException {
        return delegate.putRestaurantById(restaurantId,token,chef);
    }
    @DELETE
    @Path("/{restaurantId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes one restaurant", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Restaurant deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Restaurant not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 501, message = "Internal server error", response = Void.class) })

    public Response deleteRestaurantById(@ApiParam(value = "id of the restaurant",required=true) @PathParam("restaurantId") BigDecimal restaurantId,
    @ApiParam(value = "Authentication Token" ,required=true)@HeaderParam(HttpHeaders.AUTHORIZATION) String token)
    throws NotFoundException {
        return delegate.deleteRestaurantById(restaurantId,token);
    }
}

