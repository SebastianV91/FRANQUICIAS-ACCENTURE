# 🏪 API Franquicias – Prueba Técnica Backend

Este proyecto corresponde a una **prueba técnica backend** desarrollada con:

- **Java 17**
- **Spring Boot WebFlux**
- **R2DBC + MySQL**
- **Programación reactiva (Mono/Flux)**
- **Docker**
- **Postman para pruebas manuales**
- **Despliegue en la nube con Railway**
  
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
| API Manual | Postman |
| Contenedores | Docker / Docker Compose |
| Cloud | Railway |
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
- `PUT /api/franquicias/{franquiciaId}/nombre`

### Sucursales
- `POST /api/sucursales/{franquiciaId}`
- `PUT /api/sucursales/{sucursalId}/nombre`

### Productos
- `POST /api/productos/{sucursalId}`
- `PUT /api/productos/{productoId}/stock`
- `PUT /api/productos/{ProductoId}/nombre`
- `DELETE /api/productos/{productoId}`

### Reportes
- `GET /api/reporte/{franquiciaId}/productos/max-stock`

---

## ☁️ Despliegue en la Nube (Railway)

Este proyecto se encuentra desplegado en **Railway**, una plataforma de cloud que permite desplegar aplicaciones backend de forma sencilla.

### 🔹 Pasos generales de despliegue

1. Configurar las siguientes variables de entorno en motor de bases de datos MySQL:

```env
SPRING_R2DBC_URL=r2dbc:mysql://shortline.proxy.rlwy.net:26374/railway
SPRING_R2DBC_USERNAME=root
SPRING_R2DBC_PASSWORD=GDgSlDbebNRRyRFviVIddSaTttplrLcm
```

2. Railway detecta automáticamente el proyecto Spring Boot y realiza el build.

### 🌍 URL pública

La API queda disponible públicamente en una URL similar a:

```
https://franquicias-accenture-production.up.railway.app
```
Despues de ingresar el link agregar sus respectivos endpoints para ir probando los microservicios

> ⚠️ La URL puede variar dependiendo del entorno y el proyecto.

---

## 🤝 Autor

**Sebastian Vergara**  
Backend Developer  
GitHub: https://github.com/SebastianV91
