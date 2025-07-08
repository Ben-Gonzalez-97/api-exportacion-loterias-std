import connexion
import six

from swagger_server.models.auth_request import AuthRequest  # noqa: E501
from swagger_server.models.auth_response import AuthResponse  # noqa: E501
from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server import util


def auth_token_post(body):  # noqa: E501
    """Obtiene un token de autenticación

    Valida las credenciales de usuario y retorna un token de acceso Bearer válido por 7 días. # noqa: E501

    :param body: 
    :type body: dict | bytes

    :rtype: AuthResponse
    """
    if connexion.request.is_json:
        body = AuthRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
