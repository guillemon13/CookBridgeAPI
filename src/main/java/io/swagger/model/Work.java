package io.swagger.model;

import java.util.Date;

import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class Work  {
  
	@Id
  private Long id = null;
  private Long restaurantId = null;
  private Long chefId = null;
  private String position = null;
  private Date beginDate = null;
  private Date endDate = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("restaurantId")
  public Long getRestaurantId() {
    return restaurantId;
  }
  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("chefId")
  public Long getChefId() {
    return chefId;
  }
  public void setChefId(Long chefId) {
    this.chefId = chefId;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("position")
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("beginDate")
  public Date getBeginDate() {
    return beginDate;
  }
  public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("endDate")
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Work {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  restaurantId: ").append(restaurantId).append("\n");
    sb.append("  chefId: ").append(chefId).append("\n");
    sb.append("  position: ").append(position).append("\n");
    sb.append("  beginDate: ").append(beginDate).append("\n");
    sb.append("  endDate: ").append(endDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
