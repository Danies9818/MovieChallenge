
# Movie API Application

## Descripción
Esta aplicación es una API REST desarrollada en **Spring Boot** que interactúa con una API externa para obtener información sobre películas y almacenarla en una base de datos **H2**. Además, ofrece endpoints para consultar directores, escritores y actores que cumplen ciertos criterios.

## Características
1. Consulta una API externa de películas.
2. Almacena los datos en una base de datos en memoria H2.
3. Ofrece endpoints REST documentados con Swagger para:
    - Obtener directores con un número mínimo de películas dirigidas.

## Tecnologías
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI** (Swagger UI)

## Endpoints
### 1. Obtener Directores con un Mínimo de Películas
- **URL**: `/directors`
- **Método**: `GET`
- **Parámetros**:
    - `minMovies` (query, requerido): Número mínimo de películas dirigidas.
- **Respuesta**:
  ```json
  [
    "Woody Allen",
    "Martin Scorsese",
    "Quentin Tarantino"
  ]
  ```
- **Códigos de Estado**:
    - `200 OK`: Listado de directores obtenido exitosamente.
    - `400 Bad Request`: Parámetros inválidos.
    - `500 Internal Server Error`: Error en el servidor.

## Configuración
### Dependencias Clave
Incluye las siguientes dependencias en `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>2.2.16</version>
</dependency>
```

### Configuración en `application.properties`
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

## Base de Datos
- La base de datos utilizada es **H2** en memoria.
- Acceso a la consola H2: `http://localhost:8080/h2-console`.
- Configuración predeterminada:
    - Usuario: `sa`
    - Contraseña: `password`

### Esquema de la Tabla
Tabla `movie_entity`:
```
| Campo      | Tipo      | Descripción             |
|------------|-----------|-------------------------|
| id         | BIGINT    | Clave primaria          |
| title      | VARCHAR   | Título de la película   |
| year       | VARCHAR   | Año de lanzamiento      |
| rated      | VARCHAR   | Clasificación           |
| released   | VARCHAR   | Fecha de lanzamiento    |
| runtime    | VARCHAR   | Duración de la película |
| genre      | VARCHAR   | Género de la película   |
| director   | VARCHAR   | Director                |
| writer     | VARCHAR   | Escritor                |
| actors     | VARCHAR   | Actores principales     |
```
## Documentación Swagger
Swagger UI está habilitado en `http://localhost:8080/swagger-ui.html`.

## Ejecución
1. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```
2. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
3. Accede a los endpoints usando herramientas como Postman o Swagger UI.
   http://localhost:8080/swagger-ui

## Autor
Daniel Bustamante
