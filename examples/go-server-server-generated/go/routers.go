/*
 * Estándar Para Las APIs De Exportación De Datos De Lotería
 *
 * Especificación para las APIs de exportación de datos de lotería, diseñada para ser implementada por sistemas heterogéneos, soportando formatos JSON y XML.   El objetivo es homogeneizar la forma en que los datos son expuestos.  ## Características principales: - Soporte dual para JSON y XML - Autenticación Bearer Token - Filtrado flexible por entidad, moneda, fechas y tipo de lotería - Validación robusta de parámetros  ## Límites importantes: - Solo se pueden consultar datos hasta el día anterior (fecha actual -1) - fechaDesde debe ser menor o igual a fechaHasta - Token de acceso válido por 7 días (604800 segundos) 
 *
 * API version: 1.2
 * Contact: ben.gonzalez@example.com
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */
package swagger

import (
	"fmt"
	"net/http"
	"strings"

	"github.com/gorilla/mux"
)

type Route struct {
	Name        string
	Method      string
	Pattern     string
	HandlerFunc http.HandlerFunc
}

type Routes []Route

func NewRouter() *mux.Router {
	router := mux.NewRouter().StrictSlash(true)
	for _, route := range routes {
		var handler http.Handler
		handler = route.HandlerFunc
		handler = Logger(handler, route.Name)

		router.
			Methods(route.Method).
			Path(route.Pattern).
			Name(route.Name).
			Handler(handler)
	}

	return router
}

func Index(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World!")
}

var routes = Routes{
	Route{
		"Index",
		"GET",
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/",
		Index,
	},

	Route{
		"AuthTokenPost",
		strings.ToUpper("Post"),
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/auth/token",
		AuthTokenPost,
	},

	Route{
		"JuegosGet",
		strings.ToUpper("Get"),
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/juegos",
		JuegosGet,
	},

	Route{
		"TipoLoteriaGet",
		strings.ToUpper("Get"),
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/tipo-loteria",
		TipoLoteriaGet,
	},

	Route{
		"TiposLoteriaTipoLoteriaIdJuegosGet",
		strings.ToUpper("Get"),
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/tipos-loteria/{tipoLoteriaId}/juegos",
		TiposLoteriaTipoLoteriaIdJuegosGet,
	},

	Route{
		"ExportacionesGet",
		strings.ToUpper("Get"),
		"/oreon3000organizatio/api-exportacion-loterias-std/1.2/exportaciones",
		ExportacionesGet,
	},
}
