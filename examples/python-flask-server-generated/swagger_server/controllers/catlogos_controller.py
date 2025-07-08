import connexion
import six

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.inline_response200 import InlineResponse200  # noqa: E501
from swagger_server.models.inline_response2001 import InlineResponse2001  # noqa: E501
from swagger_server.models.tipo_loteria_juegos_response import TipoLoteriaJuegosResponse  # noqa: E501
from swagger_server import util


def juegos_get():  # noqa: E501
    """Obtiene la lista de todos los juegos

    Retorna una lista de todos los juegos disponibles en el sistema. # noqa: E501


    :rtype: InlineResponse2001
    """
    return 'do some magic!'


def tipo_loteria_get():  # noqa: E501
    """Obtiene la lista de tipos de lotería

    Retorna una lista de todos los tipos de lotería disponibles para consulta. # noqa: E501


    :rtype: InlineResponse200
    """
    return 'do some magic!'


def tipos_loteria_tipo_loteria_id_juegos_get(tipo_loteria_id):  # noqa: E501
    """Obtiene los juegos por tipo de lotería

    Retorna una lista de juegos asociados a un tipo de lotería específico. # noqa: E501

    :param tipo_loteria_id: El identificador del tipo de lotería.
    :type tipo_loteria_id: str

    :rtype: TipoLoteriaJuegosResponse
    """
    return 'do some magic!'
