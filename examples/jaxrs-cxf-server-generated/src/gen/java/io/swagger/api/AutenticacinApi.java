package io.swagger.api;

import io.swagger.model.AuthRequest;
import io.swagger.model.AuthResponse;
import io.swagger.model.ErrorResponse;

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
public interface AutenticacinApi  {

    /**
     * Obtiene un token de autenticación
     *
     * Valida las credenciales de usuario y retorna un token de acceso Bearer válido por 7 días.
     *
     */
    @POST
    @Path("/auth/token")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Obtiene un token de autenticación", tags={ "Autenticación" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Autenticación exitosa. Retorna el token de acceso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado. Credenciales inválidas.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    public AuthResponse authTokenPost(@Valid AuthRequest body);
}
