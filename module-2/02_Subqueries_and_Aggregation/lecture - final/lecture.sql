-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ' (' || state_abbreviation || ')') AS city_state_abbreviation
FROM city;

-- The all parks by name and date established.
SELECT ('Park Name: ' || park_name || ' Date Established: ' || date_established) AS park_name_and_date
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ' : ' || state_name) AS region_and_state
FROM state
WHERE census_region ILIKE '%west'
ORDER BY census_region;

-- round()
SELECT area / 3
FROM park;

SELECT round(area / 3, 4)
FROM park;

SELECT round(area / 3, 2)
FROM park;

SELECT round(area / 3, 0)
FROM park;

-- Casting data types
SELECT 10::varchar;

SELECT date_established::varchar FROM park;

SELECT '10'::int;

SELECT area::decimal 
FROM PARK;

-- SUBQUERIES

SELECT city_name, area, population
FROM city
WHERE state_abbreviation IN (
	SELECT state_abbreviation
	FROM state
	WHERE census_region = 'Northeast'
);


-- List all cities in the western census region
SELECT *
FROM city
WHERE state_abbreviation IN ( 
	SELECT state_abbreviation
	FROM state
	WHERE census_region = 'West' 
);


-- List all cities in states with "garden" in their nickname
SELECT *
FROM city
WHERE state_abbreviation IN (
	SELECT state_abbreviation
	FROM state
	WHERE state_nickname ILIKE '%garden%'
);

-- Get the parks with the smallest and largest areas
SELECT park_name, area
FROM park
WHERE area = (SELECT MIN(area) FROM park) 
OR area = (SELECT MAX(area) FROM park);

-- Get the state name and census region for all states with a national park
SELECT state_name, census_region
FROM state
WHERE state_abbreviation IN (
	SELECT DISTINCT state_abbreviation
	FROM park_state
)
ORDER BY census_region, state_name;


SELECT * 
FROM city
WHERE state_abbreviation = (
	SELECT state_abbreviation 
	FROM state
	WHERE state_nickname = 'Grand Canyon State'
);

-- Subqueries aren't limited to WHERE clauses, can appear in SELECT list (must return only 1 result)
-- Include state name rather than the state abbreviation while counting the number of cities in each state,
--   ordered from most cities to least.

SELECT city_name, (SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation)
FROM city;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_population
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(*)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS row_count 
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) AS number_of_cities
FROM city
GROUP BY state_abbreviation
ORDER BY number_of_cities DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT SUM(population), (
	SELECT (state_name || ' (' || state_abbreviation || ')') AS state 
	FROM state 
	WHERE state.state_abbreviation = city.state_abbreviation)
FROM city
GROUP BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT MIN(population) AS minimum_population, state_abbreviation
FROM city
GROUP BY state_abbreviation;


-- OFFSET sets a number of rows to skip at the beginning of the results
SELECT * 
FROM state
ORDER BY state_name
LIMIT 5 OFFSET 10;
