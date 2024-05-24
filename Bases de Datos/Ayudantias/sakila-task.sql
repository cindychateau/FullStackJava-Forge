-- Punto 2

SELECT title, description, release_year, rating, special_features, c.name FROM film f 
JOIN film_category fc ON f.film_id = fc.film_id 
JOIN category c ON c.category_id = fc.category_id 
WHERE c.name = "Comedy";

SELECT title, film.description, release_year, rating, special_features, name FROM film 
JOIN category ON category_id = 5;

-- Punto 3

SELECT a.actor_id, a.first_name, f.title, f.description, f.release_year FROM film f 
INNER JOIN film_actor fa ON fa.film_id = f.film_id
INNER JOIN actor a ON a.actor_id = fa.actor_id 
WHERE a.actor_id = 5;

-- Punto 4 

select first_name, last_name, email, address from customer as c
join address as a on c.address_id = a.address_id
join city as ci on a.city_id = ci.city_id 
where c.store_id = 1 and ci.city_id in (1, 42, 312, 459);

SELECT first_name,last_name,email,address FROM address
-- INNER JOIN store ON store.address_id= address.address_id
INNER JOIN city ON city.city_id= address.city_id
INNER JOIN customer ON customer.address_id = address.address_id
WHERE store.store_id = 1 AND city.city_id IN (1,42,312,459);

-- Punto 5

SELECT title, description, release_year, rating, special_features FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE rating = 'G' AND special_features LIKE 'BEHIND%' AND actor.actor_id = 15;

SELECT title, description, release_year, rating, special_features FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
WHERE fa.actor_id = 15 AND f.rating = 'G' AND f.special_features LIKE '%Behind the Scenes%';

-- Punto 6

SELECT film.film_id, title, actor.actor_id, first_name FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE film.film_id = 369;

-- Punto 7

SELECT title, description, rating, special_features, category.name FROM film
INNER JOIN film_category on film.film_id = film_category.film_id
INNER JOIN category on film_category.category_id = category.category_id
WHERE category.name = "Drama" AND rental_rate = 2.99;

-- Punto 8

SELECT title, description, release_year, rating, special_features, category.name, first_name, last_name FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON  actor.actor_id = film_actor.actor_id
INNER JOIN film_category on film.film_id = film_category.film_id
INNER JOIN category on film_category.category_id = category.category_id
WHERE first_name LIKE 'SANDRA' AND last_name LIKE 'KILMER' AND category.name = 'Action';

