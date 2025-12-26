CREATE DATABASE dbaccenture;

CREATE TABLE franquicia (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE sucursal (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    franquicia_id BIGINT NOT NULL,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id)
);

CREATE TABLE producto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    sucursal_id BIGINT NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
);

INSERT INTO franquicia (id, nombre) VALUES
(1, 'Franquicias El Buen Sabor'),
(2, 'TecnoWorld Group'),
(3, 'Moda Urbana LATAM');

INSERT INTO sucursal (id, nombre, franquicia_id) VALUES
-- El Buen Sabor
(1, 'Sucursal Centro', 1),
(2, 'Sucursal Norte', 1),
(3, 'Sucursal Sur', 1),

-- TecnoWorld Group
(4, 'Sucursal Bogotá', 2),
(5, 'Sucursal Medellín', 2),

-- Moda Urbana LATAM
(6, 'Sucursal Andino', 3),
(7, 'Sucursal Santafé', 3),
(8, 'Sucursal Online', 3);

INSERT INTO producto (id, nombre, stock, sucursal_id) VALUES
-- El Buen Sabor - Centro
(1, 'Hamburguesa Clásica', 120, 1),
(2, 'Papas Fritas', 300, 1),
(3, 'Gaseosa Cola', 200, 1),

-- El Buen Sabor - Norte
(4, 'Hamburguesa Doble', 90, 2),
(5, 'Nuggets de Pollo', 180, 2),
(6, 'Malteada', 75, 2),

-- El Buen Sabor - Sur
(7, 'Hamburguesa Vegana', 60, 3),
(8, 'Ensalada César', 110, 3),

-- TecnoWorld - Bogotá
(9, 'Laptop Gamer', 45, 4),
(10, 'Monitor 27 pulgadas', 80, 4),
(11, 'Teclado Mecánico', 150, 4),

-- TecnoWorld - Medellín
(12, 'Mouse Inalámbrico', 220, 5),
(13, 'Webcam HD', 95, 5),

-- Moda Urbana - Andino
(14, 'Camiseta Oversize', 180, 6),
(15, 'Jean Slim Fit', 95, 6),
(16, 'Chaqueta Denim', 60, 6),

-- Moda Urbana - Santafé
(17, 'Sudadera Urbana', 140, 7),
(18, 'Gorra Snapback', 210, 7),

-- Moda Urbana - Online
(19, 'Camiseta Básica', 500, 8),
(20, 'Pantalón Jogger', 320, 8),
(21, 'Hoodie Unisex', 260, 8);

