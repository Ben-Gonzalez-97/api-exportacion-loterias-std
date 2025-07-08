'use strict';


/**
 * Obtiene la lista de todos los juegos
 * Retorna una lista de todos los juegos disponibles en el sistema.
 *
 * returns inline_response_200_1
 **/
exports.juegosGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "juegos" : [ "juegos", "juegos" ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Obtiene la lista de tipos de lotería
 * Retorna una lista de todos los tipos de lotería disponibles para consulta.
 *
 * returns inline_response_200
 **/
exports.tipo_loteriaGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "tipoLoteria" : [ "triple", "triple" ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Obtiene los juegos por tipo de lotería
 * Retorna una lista de juegos asociados a un tipo de lotería específico.
 *
 * tipoLoteriaId String El identificador del tipo de lotería.
 * returns TipoLoteriaJuegosResponse
 **/
exports.tipos_loteriaTipoLoteriaIdJuegosGET = function(tipoLoteriaId) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "juegos" : [ "juegos", "juegos" ],
  "tipoLoteria" : "triple"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

