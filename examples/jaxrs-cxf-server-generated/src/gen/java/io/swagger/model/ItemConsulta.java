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

public class ItemConsulta   {
  
  @Schema(example = "distribuidor-1", description = "Nombre del distribuidor o agencia")
 /**
   * Nombre del distribuidor o agencia  
  **/
  private String nombre = null;
  
  @Schema(example = "12865", description = "Monto total de ventas")
 /**
   * Monto total de ventas  
  **/
  private Double venta = null;
  
  @Schema(example = "4500", description = "Monto total de premios pagados")
 /**
   * Monto total de premios pagados  
  **/
  private Double premio = null;
  
  @Schema(example = "1801.1", description = "Porcentaje de comisión sobre ventas")
 /**
   * Porcentaje de comisión sobre ventas  
  **/
  private Double porcentajeVenta = null;
  
  @Schema(example = "6563.9", description = "Balance total (venta - premio - porcentajeVenta)")
 /**
   * Balance total (venta - premio - porcentajeVenta)  
  **/
  private Double total = null;
  
  @Schema(example = "triple", description = "Tipo de lotería del registro")
 /**
   * Tipo de lotería del registro  
  **/
  private String tipoLoteria = null;
  
  @Schema(example = "trio-activo", description = "Juego específico del registro")
 /**
   * Juego específico del registro  
  **/
  private String juego = null;
 /**
   * Nombre del distribuidor o agencia
   * @return nombre
  **/
  @JsonProperty("nombre")
  @NotNull
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ItemConsulta nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

 /**
   * Monto total de ventas
   * minimum: 0
   * @return venta
  **/
  @JsonProperty("venta")
  @NotNull
 @DecimalMin("0")  public Double getVenta() {
    return venta;
  }

  public void setVenta(Double venta) {
    this.venta = venta;
  }

  public ItemConsulta venta(Double venta) {
    this.venta = venta;
    return this;
  }

 /**
   * Monto total de premios pagados
   * minimum: 0
   * @return premio
  **/
  @JsonProperty("premio")
  @NotNull
 @DecimalMin("0")  public Double getPremio() {
    return premio;
  }

  public void setPremio(Double premio) {
    this.premio = premio;
  }

  public ItemConsulta premio(Double premio) {
    this.premio = premio;
    return this;
  }

 /**
   * Porcentaje de comisión sobre ventas
   * minimum: 0
   * @return porcentajeVenta
  **/
  @JsonProperty("porcentajeVenta")
  @NotNull
 @DecimalMin("0")  public Double getPorcentajeVenta() {
    return porcentajeVenta;
  }

  public void setPorcentajeVenta(Double porcentajeVenta) {
    this.porcentajeVenta = porcentajeVenta;
  }

  public ItemConsulta porcentajeVenta(Double porcentajeVenta) {
    this.porcentajeVenta = porcentajeVenta;
    return this;
  }

 /**
   * Balance total (venta - premio - porcentajeVenta)
   * @return total
  **/
  @JsonProperty("total")
  @NotNull
  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public ItemConsulta total(Double total) {
    this.total = total;
    return this;
  }

 /**
   * Tipo de lotería del registro
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

  public ItemConsulta tipoLoteria(String tipoLoteria) {
    this.tipoLoteria = tipoLoteria;
    return this;
  }

 /**
   * Juego específico del registro
   * @return juego
  **/
  @JsonProperty("juego")
  @NotNull
  public String getJuego() {
    return juego;
  }

  public void setJuego(String juego) {
    this.juego = juego;
  }

  public ItemConsulta juego(String juego) {
    this.juego = juego;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemConsulta {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    venta: ").append(toIndentedString(venta)).append("\n");
    sb.append("    premio: ").append(toIndentedString(premio)).append("\n");
    sb.append("    porcentajeVenta: ").append(toIndentedString(porcentajeVenta)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
