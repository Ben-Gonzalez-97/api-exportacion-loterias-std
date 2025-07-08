package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
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

public class JuegosResponse   {
  
  @Schema(description = "Lista de todos los juegos disponibles")
 /**
   * Lista de todos los juegos disponibles  
  **/
  private List<String> juegos = null;
 /**
   * Lista de todos los juegos disponibles
   * @return juegos
  **/
  @JsonProperty("juegos")
  @NotNull
  public List<String> getJuegos() {
    return juegos;
  }

  public void setJuegos(List<String> juegos) {
    this.juegos = juegos;
  }

  public JuegosResponse juegos(List<String> juegos) {
    this.juegos = juegos;
    return this;
  }

  public JuegosResponse addJuegosItem(String juegosItem) {
    this.juegos.add(juegosItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JuegosResponse {\n");
    
    sb.append("    juegos: ").append(toIndentedString(juegos)).append("\n");
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
