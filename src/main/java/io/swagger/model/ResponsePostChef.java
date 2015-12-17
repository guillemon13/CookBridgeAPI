package io.swagger.model;

import io.swagger.model.Actions;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class ResponsePostChef  {
  
  private Long chefId = null;
  private Actions actions = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ChefId")
  public Long getChefId() {
    return chefId;
  }
  public void setChefId(Long chefId) {
    this.chefId = chefId;
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
    sb.append("class ResponsePostChef {\n");
    
    sb.append("  chefId: ").append(chefId).append("\n");
    sb.append("  actions: ").append(actions).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
