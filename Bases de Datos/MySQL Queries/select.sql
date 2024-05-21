-- SELECT: Permite seleccionar información de una tabla
-- Queries = Consultas

SELECT * FROM usuarios; -- SELECT * FROM tabla; Todas las columnas

SELECT nombre, edad FROM usuarios; -- SELECT columna1, columna2 FROM tabla; Muestra columnas específicas

SELECT nombre, edad FROM usuarios WHERE id = 2; -- SELECT columna1 FROM tabla WHERE condicional;

select * from usuarios where edad > 25;

SELECT * FROM usuarios WHERE nombre LIKE "Martina";

SELECT nombre FROM usuarios WHERE nombre LIKE "ÁL%"; -- % = comodin; Puede tener cualquier letra

-- Todas las columnas de la tabla de usuarios donde el nombre termina en o
SELECT * FROM usuarios WHERE nombre LIKE "%o"; 

-- && AND: Ambas condicionales se cumplen
SELECT * FROM usuarios WHERE nombre LIKE "%o" AND edad > 23;

-- || OR: Una u otra se debe de cumplir
SELECT * FROM usuarios WHERE nombre LIKE "%o" OR edad > 23;

-- SELECT columna FROM tabla WHERE condicional ORDER BY columna ASC/DESC;
SELECT * FROM usuarios WHERE nombre LIKE "%o" ORDER BY edad DESC; -- ASC DESC

SELECT * FROM usuarios WHERE edad > 25 ORDER BY nombre ASC; -- ASC (A-Z), DESC (Z-A)

SELECT * FROM usuarios WHERE edad > 25 ORDER BY nombre ASC LIMIT 1, 3; -- inicio, cantidad

SELECT nombre, edad FROM usuarios LIMIT 0, 5;

-- SELECT columna1, columna2 FROM tabla
-- WHERE condicional (AND OR)
-- ORDER BY columna1 ASC/DESC
-- LIMIT inicio, cantidad

SELECT COUNT(nombre) FROM usuarios;
