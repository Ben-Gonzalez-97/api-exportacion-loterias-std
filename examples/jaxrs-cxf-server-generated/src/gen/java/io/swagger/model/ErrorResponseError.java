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

public class ErrorResponseError   {
  
  @Schema(example = "TOKEN-INVALID", description = "Código de error identificador")
 /**
   * Código de error identificador  
  **/
  private String codigo = null;
  
  @Schema(example = "Token de autenticación inválido o expirado.", description = "Mensaje descriptivo del error")
 /**
   * Mensaje descriptivo del error  
  **/
  private String mensaje = null;
 /**
   * Código de error identificador
   * @return codigo
  **/
  @JsonProperty("codigo")
  @NotNull
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public ErrorResponseError codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

 /**
   * Mensaje descriptivo del error
   * @return mensaje
  **/
  @JsonProperty("mensaje")
  @NotNull
  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public ErrorResponseError mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseError {\n");
    
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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
