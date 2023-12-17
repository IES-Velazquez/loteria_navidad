-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS loteria_navidad;
USE loteria_navidad;

-- Crear la tabla de Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    usuario VARCHAR(255) PRIMARY KEY,
    pass VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    nombre VARCHAR(255) NOT NULL
);
ALTER TABLE Usuarios
ADD CONSTRAINT chk_role CHECK (role IN ('admin', 'user'));

-- Crear la tabla de Decimos
CREATE TABLE IF NOT EXISTS Decimos (
    numero INT,
    grupo VARCHAR(60),
    cantidad INT NOT NULL,
    fraccion VARCHAR(10) NOT NULL,
    serie VARCHAR(50) NOT NULL,
    usuario VARCHAR(255),
    FOREIGN KEY (usuario) REFERENCES Usuarios(usuario) ON DELETE CASCADE
);

ALTER TABLE Decimos
ADD CONSTRAINT dec_primaryk_pk PRIMARY KEY (numero, usuario);
