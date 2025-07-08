'use strict';


/**
 * Obtiene un token de autenticación
 * Valida las credenciales de usuario y retorna un token de acceso Bearer válido por 7 días.
 *
 * body AuthRequest 
 * returns AuthResponse
 **/
exports.authTokenPOST = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "expiresIn" : 604800,
  "tokenType" : "Bearer",
  "accessToken" : "lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

