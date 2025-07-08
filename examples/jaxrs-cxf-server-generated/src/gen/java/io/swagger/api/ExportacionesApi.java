package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.ExportResponse;
import org.joda.time.LocalDate;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Estándar Para Las APIs De Exportación De Datos De Lotería
 *
 * <p>Especificación para las APIs de exportación de datos de lotería, diseñada para ser implementada por sistemas heterogéneos, soportando formatos JSON y XML.   El objetivo es homogeneizar la forma en que los datos son expuestos.  ## Características principales: - Soporte dual para JSON y XML - Autenticación Bearer Token - Filtrado flexible por entidad, moneda, fechas y tipo de lotería - Validación robusta de parámetros  ## Límites importantes: - Solo se pueden consultar datos hasta el día anterior (fecha actual -1) - fechaDesde debe ser menor o igual a fechaHasta - Token de acceso válido por 7 días (604800 segundos) 
 *
 */
@Path("/")
public interface ExportacionesApi  {

    /**
     * Realiza una exportación de datos
     *
     * Obtiene datos de contabilidad filtrados según los parámetros proporcionados.  **Limitaciones importantes:** - Solo se pueden consultar datos hasta el día anterior (fecha actual -1) - fechaDesde debe ser menor o igual a fechaHasta - Para tipoLoteria&#x3D;multijuego, el parámetro juego será ignorado 
     *
     */
    @GET
    @Path("/exportaciones")
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Realiza una exportación de datos", tags={ "Exportaciones" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Exportación de datos exitosa.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExportResponse.class))),
        @ApiResponse(responseCode = "400", description = "Petición incorrecta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado. El token es inválido o ha expirado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public ExportResponse exportacionesGet(@QueryParam("entidad") @NotNull String entidad, @QueryParam("fechaDesde") @NotNull LocalDate fechaDesde, @QueryParam("moneda") @DefaultValue("ved") String moneda, @QueryParam("fechaHasta") LocalDate fechaHasta, @QueryParam("tipoLoteria") @DefaultValue("multijuego") String tipoLoteria, @QueryParam("juego") String juego);
}
