SELECT * FROM usuarios;

-- Union entre usuarios y direcciones (1:1)
-- JOIN con direccion_id (llave foránea de usuarios) = direcciones.id (llave primaria de direcciones)
SELECT * FROM usuarios
JOIN direcciones ON direcciones.id = usuarios.direccion_id; -- No haya conflicto. Especificando de qué tabla es el id

-- Unión entre pedidos y usuarios (1:n)
-- JOIN con usuario_id (llave foránea de pedidos) = usuarios.id (llave primaria de direcciones)
SELECT * FROM pedidos
JOIN usuarios ON usuario_id = usuarios.id; -- INNER JOIN

SELECT * FROM usuarios
LEFT JOIN pedidos ON usuario_id = usuarios.id;

-- Unión entre usuarios, usuarios_has_hobbies y hobbies (n:m) 
-- PK = Llave primaria(primarykey). FK = Llave Foránea (foreignkey)
-- 2 JOINS
-- 1.- JOIN usuarios y usuarios_has_hobbies -> usuarios.id (PK usuarios) = usuario_id (FK usuarios_has_hobbies)
-- 2.- JOIN usuarios_has_hobbies y hobbies -> hobbie_id (FK usuarios_has_hobbies) = hobbies.id (PK hobbies)
SELECT nombre, actividad FROM usuarios
JOIN usuarios_has_hobbies ON usuarios.id = usuario_id
JOIN hobbies ON hobbie_id = hobbies.id
ORDER BY nombre ASC; -- A-Z



