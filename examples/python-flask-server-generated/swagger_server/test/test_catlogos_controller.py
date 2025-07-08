# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.inline_response200 import InlineResponse200  # noqa: E501
from swagger_server.models.inline_response2001 import InlineResponse2001  # noqa: E501
from swagger_server.models.tipo_loteria_juegos_response import TipoLoteriaJuegosResponse  # noqa: E501
from swagger_server.test import BaseTestCase


class TestCatlogosController(BaseTestCase):
    """CatlogosController integration test stubs"""

    def test_juegos_get(self):
        """Test case for juegos_get

        Obtiene la lista de todos los juegos
        """
        response = self.client.open(
            '/oreon3000organizatio/api-exportacion-loterias-std/1.2/juegos',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_tipo_loteria_get(self):
        """Test case for tipo_loteria_get

        Obtiene la lista de tipos de lotería
        """
        response = self.client.open(
            '/oreon3000organizatio/api-exportacion-loterias-std/1.2/tipo-loteria',
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_tipos_loteria_tipo_loteria_id_juegos_get(self):
        """Test case for tipos_loteria_tipo_loteria_id_juegos_get

        Obtiene los juegos por tipo de lotería
        """
        response = self.client.open(
            '/oreon3000organizatio/api-exportacion-loterias-std/1.2/tipos-loteria/{tipoLoteriaId}/juegos'.format(tipo_loteria_id='tipo_loteria_id_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
