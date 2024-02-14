-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name
FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation 
FROM park
JOIN park_state ON park_state.park_id = park.park_id;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
--SELECT park_name, state_abbreviation 
SELECT park_name, state_name
FROM park
JOIN park_state ON park_state.park_id = park.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation;


-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city_name AS capital_name
FROM park
JOIN park_state ON park_state.park_id = park.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation
JOIN city ON city.city_id = state.capital;

-- Modify the previous query to include the area of each park.
SELECT park_name, state_name, city_name AS capital_name, park.area AS park_area
FROM park
JOIN park_state ON park_state.park_id = park.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation
JOIN city ON city.city_id = state.capital;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population AS city_population
FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE census_region = 'Midwest'
ORDER BY city_name;

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT count(*) AS number_of_cities, state_name
FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state.state_abbreviation
ORDER BY number_of_cities DESC

-- Modify the previous query to sort the results by the number of cities in descending order.


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established 
-- in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_name, MIN(park.date_established) AS earliest_park
FROM state
JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
JOIN park ON park.park_id = park_state.park_id
GROUP BY state.state_abbreviation
ORDER BY earliest_park;


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(park.date_established) AS earliest_park
FROM state
LEFT JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
LEFT JOIN park ON park.park_id = park_state.park_id
GROUP BY state.state_abbreviation, park_name
ORDER BY earliest_park;

-- Change the query to show only states that don't have parks
SELECT state_name, MIN(park.date_established) AS earliest_park
FROM state
LEFT JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
LEFT JOIN park ON park.park_id = park_state.park_id
WHERE park.park_id IS NULL
GROUP BY state.state_abbreviation
ORDER BY earliest_park;


-- Unions

-- rereive all place names (city and state) that start with a W
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%';

SELECT city_name AS place_name, 'city' AS kind_of_place
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name, 'state' AS kind_of_place
FROM state
WHERE state_name LIKE 'W%';

-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in 
-- pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
FROM genre;

-- The titles of all the Comedy movies
SELECT m.title
FROM movie m
JOIN movie_genre mg ON mg.movie_id = m.movie_id
JOIN genre g ON g.genre_id = mg.genre_id
WHERE g.genre_name = 'Comedy';

-- Display the Top 5 genres and the number of movies in each genre

SELECT COUNT(movie_id), genre_name
FROM genre
JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
GROUP BY genre.genre_id
ORDER BY count DESC
LIMIT 5;

-- How many times have each actor appeared together, ordered by the most to the least appearances

SELECT COUNT(*) AS number_of_movies, p1.person_name, p2.person_name 
FROM movie
JOIN movie_actor ma1 ON ma1.movie_id = movie.movie_id
JOIN movie_actor ma2 ON ma2.movie_id = movie.movie_id AND ma1.actor_id != ma2.actor_id
JOIN person p1 ON p1.person_id = ma1.actor_id
JOIN person p2 ON p2.person_id = ma2.actor_id
GROUP BY p1.person_id, p2.person_id;


