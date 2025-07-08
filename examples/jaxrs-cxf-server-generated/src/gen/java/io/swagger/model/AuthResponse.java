package io.swagger.model;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AuthResponse   {
  
  @Schema(example = "Bearer", description = "Tipo de token (siempre 'Bearer')")
 /**
   * Tipo de token (siempre 'Bearer')  
  **/
  private String tokenType = null;
  
  @Schema(example = "604800", description = "Tiempo de expiración del token en segundos")
 /**
   * Tiempo de expiración del token en segundos  
  **/
  private Long expiresIn = null;
  
  @Schema(example = "lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD", description = "Token de acceso JWT")
 /**
   * Token de acceso JWT  
  **/
  private String accessToken = null;
 /**
   * Tipo de token (siempre &#x27;Bearer&#x27;)
   * @return tokenType
  **/
  @JsonProperty("tokenType")
  @NotNull
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public AuthResponse tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

 /**
   * Tiempo de expiración del token en segundos
   * @return expiresIn
  **/
  @JsonProperty("expiresIn")
  @NotNull
  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public AuthResponse expiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

 /**
   * Token de acceso JWT
   * @return accessToken
  **/
  @JsonProperty("accessToken")
  @NotNull
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public AuthResponse accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
