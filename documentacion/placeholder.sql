-- Insertar usuarios
INSERT INTO Usuarios (usuario, pass, role, nombre) VALUES
('usuario1', 'clave1', 'admin', 'Nombre1'),
('usuario2', 'clave2', 'user', 'Nombre2'),
('usuario3', 'clave3', 'user', 'Nombre3'),
('usuario4', 'clave4', 'admin', 'Nombre4'),
('usuario5', 'clave5', 'user', 'Nombre5'),
('usuario6', 'clave6', 'user', 'Nombre6'),
('usuario7', 'clave7', 'admin', 'Nombre7'),
('usuario8', 'clave8', 'user', 'Nombre8'),
('usuario9', 'clave9', 'user', 'Nombre9'),
('usuario10', 'clave10', 'admin', 'Nombre10');

-- Insertar decimos
INSERT INTO Decimos (numero, grupo, cantidad, fraccion, serie, usuario) VALUES
(12345, 'Grupo1', 5, 'A', 'Serie1', 'usuario1'),
(67890, 'Grupo2', 3, 'B', 'Serie2', 'usuario2'),
(11111, 'Grupo3', 8, 'C', 'Serie3', 'usuario3'),
(99999, 'Grupo4', 2, 'D', 'Serie4', 'usuario4'),
(55555, 'Grupo5', 6, 'E', 'Serie5', 'usuario5'),
(77777, 'Grupo6', 4, 'F', 'Serie6', 'usuario6'),
(44444, 'Grupo7', 7, 'G', 'Serie7', 'usuario7'),
(22222, 'Grupo8', 9, 'H', 'Serie8', 'usuario8'),
(33333, 'Grupo9', 1, 'I', 'Serie9', 'usuario9'),
(66666, 'Grupo10', 10, 'J', 'Serie10', 'usuario10');