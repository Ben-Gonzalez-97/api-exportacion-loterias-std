package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.TipoLoteriaJuegosResponse;

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
public interface CatlogosApi  {

    /**
     * Obtiene la lista de todos los juegos
     *
     * Retorna una lista de todos los juegos disponibles en el sistema.
     *
     */
    @GET
    @Path("/juegos")
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Obtiene la lista de todos los juegos", tags={ "Catálogos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de todos los juegos.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse2001.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado. El token es inválido o ha expirado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public InlineResponse2001 juegosGet();

    /**
     * Obtiene la lista de tipos de lotería
     *
     * Retorna una lista de todos los tipos de lotería disponibles para consulta.
     *
     */
    @GET
    @Path("/tipo-loteria")
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Obtiene la lista de tipos de lotería", tags={ "Catálogos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de tipos de lotería.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado. El token es inválido o ha expirado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public InlineResponse200 tipoLoteriaGet();

    /**
     * Obtiene los juegos por tipo de lotería
     *
     * Retorna una lista de juegos asociados a un tipo de lotería específico.
     *
     */
    @GET
    @Path("/tipos-loteria/{tipoLoteriaId}/juegos")
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Obtiene los juegos por tipo de lotería", tags={ "Catálogos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de juegos para el tipo de lotería especificado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoLoteriaJuegosResponse.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado. El token es inválido o ha expirado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Tipo de lotería no encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public TipoLoteriaJuegosResponse tiposLoteriaTipoLoteriaIdJuegosGet(@PathParam("tipoLoteriaId") String tipoLoteriaId);
}
