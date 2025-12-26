# 🏪 API Franquicias – Prueba Técnica Backend

Este proyecto corresponde a una **prueba técnica backend** desarrollada con:

- **Java 17**
- **Spring Boot WebFlux**
- **R2DBC + MySQL**
- **Programación reactiva (Mono/Flux)**
- **Docker**
- **Swagger / OpenAPI**
- **WebTestClient para testing**
- **Postman para pruebas manuales**

📍 Repositorio oficial:  
https://github.com/SebastianV91/FRANQUICIAS-ACCENTURE

---

## 🧠 Objetivo

Construir una API REST que permita:

- Registrar **franquicias**
- Crear **sucursales** por franquicia
- Agregar **productos** por sucursal
- Modificar stock y nombres
- Eliminar productos
- Obtener el **producto con mayor stock por sucursal** para una franquicia

El enfoque se centra en **programación reactiva**, diseño limpio y buenas prácticas backend.

---

## 🛠️ Tecnologías

| Componente | Tecnología |
|-----------|------------|
| Lenguaje | Java 17 |
| Framework | Spring Boot WebFlux |
| Persistencia | R2DBC + MySQL |
| Tests | WebTestClient |
| Documentación | Swagger |
| API Manual | Postman |
| Contenedores | Docker / Docker Compose |

---

## 📦 Estructura del Proyecto

```
src
├── main
│   ├── java
│   │   └── com/web/accentureprueba
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── model
│   │       ├── dto
│   │       └── exception
│   └── resources
│       ├── application.yml
│       └── schema.sql
└── test
    ├── java
    │   └── com/web/accentureprueba
    └── resources
        ├── application-test.yml
        └── data-test.sql
```

---

## 🚀 Ejecución

### 🐳 Con Docker

```bash
docker-compose up --build
```

Acceso:
```
http://localhost:8080
```

---

### 💻 Ejecución local

1. Crear base de datos:

```sql
CREATE DATABASE franquicias_db;
```

2. Ejecutar script `schema.sql` en MySQL.

3. Configurar credenciales en `application.yml`.

4. Ejecutar:

```bash
mvn spring-boot:run
```

---

## 📚 Documentación API

Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

---

## 📋 Endpoints principales

### Franquicias
- `POST /api/franquicias`
- `PATCH /api/franquicias/{id}/nombre`

### Sucursales
- `POST /api/franquicias/{id}/sucursales`
- `PATCH /api/sucursales/{id}/nombre`

### Productos
- `POST /api/sucursales/{id}/productos`
- `PATCH /api/productos/{id}/stock`
- `PATCH /api/productos/{id}/nombre`
- `DELETE /api/productos/{id}`

### Reportes
- `GET /api/franquicias/{id}/productos/max-stock`

---

## 🧪 Tests

Los tests se implementan con **WebTestClient** y un perfil `test` separado.

```bash
mvn test
```

---

## 📦 Colección Postman

Incluida en el repositorio para pruebas manuales:

`franquicias-api.postman_collection.json`

---

## 🤝 Autor

**Sebastian Vergara**  
Backend Developer  
GitHub: https://github.com/SebastianV91
