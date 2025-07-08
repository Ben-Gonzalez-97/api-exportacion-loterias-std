'use strict';

var utils = require('../utils/writer.js');
var Exportaciones = require('../service/ExportacionesService');

module.exports.exportacionesGET = function exportacionesGET (req, res, next, entidad, fechaDesde, moneda, fechaHasta, tipoLoteria, juego) {
  Exportaciones.exportacionesGET(entidad, fechaDesde, moneda, fechaHasta, tipoLoteria, juego)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
