# API REST de Exportación de Datos de Lotería (V1)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Version](https://img.shields.io/badge/Version-1.2-blue.svg)](docs/documentacion-api.pdf)
[![Autor](https://img.shields.io/badge/Autor-Ing.%20Ben%20Gonzalez-lightgrey.svg)](mailto:gonzbs97@gmail.com)

Bienvenido a la especificación de la **API REST de Exportación de Datos de Lotería**. Este proyecto define un estándar para exponer datos de lotería desde sistemas con arquitecturas heterogéneas, facilitando la integración y el análisis de datos de manera unificada.

El objetivo principal es homogeneizar el acceso a la información, permitiendo que cada sistema proveedor elija la representación de datos (JSON o XML) que mejor se adapte a su entorno, garantizando así la interoperabilidad y la flexibilidad.

> Para una guía detallada sobre todos los endpoints, modelos de datos, y códigos de error, por favor consulta la **[Documentación Completa de la API](docs/documentacion-api.pdf)**. Para una definición formal del estándar, puedes consultar el archivo **[OpenAPI Specification](openapi.yaml)**.

## Características Principales

*   **Soporte Dual JSON/XML:** Flexibilidad para exponer datos en JSON, XML, o ambos, según la preferencia del implementador y el consumidor.
*   **Autenticación Segura:** Utiliza tokens Bearer (JWT) obtenidos a través de un endpoint de autenticación, garantizando la seguridad de las transacciones.
*   **Diseño RESTful:** Adherencia a los principios de una arquitectura RESTful, utilizando métodos HTTP estándar para operaciones sobre recursos identificables.
*   **Filtrado Flexible:** Permite filtrar exportaciones por entidad (agencias/distribuidores), moneda, rango de fechas y tipos de lotería/juegos específicos.
*   **Validación Robusta de Parámetros:** Incluye validaciones para rangos de fechas y la lógica de ignorar parámetros irrelevantes según el contexto de la consulta.

## Arquitectura y Conceptos Clave

*   **Seguridad:** Toda la comunicación debe realizarse a través de **HTTPS** para garantizar la encriptación e integridad de los datos. La autenticación se basa en tokens Bearer.
*   **Formatos de Datos:** La API está diseñada para ser flexible, soportando tanto **JSON** (recomendado para nuevas implementaciones) como **XML** (para compatibilidad con sistemas legados).
*   **Convenciones:** Se utilizan convenciones de nomenclatura estándar como `camelCase` para propiedades JSON y `kebab-case` para URLs, asegurando consistencia entre implementaciones.

## Uso Básico

A continuación se muestra un ejemplo rápido de cómo autenticarse y realizar una consulta.

### 1. Obtener un Token de Autenticación

Para interactuar con los endpoints protegidos, primero necesitas obtener un `accessToken`.

```bash
curl -X POST \
  https://{{ip:puerto}}/api/v1/auth/token \
  -H "Content-Type: application/json" \
  -d '{
        "username": "nombre-de-usuario",
        "password": "contraseña-secreta"
      }'
```

La respuesta incluirá tu token de acceso:

```json
{
  "tokenType": "Bearer",
  "expiresIn": 604800,
  "accessToken": "lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD"
}
```

### 2. Realizar una Consulta de Exportación

Usa el `accessToken` obtenido para realizar consultas a los endpoints de la API, como el de exportaciones.

```bash
curl -X GET \
  "https://{{ip:puerto}}/api/v1/exportaciones?entidad=rc&fechaDesde=2025-07-01" \
  -H "Authorization: Bearer lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD"
```

## Ejemplos de Código

Para facilitar la integración, se proporcionan ejemplos de clientes en varios lenguajes de programación dentro de la carpeta `examples/`. Estos ejemplos han sido autogenerados a partir de la especificación `openapi.yaml` y demuestran cómo consumir la API.

## Cómo Contribuir

Agradecemos cualquier contribución para mejorar esta especificación. Por favor, siga los siguientes pasos:

1.  Haga un fork del repositorio.
2.  Cree una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3.  Realice sus cambios.
4.  Realice un commit de sus cambios (`git commit -m 'feat: Añadir nueva funcionalidad'`).
5.  Haga push a la rama (`git push origin feature/nueva-funcionalidad`).
6.  Abra un Pull Request detallando los cambios propuestos.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulte el archivo [LICENSE](LICENSE) para más detalles.

---

**Autor:** Ing. Ben Gonzalez
**Fecha:** Julio, 2025
**Versión:** v1.2