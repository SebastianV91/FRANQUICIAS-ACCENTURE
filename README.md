🏪 API Franquicias – Prueba Técnica Backend

API REST desarrollada como parte de una prueba técnica para desarrollador Backend, utilizando Java 17, Spring Boot WebFlux y MySQL, con enfoque en programación reactiva (non-blocking).

🧠 Descripción del problema

Se requiere construir un API para manejar una lista de franquicias, donde:

Una franquicia tiene múltiples sucursales

Una sucursal tiene múltiples productos

Un producto tiene nombre y cantidad de stock

La API permite:

Crear y administrar franquicias, sucursales y productos

Modificar stock

Obtener el producto con mayor stock por sucursal para una franquicia específica

🛠️ Tecnologías utilizadas

Java 17

Spring Boot 3

Spring WebFlux

Spring Data R2DBC

MySQL

Docker

Postman

Lombok

⚙️ Arquitectura

El proyecto sigue una arquitectura por capas:

controller → service → repository


Principios aplicados:

Programación reactiva real (Mono / Flux)

No uso de JPA (se usa R2DBC)

Separación clara de responsabilidades

Manejo global de errores

Endpoints REST claros y documentados

🚀 Cómo ejecutar el proyecto
🔹 Opción 1: Ejecutar con Docker (recomendado)
Requisitos

Docker

Docker Compose

Pasos
docker-compose up --build


La aplicación quedará disponible en:

http://localhost:8080

🔹 Opción 2: Ejecutar localmente
Requisitos

Java 17

MySQL 8+

Maven

Crear base de datos
CREATE DATABASE dbaccenture;

Configurar application.yml
spring:
  r2dbc:
    url: r2dbc:mysql://localhost:3306/dbaccenture
    username: root
    password: 12345678

Ejecutar
mvn spring-boot:run

🔗 Endpoints principales
Franquicias

POST /api/franquicias

GET /api/franquicias/{franquiciaId}/productos/max-stock

Sucursales

POST /api/franquicias/{franquiciaId}/sucursales

Productos

POST /api/sucursales/{sucursalId}/productos

PUT /api/sucursales/{sucursalId}/productos/{productoId}/stock

DELETE /api/sucursales/{sucursalId}/productos/{productoId}

📦 Colección Postman

Se incluye una colección Postman con todos los endpoints para facilitar las pruebas manuales.

📄 Archivo:

franquicias-api.postman_collection.json

🧩 Manejo de errores

La API implementa manejo global de errores con:

404 Not Found para recursos inexistentes

500 Internal Server Error para errores no controlados

Ejemplo de respuesta:

{
  "error": "Producto no encontrado"
}

🧠 Decisiones técnicas relevantes

WebFlux + R2DBC para mantener un flujo non-blocking

Separación de lógica de negocio en servicios

Uso de operadores reactivos (flatMap, map, switchIfEmpty)

Docker para facilitar despliegue y ejecución

👨‍💻 Autor

Sebastian Vergara
Desarrollador Backend
Prueba técnica – Accenture
