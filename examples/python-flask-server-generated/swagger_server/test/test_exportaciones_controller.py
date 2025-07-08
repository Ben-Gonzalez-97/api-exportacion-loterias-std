# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.models.export_response import ExportResponse  # noqa: E501
from swagger_server.test import BaseTestCase


class TestExportacionesController(BaseTestCase):
    """ExportacionesController integration test stubs"""

    def test_exportaciones_get(self):
        """Test case for exportaciones_get

        Realiza una exportación de datos
        """
        query_string = [('entidad', 'entidad_example'),
                        ('moneda', 'ved'),
                        ('fecha_desde', '2013-10-20'),
                        ('fecha_hasta', '2013-10-20'),
                        ('tipo_loteria', 'multijuego'),
                        ('juego', 'juego_example')]
        response = self.client.open(
            '/oreon3000organizatio/api-exportacion-loterias-std/1.2/exportaciones',
            method='GET',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
