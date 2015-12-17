package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class NewJobOffer  {
  
  private Long restaurantId = null;
  private String name = null;
  private String jobDescription = null;
  private String salary = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("jobDescription")
  public String getJobDescription() {
    return jobDescription;
  }
  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("salary")
  public String getSalary() {
    return salary;
  }
  public void setSalary(String salary) {
    this.salary = salary;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewJobOffer {\n");
    
    sb.append("  restaurantId: ").append(restaurantId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  jobDescription: ").append(jobDescription).append("\n");
    sb.append("  salary: ").append(salary).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
