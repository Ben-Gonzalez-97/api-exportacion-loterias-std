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

public class InlineResponse200   {
  public enum TipoLoteriaEnum {
    TRIPLE("triple"),
    TERMINAL("terminal"),
    RECARGAS("recargas"),
    MULTIJUEGO("multijuego"),
    JUEGO_ELECTRONICO("juego-electronico"),
    ANIMALITO("animalito");

    private String value;

    TipoLoteriaEnum(String value) {
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
    public static TipoLoteriaEnum fromValue(String text) {
      for (TipoLoteriaEnum b : TipoLoteriaEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "")
  private List<TipoLoteriaEnum> tipoLoteria = null;
 /**
   * Get tipoLoteria
   * @return tipoLoteria
  **/
  @JsonProperty("tipoLoteria")
  @NotNull
  public List<TipoLoteriaEnum> getTipoLoteria() {
    return tipoLoteria;
  }

  public void setTipoLoteria(List<TipoLoteriaEnum> tipoLoteria) {
    this.tipoLoteria = tipoLoteria;
  }

  public InlineResponse200 tipoLoteria(List<TipoLoteriaEnum> tipoLoteria) {
    this.tipoLoteria = tipoLoteria;
    return this;
  }

  public InlineResponse200 addTipoLoteriaItem(TipoLoteriaEnum tipoLoteriaItem) {
    this.tipoLoteria.add(tipoLoteriaItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    tipoLoteria: ").append(toIndentedString(tipoLoteria)).append("\n");
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
