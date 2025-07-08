'use strict';

var utils = require('../utils/writer.js');
var Catlogos = require('../service/CatlogosService');

module.exports.juegosGET = function juegosGET (req, res, next) {
  Catlogos.juegosGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.tipo_loteriaGET = function tipo_loteriaGET (req, res, next) {
  Catlogos.tipo_loteriaGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.tipos_loteriaTipoLoteriaIdJuegosGET = function tipos_loteriaTipoLoteriaIdJuegosGET (req, res, next, tipoLoteriaId) {
  Catlogos.tipos_loteriaTipoLoteriaIdJuegosGET(tipoLoteriaId)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
