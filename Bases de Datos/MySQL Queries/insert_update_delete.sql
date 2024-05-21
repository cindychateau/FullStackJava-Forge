SELECT * FROM usuarios;

-- Guardar nuevo registro
-- INSERT INTO tabla (columna1, columna2...) VALUES ('Valor1', Valor2...);
INSERT INTO usuarios (edad, nombre, direccion_id) VALUES (20, 'Cande', 4);

-- Actualizar un registro
-- UPDATE tabla SET columna1 = Valor1, columna2 = Valor2 WHERE condicional;
UPDATE usuarios SET nombre = 'Juanita', edad = 19 WHERE id = 8;

-- Eliminar un registro
-- DELETE FROM tabla WHERE condicional;
DELETE FROM usuarios WHERE id = 11;