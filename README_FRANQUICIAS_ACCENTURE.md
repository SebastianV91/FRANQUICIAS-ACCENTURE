# 🏪 API Franquicias – Prueba Técnica Backend

Este proyecto corresponde a una **prueba técnica backend** desarrollada con:

- **Java 17**
- **Spring Boot WebFlux**
- **R2DBC + MySQL**
- **Programación reactiva (Mono/Flux)**
- **Docker**
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
   ├── java
   │   └── com/web/accentureprueba
   │       ├── controllers
   │       ├── service
   │       ├── repository
   │       ├── model
   |       ├── mapper
   │       ├── dto
   │       └── exception
   └── resources
        └── application.yml
       

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
CREATE DATABASE dbaccenture;
```

2. Configurar credenciales en `application.yml`.

3. Ejecutar:

```bash
mvn spring-boot:run
```

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


## 📦 Colección Postman

Incluida en el repositorio para pruebas manuales:

`franquicias-api.postman_collection.json`

---

## 🤝 Autor

**Sebastian Vergara**  
Backend Developer  
GitHub: https://github.com/SebastianV91
