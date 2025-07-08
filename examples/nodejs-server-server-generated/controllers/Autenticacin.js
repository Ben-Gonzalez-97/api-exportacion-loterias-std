'use strict';

var utils = require('../utils/writer.js');
var Autenticacin = require('../service/AutenticacinService');

module.exports.authTokenPOST = function authTokenPOST (req, res, next, body) {
  Autenticacin.authTokenPOST(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
