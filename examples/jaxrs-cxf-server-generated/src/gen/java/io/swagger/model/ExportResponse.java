package io.swagger.model;

import io.swagger.model.ItemConsulta;
import io.swagger.model.Metadata;
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

public class ExportResponse   {
  
  @Schema(description = "")
  private Metadata metadata = null;
  
  @Schema(description = "Resultados de la consulta")
 /**
   * Resultados de la consulta  
  **/
  private List<ItemConsulta> salidaConsulta = null;
 /**
   * Get metadata
   * @return metadata
  **/
  @JsonProperty("metadata")
  @NotNull
  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public ExportResponse metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

 /**
   * Resultados de la consulta
   * @return salidaConsulta
  **/
  @JsonProperty("salidaConsulta")
  @NotNull
  public List<ItemConsulta> getSalidaConsulta() {
    return salidaConsulta;
  }

  public void setSalidaConsulta(List<ItemConsulta> salidaConsulta) {
    this.salidaConsulta = salidaConsulta;
  }

  public ExportResponse salidaConsulta(List<ItemConsulta> salidaConsulta) {
    this.salidaConsulta = salidaConsulta;
    return this;
  }

  public ExportResponse addSalidaConsultaItem(ItemConsulta salidaConsultaItem) {
    this.salidaConsulta.add(salidaConsultaItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExportResponse {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    salidaConsulta: ").append(toIndentedString(salidaConsulta)).append("\n");
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
