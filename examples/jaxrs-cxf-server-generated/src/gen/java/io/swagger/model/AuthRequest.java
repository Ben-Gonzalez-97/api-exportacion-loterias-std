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

public class AuthRequest   {
  
  @Schema(example = "admin-user", required = true, description = "Nombre de usuario para autenticación")
 /**
   * Nombre de usuario para autenticación  
  **/
  private String username = null;
  
  @Schema(example = "secure-password-123", required = true, description = "Contraseña del usuario")
 /**
   * Contraseña del usuario  
  **/
  private String password = null;
 /**
   * Nombre de usuario para autenticación
   * @return username
  **/
  @JsonProperty("username")
  @NotNull
 @Size(min=3,max=50)  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AuthRequest username(String username) {
    this.username = username;
    return this;
  }

 /**
   * Contraseña del usuario
   * @return password
  **/
  @JsonProperty("password")
  @NotNull
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AuthRequest password(String password) {
    this.password = password;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthRequest {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
