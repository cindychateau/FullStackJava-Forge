SELECT name, language, percentage FROM countries
JOIN languages ON countries.id = country_id
WHERE language = "Slovene"
ORDER BY percentage DESC;

SELECT COUNT(cities.id) as Total_Ciudades, countries.name FROM countries
JOIN cities ON country_id = countries.id
GROUP BY country_id
ORDER BY Total_Ciudades DESC;

SELECT cities.name, cities.population FROM cities
JOIN countries ON country_id = countries.id
WHERE countries.name = "Mexico" AND cities.population > 500000
ORDER BY cities.population DESC;

SELECT name, population FROM cities
WHERE country_code = "MEX" AND population > 500000
ORDER BY population DESC;

SELECT languages.id, name, language, percentage FROM languages
JOIN countries ON country_id = countries.id -- country_code = countries.code
WHERE percentage > 89
ORDER BY percentage DESC;

SELECT * FROM languages
JOIN countries as c ON c.id = languages.country_id WHERE percentage > 89
ORDER BY percentage DESC;

SELECT countries.name, countries.surface_area, countries.population FROM countries
WHERE countries.surface_area < 501 AND countries.population > 100000;

SELECT * FROM countries 
WHERE government_form = 'Constitutional Monarchy'
AND capital > 200 AND life_expectancy > 75;

SELECT countries.name, cities.name, district, cities.population
FROM cities
JOIN countries ON cities.country_id = countries.id
WHERE countries.name = "Argentina" AND district = "Buenos Aires" AND cities.population > 500000;

SELECT region, COUNT(code) as paises FROM countries
GROUP BY region 
ORDER BY paises DESC;

