# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.auth_request import AuthRequest  # noqa: E501
from swagger_server.models.auth_response import AuthResponse  # noqa: E501
from swagger_server.models.error_response import ErrorResponse  # noqa: E501
from swagger_server.test import BaseTestCase


class TestAutenticacinController(BaseTestCase):
    """AutenticacinController integration test stubs"""

    def test_auth_token_post(self):
        """Test case for auth_token_post

        Obtiene un token de autenticación
        """
        body = AuthRequest()
        response = self.client.open(
            '/oreon3000organizatio/api-exportacion-loterias-std/1.2/auth/token',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
