package io.swagger.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-12-16T23:15:58.818Z")
public class Actions  {
  
  private String action = null;
  private String methode = null;
  private String href = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("action")
  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("methode")
  public String getMethode() {
    return methode;
  }
  public void setMethode(String methode) {
    this.methode = methode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("href")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Actions {\n");
    
    sb.append("  action: ").append(action).append("\n");
    sb.append("  methode: ").append(methode).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
