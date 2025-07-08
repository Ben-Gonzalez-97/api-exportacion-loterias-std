'use strict';


/**
 * Realiza una exportación de datos
 * Obtiene datos de contabilidad filtrados según los parámetros proporcionados.  **Limitaciones importantes:** - Solo se pueden consultar datos hasta el día anterior (fecha actual -1) - fechaDesde debe ser menor o igual a fechaHasta - Para tipoLoteria=multijuego, el parámetro juego será ignorado 
 *
 * entidad String Filtra por agencias ('ag') o distribuidores ('rc').
 * fechaDesde date Fecha inicial de la consulta en formato YYYY-MM-DD. Debe ser anterior a la fecha actual.
 * moneda String Filtra por moneda. Por defecto es 'ved' (bolívares digitales). (optional)
 * fechaHasta date Fecha final de la consulta en formato YYYY-MM-DD. Si no se especifica, se usa la fecha anterior a la consulta. (optional)
 * tipoLoteria String Define el tipo de lotería. Por defecto es 'multijuego'. (optional)
 * juego String Define un juego específico. Se ignora si tipoLoteria es 'multijuego'. (optional)
 * returns ExportResponse
 **/
exports.exportacionesGET = function(entidad,fechaDesde,moneda,fechaHasta,tipoLoteria,juego) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "metadata" : {
    "fechaHasta" : "2025-07-03T00:00:00.000+00:00",
    "fechaDesde" : "2025-07-01T00:00:00.000+00:00",
    "entidad" : "rc",
    "moneda" : "ved",
    "tipoLoteria" : "triple",
    "juego" : "trio-activo"
  },
  "salidaConsulta" : [ {
    "porcentajeVenta" : 1801.1,
    "venta" : 12865,
    "total" : 6563.9,
    "premio" : 4500,
    "tipoLoteria" : "triple",
    "nombre" : "distribuidor-1",
    "juego" : "trio-activo"
  }, {
    "porcentajeVenta" : 1801.1,
    "venta" : 12865,
    "total" : 6563.9,
    "premio" : 4500,
    "tipoLoteria" : "triple",
    "nombre" : "distribuidor-1",
    "juego" : "trio-activo"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

