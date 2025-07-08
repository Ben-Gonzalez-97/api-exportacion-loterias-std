# API REST de Exportación de Datos de Lotería (V1)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Version](https://img.shields.io/badge/Version-1.2-blue.svg)](docs/documentacion-api.pdf)
[![Autor](https://img.shields.io/badge/Autor-Ing.%20Ben%20Gonzalez-lightgrey.svg)](mailto:gonzbs97@gmail.com)

Este repositorio contiene la especificación para la API REST de Exportación de Datos de Lotería, diseñada para estandarizar la forma en que los datos de lotería son expuestos por sistemas con arquitecturas heterogéneas. El objetivo principal es homogeneizar el acceso a la información, permitiendo a cada sistema proveedor elegir la representación de datos (JSON o XML) que mejor se adapte a su entorno existente, asegurando la interoperabilidad y flexibilidad.

## Tabla de Contenidos

1.  [Visión General](#visión-general)
2.  [Características Principales](#características-principales)
3.  [Arquitectura y Seguridad](#arquitectura-y-seguridad)
4.  [Formatos de Datos Soportados](#formatos-de-datos-soportados)
    * [JSON (JavaScript Object Notation)](#json-javascript-object-notation)
    * [XML (Extensible Markup Language)](#xml-extensible-markup-language)
5.  [Convenciones de Nomenclatura](#convenciones-de-nomenclatura)
6.  [Tipos de Datos](#tipos-de-datos)
7.  [Manejo de Valores Nulos](#manejo-de-valores-nulos)
8.  [Endpoints](#endpoints)
    * [Autenticación](#autenticación)
    * [Catálogos](#catálogos)
    * [Exportaciones](#exportaciones)
9.  [Códigos de Estado HTTP y Manejo de Errores](#códigos-de-estado-http-y-manejo-de-errores)
10. [Anexos](#anexos)
11. [Cómo Contribuir](#cómo-contribuir)
12. [Licencia](#licencia)

## 1. Visión General

La API de Exportación de Datos de Lotería proporciona un estándar unificado para la consulta y exportación de información contable y de operaciones de lotería. Está diseñada para ser implementada por diversos sistemas, facilitando la integración y el intercambio de datos entre plataformas. Los implementadores deben adherirse a las estructuras de datos definidas en esta especificación para garantizar la compatibilidad. [cite: 69, 71]

## 2. Características Principales

* **Soporte Dual JSON/XML:** Flexibilidad para exponer datos en JSON, XML, o ambos, según la preferencia del implementador y el consumidor. [cite: 70, 74, 75]
* **Autenticación Segura:** Utiliza tokens Bearer obtenidos a través de un endpoint de autenticación, garantizando la seguridad de las transacciones. [cite: 73, 98]
* **Diseño RESTful:** Adherencia a los principios de una arquitectura RESTful, utilizando métodos HTTP estándar para operaciones sobre recursos identificables. [cite: 72]
* **Filtrado Flexible:** Permite filtrar exportaciones por entidad (agencias/distribuidores), moneda, rango de fechas y tipos de lotería/juegos específicos. [cite: 102, 103, 105, 106, 109, 111]
* **Validación Robusta de Parámetros:** Incluye validaciones para rangos de fechas y la lógica de ignorar el parámetro `juego` cuando `tipoLoteria` es `multijuego`. [cite: 108, 118]

## 3. Arquitectura y Seguridad

La API se adhiere a los principios de una arquitectura RESTful, utilizando métodos HTTP estándar para operaciones sobre recursos identificables. [cite: 72] Toda la comunicación se realiza a través de **HTTPS** para garantizar la seguridad e integridad de los datos. [cite: 73]

## 4. Formatos de Datos Soportados

Esta API está diseñada para la máxima flexibilidad e interoperabilidad, permitiendo a los implementadores elegir entre JSON y XML. [cite: 76]

### JSON (JavaScript Object Notation)

Un formato ligero y ampliamente adoptado, recomendado para nuevas implementaciones y sistemas modernos debido a su rendimiento superior y facilidad de integración con ecosistemas de desarrollo modernos. [cite: 77, 80, 81]

### XML (Extensible Markup Language)

Un formato estructurado, provisto para asegurar la compatibilidad con sistemas legados que ya operan con estructuras basadas en XML y requieren homogeneidad en su arquitectura existente. [cite: 78, 79, 82]

La elección del formato (JSON o XML) recae en el implementador de la API. Se espera que la API implementada devuelva el formato preferido por el sistema al que está sirviendo o, si lo desea, sea capaz de responder en ambos formatos si el consumidor lo indica (a través de la cabecera `Accept`). [cite: 83, 84]

## 5. Convenciones de Nomenclatura

Para asegurar la consistencia en todas las implementaciones, se han adoptado las siguientes convenciones: [cite: 86]

* **URLs de Endpoints:** Se utilizará `kebab-case` para los segmentos de URL (ej., `/api/v1/auth/token`). [cite: 86]
* **Nombres de Propiedades (JSON) y Parámetros de Consulta:** Se utilizará `camelCase` (ej., `tokenType`, `expiresIn`). [cite: 87]
* **Nombres de Elementos (XML):**
    * Elementos raíz y de objetos complejos: `PascalCase` (ej., `<AuthResponse>`, `<ErrorResponse>`). [cite: 88]
    * Elementos anidados y de propiedades: `camelCase` (ej., `<tokenType>`, `<username>`). [cite: 89]
    * Colecciones: Se representarán con un elemento contenedor (ej., `<salidaConsulta>`) que contendrá múltiples elementos hijos (ej., `<item>`). [cite: 89]

* **Codificación de Caracteres:** Todas las peticiones y respuestas deben utilizar la codificación de caracteres **UTF-8**. [cite: 90]

## 6. Tipos de Datos

La API maneja los siguientes tipos de datos estándar, que los implementadores deben mapear desde sus tipos de datos internos: [cite: 91, 92]

| Tipo de Datos     | Descripción                         | JSON                 | XML (Ejemplo)                     |
| :---------------- | :---------------------------------- | :------------------- | :-------------------------------- |
| `String`          | Cadena de caracteres Unicode.       | `"valor"`            | `<elemento>valor</elemento>`      |
| `Integer`         | Número entero sin decimales.        | `123`                | `<elemento>123</elemento>`        |
| `Decimal`         | Número con decimales (flotante de doble precisión). | `123.45`             | `<elemento>123.45</elemento>`    |
| `Boolean`         | Valor lógico.                       | `true` / `false`     | `<elemento>true</elemento>`      |
| `Date (YYYY-MM-DD)` | Fecha en formato ISO 8601.        | `""YYYY-MM-DD""`     | `<elemento>YYYY-MM-DD</elemento>` |
| `Array / List`    | Colección ordenada de elementos.    | `[item1, item2]`     | `<Coleccion><item1>...</item1><item2>...</item2></Coleccion>` |
| `Object / Structure` | Conjunto de pares clave-valor o elementos anidados. | `{"key": "value"}`   | `<Objeto><key>value</key></Objeto>` |

## 7. Manejo de Valores Nulos

* **JSON:** Los valores ausentes o nulos deben ser explícitamente representados con `null` (ej., `"juego": null`). [cite: 94]
* **XML:** Los valores nulos deben ser representados por un elemento vacío (ej., `<juego/>`) o, preferiblemente, utilizando el atributo `xsi:nil="true"` (ej., `<juego xsi:nil="true"/>`) si se utilizan esquemas XSD para mayor robustez. [cite: 95]

## 8. Endpoints

A continuación, se describen los endpoints de la API, incluyendo el método HTTP, la URL, los parámetros de consulta (si aplica), y las estructuras de peticiones y respuestas para JSON y XML. [cite: 96]

### Autenticación

#### Obtener Token de Autenticación

* **URL:** `https://{{ip:puerto}}/api/v1/auth/token`
* **Método:** `POST`
* **Descripción:** Valida las credenciales de usuario y retorna un token de acceso Bearer válido por 7 días (604800 segundos). [cite: 97]
* **Request Body (JSON):**
    ```json
    {
      "username": "nombre-de-usuario",
      "password": "contraseña-secreta"
    }
    ```
* **Request Body (XML):**
    ```xml
    <AuthRequest>
      <username>nombre-de-usuario</username>
      <password>contraseña-secreta</password>
    </AuthRequest>
    ```
* **Response (200 OK - JSON):**
    ```json
    {
      "tokenType": "Bearer",
      "expiresIn": 604800,
      "accessToken": "lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD"
    }
    ```
* **Response (200 OK - XML):**
    ```xml
    <AuthResponse>
      <tokenType>Bearer</tokenType>
      <expiresIn>604800</expiresIn>
      <accessToken>lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD</accessToken>
    </AuthResponse>
    ```
* **Header para subsiguientes consultas:** Para las posteriores consultas se requiere un token de tipo Bearer en la cabecera de autorización: [cite: 98, 99]
    * `Header: Authorization`
    * `Value: Bearer <<token>>`

### Catálogos

Estos endpoints no requieren parámetros de consulta, pero sí autenticación.

#### Lista de Tipos de Lotería

* **URL:** `https://{{ip:puerto}}/api/v1/tipo-loteria`
* **Método:** `GET` (Requiere autenticación)
* **Descripción:** Retorna una lista de todos los tipos de lotería disponibles para consulta. [cite: 99]
* **Response (200 OK - JSON):**
    ```json
    {
      "tipoLoteria": [
        "triple",
        "terminal",
        "recargas",
        "multijuego",
        "juego-electronico",
        "animalito"
      ]
    }
    ```
* **Response (200 OK - XML):**
    ```xml
    <TiposLoteriaResponse>
      <tipoLoteria>triple</tipoLoteria>
      <tipoLoteria>terminal</tipoLoteria>
      <tipoLoteria>recargas</tipoLoteria>
      <tipoLoteria>multijuego</tipoLoteria>
      <tipoLoteria>juego-electronico</tipoLoteria>
      <tipoLoteria>animalito</tipoLoteria>
    </TiposLoteriaResponse>
    ```

#### Lista de Juegos

* **URL:** `https://{{ip:puerto}}/api/v1/juegos`
* **Método:** `GET` (Requiere autenticación)
* **Descripción:** Retorna una lista de todos los juegos disponibles en el sistema. [cite: 100]
* **Response (200 OK - JSON):**
    ```json
    {
      "juegos": [
        "activo",
        "bomba",
        "caliente",
        "granjita",
        "lotto-activo",
        "ruleta-activa",
        "uneloton",
        "zulia"
      ]
    }
    ```
* **Response (200 OK - XML):**
    ```xml
    <JuegosResponse>
      <juego>activo</juego>
      <juego>bomba</juego>
      <juego>caliente</juego>
      <juego>granjita</juego>
      <juego>lotto-activo</juego>
      <juego>ruleta-activa</juego>
      <juego>uneloton</juego>
      <juego>zulia</juego>
    </JuegosResponse>
    ```

#### Lista de Juegos por Tipo de Lotería

* **URL:** `https://{{ip:puerto}}/api/v1/tipos-loteria/(tipo-loteria-id)/juegos`
* **Método:** `GET` (Requiere autenticación)
* **Descripción:** Retorna una lista de juegos asociados a un tipo de lotería específico. [cite: 101]
* **Path Parameter:**
    * `tipo-loteria-id`: Identificador del tipo de lotería (ej., `triple`).
* **Response (200 OK - JSON):**
    ```json
    {
      "tipoLoteria": "triple",
      "juegos": [
        "trio-activo",
        "chance",
        "terminaltrio"
      ]
    }
    ```
* **Response (200 OK - XML):**
    ```xml
    <TipoLoteriaJuegosResponse>
      <tipoLoteria>triple</tipoLoteria>
      <juegos>
        <juego>trio-activo</juego>
        <juego>chance</juego>
        <juego>terminaltrio</juego>
      </juegos>
    </TipoLoteriaJuegosResponse>
    ```

### Exportaciones

#### Exportación de Datos de Contabilidad

* **URL:** `https://{{ip:puerto}}/api/v1/exportaciones`
* **Método:** `GET` (Requiere autenticación)
* **Descripción:** Obtiene datos de contabilidad filtrados según los parámetros proporcionados. [cite: 102]
* **Query Parameters:**
    1.  `entidad` (Obligatorio): Filtra el tipo de consulta. [cite: 102]
        * `ag`: Para agencias.
        * `rc`: Para distribuidores (recogedores).
    2.  `moneda` (Opcional): Filtra la moneda a consultar. Por defecto es `ved` (Bolívares digitales). [cite: 103]
        * `ved`: Para bolívares digitales.
        * `usd`: Para dólares estadounidenses.
    3.  `fechaDesde` (Obligatorio): Fecha inicial de la consulta en formato `YYYY-MM-DD`. [cite: 105]
    4.  `fechaHasta` (Opcional): Fecha final de la consulta en formato `YYYY-MM-DD`. Si no se coloca, se retorna por defecto hasta la fecha anterior al momento de la consulta. [cite: 106]
        * **Nota Importante:** No se pueden consultar datos de la fecha actual; los datos se actualizan hasta el día anterior (ej., si hoy es 03/07/2025, la venta del 03 no estará disponible, solo hasta el 02). [cite: 107, 108]
        * **Validación:** `fechaDesde` debe ser menor o igual que `fechaHasta`. [cite: 108]
    5.  `tipoLoteria` (Opcional): Define el tipo de lotería. Por defecto es `multijuego`. Los valores posibles se pueden obtener del endpoint `/api/v1/tipo-loteria`. [cite: 109, 110]
    6.  `juego` (Opcional): Define un juego en específico. Si no se coloca, se retornan por defecto todos los valores de los juegos asociados a este tipo de lotería. Los valores posibles se pueden obtener de `/api/v1/juegos` o `/api/v1/tipos-loteria/{tipo-loteria-id}/juegos`. [cite: 111, 112]
        * **Nota Importante:** Si `tipoLoteria` es `multijuego` (manual o por defecto), el parámetro `juego` será desechado y se retornará `null` en el objeto `metadata` de la respuesta JSON/XML. [cite: 117, 118]

* **Ejemplo de Consulta (cURL):**
    ```bash
    curl -X GET \
    "https://{{ip:puerto}}/api/v1/exportaciones?entidad=rc&moneda=ved&fechaDesde=2025-07-01&fechaHasta=2025-07-03&tipoLoteria=triple&juego=trio-activo" \
    -H "Authorization: Bearer lksUJKdfGJKuJYiw78we3gkjkkjhjkdsJHHJJHJFDDD"
    ```
* **Response (200 OK - JSON - Ejemplo de Consulta Específica):** [cite: 113]
    ```json
    {
      "metadata": {
        "entidad": "rc",
        "moneda": "ved",
        "fechaDesde": "2025-07-01",
        "fechaHasta": "2025-07-03",
        "tipoLoteria": "triple",
        "juego": "trio-activo"
      },
      "salidaConsulta": [
        {
          "nombre": "distribuidor-1",
          "venta": 12865,
          "premio": 4500,
          "porcentajeVenta": 1801.1,
          "total": 6563.9,
          "tipoLoteria": "triple",
          "juego": "trio-activo"
        },
        {
          "nombre": "distribuidor-2",
          "venta": 475,
          "premio": 0,
          "porcentajeVenta": 66.5,
          "total": 408.5,
          "tipoLoteria": "triple",
          "juego": "trio-activo"
        }
        // ... más ítems
      ]
    }
    ```
* **Response (200 OK - XML - Ejemplo de Consulta Específica):** [cite: 114]
    ```xml
    <ExportResponse>
      <metadata>
        <entidad>rc</entidad>
        <moneda>ved</moneda>
        <fechaDesde>2025-07-01</fechaDesde>
        <fechaHasta>2025-07-03</fechaHasta>
        <tipoLoteria>triple</tipoLoteria>
        <juego>trio-activo</juego>
      </metadata>
      <salidaConsulta>
        <item>
          <nombre>distribuidor-1</nombre>
          <venta>12865</venta>
          <premio>4500</premio>
          <porcentajeVenta>1801.1</porcentajeVenta>
          <total>6563.9</total>
          <tipoLoteria>triple</tipoLoteria>
          <juego>trio-activo</juego>
        </item>
        <item>
          <nombre>distribuidor-2</nombre>
          <venta>475</venta>
          <premio>0</premio>
          <porcentajeVenta>66.5</porcentajeVenta>
          <total>408.5</total>
          <tipoLoteria>triple</tipoLoteria>
          <juego>trio-activo</juego>
        </item>
        </salidaConsulta>
    </ExportResponse>
    ```

## 9. Códigos de Estado HTTP y Manejo de Errores

La API utiliza códigos de estado HTTP estándar para indicar el resultado de una operación. En caso de error, se proporciona una estructura de respuesta consistente.

* **401 Unauthorized:**
    * **Causa:** Token de autenticación inválido o expirado. [cite: 119]
    * **JSON:**
        ```json
        {
          "error": {
            "codigo": "TOKEN-INVALID",
            "mensaje": "Token de autenticación inválido o expirado."
          }
        }
        ```
    * **XML:**
        ```xml
        <ErrorResponse>
          <codigo>TOKEN-INVALID</codigo>
          <mensaje>Token de autenticación inválido o expirado.</mensaje>
        </ErrorResponse>
        ```
    * **Causa:** Credenciales de usuario incorrectas. [cite: 125]
    * **JSON:**
        ```json
        {
          "error": {
            "codigo": "INVALID-CREDENTIALS",
            "mensaje": "El usuario o la contraseña son incorrectos."
          }
        }
        ```
    * **XML:**
        ```xml
        <ErrorResponse>
          <codigo>INVALID-CREDENTIALS</codigo>
          <mensaje>El usuario o la contraseña son incorrectos.</mensaje>
        </ErrorResponse>
        ```

* **400 Bad Request:**
    * **Causa:** `fechaDesde` es mayor que `fechaHasta`. [cite: 120]
    * **JSON:**
        ```json
        {
          "error": {
            "codigo": "INVALID-DATE-RANGE",
            "mensaje": "La fechaDesde no puede ser mayor que la fechaHasta."
          }
        }
        ```
    * **XML:**
        ```xml
        <ErrorResponse>
          <codigo>INVALID-DATE-RANGE</codigo>
          <mensaje>La fechaDesde no puede ser mayor que la fechaHasta</mensaje>
        </ErrorResponse>
        ```
    * **Causa:** Intento de consultar datos de la fecha actual. [cite: 122]
    * **JSON:**
        ```json
        {
          "error": {
            "codigo": "FUTURE-DATE-QUERY",
            "mensaje": "No se pueden consultar datos de la fecha actual; los datos se actualizan hasta el día anterior."
          }
        }
        ```
    * **XML:**
        ```xml
        <ErrorResponse>
          <codigo>FUTURE-DATE-QUERY</codigo>
          "mensaje": "No se pueden consultar datos de la fecha actual; los datos se actualizan hasta el día anterior."
        </ErrorResponse>
        ```

## 10. Anexos

* **Lista de tipos de lotería (referenciales):** [cite: 126]
    1.  triple
    2.  terminal
    3.  figura
    4.  animalito
    5.  tripleta
    6.  trio
    7.  parley
    8.  caballo
    9.  terminalito
    10. chance animalito
    11. recargas
    12. juego-electronico
    13. multijuego
    14. bancos

* **Lista de juegos (referenciales):** [cite: 126]
    1.  activo
    2.  bomba
    3.  caliente
    4.  caracas
    5.  carrusel-millonario
    6.  cazaloton
    7.  chance
    8.  deportivas -hasta-3
    9.  deportivas -4-o-mas
    10. dupleta
    11. dupletard
    12. guacharito
    13. gatazo
    14. granjita
    15. granjita-plus
    16. guacharito-millonario
    17. guacharo-activo
    18. lotto-chaima
    19. lotto-activo
    20. lotto-gato
    21. lotto-internacional
    22. lotto-rey
    23. megaanimal
    24. mega-animal-40
    25. monje-millonario
    26. pal-caserito
    27. pega-5
    28. polla-express
    29. ricachona
    30. ruca-vzla
    31. ruco
    32. ruleta-activa
    33. selva-plus
    34. tachira
    35. terminalito
    36. terminaltrio
    37. tigre-millonario
    38. trioactivo
    39. tropicalactivo
    40. uneloton
    41. zamorano
    42. zulia

* **Esquemas XML (XSD):** Se proporcionan esquemas XSD para definir la estructura y los tipos de datos para los mensajes XML de la API. Estos pueden ser utilizados por los implementadores para validar sus peticiones y respuestas. [cite: 127, 128]

    * Esquema para Petición de Autenticación [cite: 129]
    * Esquema para Respuesta de Autenticación [cite: 129]
    * Esquema para Respuesta de Tipos de Lotería [cite: 130]
    * Esquema para Respuesta de Juegos [cite: 130]
    * Esquema para Respuesta de Juegos por Tipo de Lotería [cite: 131]
    * Esquema para Respuesta de Error [cite: 131]
    * Esquema para Respuesta de Exportación [cite: 132]

## 11. Cómo Contribuir

Agradecemos cualquier contribución para mejorar esta especificación. Por favor, siga los siguientes pasos:

1.  Haga un fork del repositorio.
2.  Cree una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3.  Realice sus cambios.
4.  Realice un commit de sus cambios (`git commit -m 'feat: Añadir nueva funcionalidad'`).
5.  Haga push a la rama (`git push origin feature/nueva-funcionalidad`).
6.  Abra un Pull Request detallando los cambios propuestos.

## 12. Licencia

Este proyecto está bajo la Licencia MIT. Consulte el archivo [LICENSE](LICENSE) para más detalles.

---

**Autor:** Ing. Ben Gonzalez
**Fecha:** Julio, 2025
**Versión:** v1.2