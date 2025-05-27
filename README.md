- **Versión JDK:** 17
- **Framework:** Spring Boot
- **Autenticación:** Bearer Token utilizando JWT
- **Base de Datos:** Oracle (soportando SGBD)

# Desarrollo #1

Crear un servicio REST que realice una llamada a otra API REST externa. La llamada debe incluir un Bearer Token para la autenticación. El servicio debe manejar la respuesta de la API externa y retornar los datos al cliente

# Desarrollo #2

Crear un servicio REST que reciba una solicitud del cliente, realice una consulta SQL a la base de datos Oracle y retorne una lista de objetos como respuesta. La consulta debe ser eficiente y el servicio debe manejar posibles excepciones de la base de datos

# Desarrollo #3

Crear un servicio REST que reciba una solicitud del cliente, llame a un procedimiento o función PL/SQL en la base de datos Oracle y retorne una lista de objetos como respuesta. El servicio debe manejar posibles excepciones y asegurar la eficiencia en la llamada a la base de datos



Estructura del Proyecto

```
springboot-rest-services
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── cajasan
│   │   │           └── practicante
│   │   │               ├── ActividadandresApplication.java
│   │   │               ├── config
│   │   │               │   └── OracleConfig.java
│   │   │               ├── controller
│   │   │               │   ├── ExternalApiController.java
│   │   │               │   ├── OracleQueryController.java
│   │   │               │   └── PlsqlProcedureController.java
│   │   │               ├── service
│   │   │               │   ├── ExternalApiService.java
│   │   │               │   ├── OracleQueryService.java
│   │   │               │   └── PlsqlProcedureService.java
│   │   │               ├── repository
│   │   │               │   ├── OracleQueryRepository.java
│   │   │               │   └── PlsqlProcedureRepository.java
│   │   │               └── model
│   │   │                   └── ExampleModel.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── logback-spring.xml
│   └── test
│       └── java
│           └── com
│               └── cajasan
│                   └── practicante
│                       └── ActividadandresApplicationTests.java
├── pom.xml
└── README.md
```

## Componentes del Proyecto

- **ActividadandresApplication.java**: Punto de entrada de la aplicación Spring Boot.
- **OracleConfig.java**: Configuración para la conexión a la base de datos Oracle.
- **ExternalApiController.java**: Controlador REST para manejar solicitudes a una API externa.
- **OracleQueryController.java**: Controlador REST para realizar consultas SQL a la base de datos Oracle.
- **PlsqlProcedureController.java**: Controlador REST para llamar a procedimientos PL/SQL en la base de datos Oracle.
- **ExternalApiService.java**: Servicio que encapsula la lógica para realizar llamadas a la API externa.
- **OracleQueryService.java**: Servicio que encapsula la lógica para realizar consultas SQL a la base de datos Oracle.
- **PlsqlProcedureService.java**: Servicio que encapsula la lógica para llamar a procedimientos PL/SQL.
- **OracleQueryRepository.java**: Repositorio para interactuar con la base de datos y realizar consultas SQL.
- **PlsqlProcedureRepository.java**: Repositorio para interactuar con la base de datos y llamar a procedimientos PL/SQL.
- **ExampleModel.java**: Modelo de datos utilizado en el proyecto.
- **application.properties**: Configuración de la aplicación, incluyendo propiedades de conexión a la base de datos.
- **logback-spring.xml**: Configuración para el registro de logs.
- **ActividadandresApplicationTests.java**: Pruebas unitarias para la aplicación.
- **pom.xml**: Archivo de configuración de Maven que define las dependencias del proyecto.

## Instrucciones para Ejecutar el Proyecto

1. Clona el repositorio en tu máquina local.

2. Asegúrate de tener Java y Maven instalados.

3. Configura las propiedades de conexión a la base de datos en `src/main/resources/application.properties`.

4. Ejecuta el proyecto utilizando el comando:
   
   ```
   mvn spring-boot:run
   ```

5. Accede a los servicios REST a través de `http://localhost:8080`.

## Notas

- Asegúrate de tener acceso a la API externa y a la base de datos Oracle para que los servicios funcionen correctamente.
- Revisa los logs para cualquier error o advertencia durante la ejecución.
