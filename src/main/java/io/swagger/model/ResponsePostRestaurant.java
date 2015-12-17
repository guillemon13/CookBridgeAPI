package io.swagger.model;

import io.swagger.model.Actions;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class ResponsePostRestaurant  {
  
  private Long restaurantId = null;
  private Actions actions = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("RestaurantId")
  public Long getRestaurantId() {
    return restaurantId;
  }
  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("actions")
  public Actions getActions() {
    return actions;
  }
  public void setActions(Actions actions) {
    this.actions = actions;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePostRestaurant {\n");
    
    sb.append("  restaurantId: ").append(restaurantId).append("\n");
    sb.append("  actions: ").append(actions).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
