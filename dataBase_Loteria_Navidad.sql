-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS loteria_navidad
USE loteria_navidad

-- Crear la tabla de Usuarios
CREATE TABLE OR REPLACE Usuarios (
    usuario VARCHAR(255) PRIMARY KEY,
    pass VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    nombre VARCHAR(255) NOT NULL
);
ALTER TABLE Usuarios
ADD CONSTRAINT chk_role (role IN ('admin', 'user'));

-- Crear la tabla de Decimos
CREATE OR REPLACE TABLE Decimos (
    numero INT,
    cantidad INT NOT NULL,
    fraccion VARCHAR(10) NOT NULL,
    serie VARCHAR(50) NOT NULL,
    usuario VARCHAR(255),
    FOREIGN KEY (usuario) REFERENCES Usuarios(usuario) on delete cascade
);

ALTER TABLE Decimos
add constraint dec_primaryk_pk primary key (numero, usuario);
