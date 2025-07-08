import connexion
import six

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.export_response import ExportResponse  # noqa: E501
from swagger_server import util


def exportaciones_get(entidad, fecha_desde, moneda=None, fecha_hasta=None, tipo_loteria=None, juego=None):  # noqa: E501
    """Realiza una exportación de datos

    Obtiene datos de contabilidad filtrados según los parámetros proporcionados.  **Limitaciones importantes:** - Solo se pueden consultar datos hasta el día anterior (fecha actual -1) - fechaDesde debe ser menor o igual a fechaHasta - Para tipoLoteria&#x3D;multijuego, el parámetro juego será ignorado  # noqa: E501

    :param entidad: Filtra por agencias (&#x27;ag&#x27;) o distribuidores (&#x27;rc&#x27;).
    :type entidad: str
    :param fecha_desde: Fecha inicial de la consulta en formato YYYY-MM-DD. Debe ser anterior a la fecha actual.
    :type fecha_desde: str
    :param moneda: Filtra por moneda. Por defecto es &#x27;ved&#x27; (bolívares digitales).
    :type moneda: str
    :param fecha_hasta: Fecha final de la consulta en formato YYYY-MM-DD. Si no se especifica, se usa la fecha anterior a la consulta.
    :type fecha_hasta: str
    :param tipo_loteria: Define el tipo de lotería. Por defecto es &#x27;multijuego&#x27;.
    :type tipo_loteria: str
    :param juego: Define un juego específico. Se ignora si tipoLoteria es &#x27;multijuego&#x27;.
    :type juego: str

    :rtype: ExportResponse
    """
    fecha_desde = util.deserialize_date(fecha_desde)
    fecha_hasta = util.deserialize_date(fecha_hasta)
    return 'do some magic!'
