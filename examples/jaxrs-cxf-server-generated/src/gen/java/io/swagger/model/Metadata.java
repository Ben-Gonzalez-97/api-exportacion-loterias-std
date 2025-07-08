package io.swagger.model;

import org.joda.time.LocalDate;
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

public class Metadata   {
  public enum EntidadEnum {
    AG("ag"),
    RC("rc");

    private String value;

    EntidadEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static EntidadEnum fromValue(String text) {
      for (EntidadEnum b : EntidadEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(example = "rc", description = "Tipo de entidad consultada")
 /**
   * Tipo de entidad consultada  
  **/
  private EntidadEnum entidad = null;
  public enum MonedaEnum {
    VED("ved"),
    USD("usd");

    private String value;

    MonedaEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static MonedaEnum fromValue(String text) {
      for (MonedaEnum b : MonedaEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(example = "ved", description = "Moneda de los valores")
 /**
   * Moneda de los valores  
  **/
  private MonedaEnum moneda = null;
  
  @Schema(example = "Tue Jul 01 00:00:00 GMT 2025", description = "Fecha inicial de la consulta")
 /**
   * Fecha inicial de la consulta  
  **/
  private LocalDate fechaDesde = null;
  
  @Schema(example = "Thu Jul 03 00:00:00 GMT 2025", description = "Fecha final de la consulta")
 /**
   * Fecha final de la consulta  
  **/
  private LocalDate fechaHasta = null;
  
  @Schema(example = "triple", description = "Tipo de lotería consultado")
 /**
   * Tipo de lotería consultado  
  **/
  private String tipoLoteria = null;
  
  @Schema(example = "trio-activo", description = "Juego específico consultado (null para multijuego)")
 /**
   * Juego específico consultado (null para multijuego)  
  **/
  private String juego = null;
 /**
   * Tipo de entidad consultada
   * @return entidad
  **/
  @JsonProperty("entidad")
  @NotNull
  public String getEntidad() {
    if (entidad == null) {
      return null;
    }
    return entidad.getValue();
  }

  public void setEntidad(EntidadEnum entidad) {
    this.entidad = entidad;
  }

  public Metadata entidad(EntidadEnum entidad) {
    this.entidad = entidad;
    return this;
  }

 /**
   * Moneda de los valores
   * @return moneda
  **/
  @JsonProperty("moneda")
  @NotNull
  public String getMoneda() {
    if (moneda == null) {
      return null;
    }
    return moneda.getValue();
  }

  public void setMoneda(MonedaEnum moneda) {
    this.moneda = moneda;
  }

  public Metadata moneda(MonedaEnum moneda) {
    this.moneda = moneda;
    return this;
  }

 /**
   * Fecha inicial de la consulta
   * @return fechaDesde
  **/
  @JsonProperty("fechaDesde")
  @NotNull
  public LocalDate getFechaDesde() {
    return fechaDesde;
  }

  public void setFechaDesde(LocalDate fechaDesde) {
    this.fechaDesde = fechaDesde;
  }

  public Metadata fechaDesde(LocalDate fechaDesde) {
    this.fechaDesde = fechaDesde;
    return this;
  }

 /**
   * Fecha final de la consulta
   * @return fechaHasta
  **/
  @JsonProperty("fechaHasta")
  @NotNull
  public LocalDate getFechaHasta() {
    return fechaHasta;
  }

  public void setFechaHasta(LocalDate fechaHasta) {
    this.fechaHasta = fechaHasta;
  }

  public Metadata fechaHasta(LocalDate fechaHasta) {
    this.fechaHasta = fechaHasta;
    return this;
  }

 /**
   * Tipo de lotería consultado
   * @return tipoLoteria
  **/
  @JsonProperty("tipoLoteria")
  @NotNull
  public String getTipoLoteria() {
    return tipoLoteria;
  }

  public void setTipoLoteria(String tipoLoteria) {
    this.tipoLoteria = tipoLoteria;
  }

  public Metadata tipoLoteria(String tipoLoteria) {
    this.tipoLoteria = tipoLoteria;
    return this;
  }

 /**
   * Juego específico consultado (null para multijuego)
   * @return juego
  **/
  @JsonProperty("juego")
  public String getJuego() {
    return juego;
  }

  public void setJuego(String juego) {
    this.juego = juego;
  }

  public Metadata juego(String juego) {
    this.juego = juego;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    entidad: ").append(toIndentedString(entidad)).append("\n");
    sb.append("    moneda: ").append(toIndentedString(moneda)).append("\n");
    sb.append("    fechaDesde: ").append(toIndentedString(fechaDesde)).append("\n");
    sb.append("    fechaHasta: ").append(toIndentedString(fechaHasta)).append("\n");
    sb.append("    tipoLoteria: ").append(toIndentedString(tipoLoteria)).append("\n");
    sb.append("    juego: ").append(toIndentedString(juego)).append("\n");
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
