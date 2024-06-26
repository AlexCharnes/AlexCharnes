-- SELECT
-- Use a SELECT statement to return a literal string
SELECT 'This is a literal string';

-- Use a SELECT statement to add two numbers together (and label the result "sum")
SELECT 2 + 5 AS sum;


-- SELECT ... FROM
-- Write queries to retrieve...

-- The names from all the records in the state table
SELECT state_name 
FROM state;

-- The names and populations of all cities
SELECT city_name, population
from city;


-- All columns from the park table
SELECT *
FROM park;


-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
-- Note ASC is default
SELECT *
FROM state
ORDER BY population;

-- Change sort order to DESC to see largest to smallest
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
-- Note order of columns in the ORDER BY: census_region is the major sort, state_name the minor sort,
--   meaning it's sorted within the major column, i.e. census_region.
-- Note order of columns in the SELECT only controls order columns are returned (i.e. "displayed"), not sort order.
SELECT *
FROM state
ORDER BY census_region, state_name ASC;


-- The biggest park by area
-- Note that area isn't in the SELECT, but can be used in the ORDER BY
SELECT park_name
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population, area
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT *
FROM park
ORDER BY date_established, park_name
LIMIT 20;


-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
SELECT *
FROM city
WHERE state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California
SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation != 'CA';

-- The names and areas of cities smaller than 25 square kilometers
SELECT city_name, area
FROM city
WHERE area < 25;


-- The names from all records in the state table that have no assigned census region
SELECT *
FROM state 
WHERE census_region IS NOT null;

-- The names and census regions from all records in the state table that have an assigned census region
SELECT state_name, census_region
FROM state
WHERE census_region IS NOT NULL;


-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
SELECT city_name, area, population
FROM city
WHERE area < 25 AND population > 100000;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
SELECT state_name, census_region
FROM state
WHERE census_region != 'Midwest' OR census_region IS NULL
ORDER BY census_region, state_name
;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)
SELECT city_name, area, population
FROM city
WHERE state_abbreviation = 'CA' OR state_abbreviation = 'FL'
ORDER BY state_abbreviation, population;

-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
SELECT city_name, area, population
FROM city
WHERE state_abbreviation IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT');

-- CITIES NOT IN

SELECT *
FROM city
WHERE state_abbreviation NOT IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT');

-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"
SELECT park_name, (area * 1000) AS area_in_square_meters
FROM park;



-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)
SELECT city_name 
FROM city
ORDER BY city_name;

-- Do it again, but without the repeats (note the difference in row count)
SELECT DISTINCT(city_name) 
FROM city
ORDER BY city_name;


-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
SELECT  city_name
FROM city
WHERE city_name  LIKE 'A%';

-- The names of all cities that end with "Falls"
SELECT  city_name
FROM city
WHERE city_name  LIKE '%Falls';

-- The names of all cities that contain a space
SELECT  city_name
FROM city
WHERE city_name  LIKE '% %';

--can be complex as needed where % represents any characters
SELECT  city_name
FROM city
WHERE city_name  LIKE '%ol%m%us';
--is case sensative
SELECT  city_name
FROM city
WHERE city_name  LIKE 'a%';
--ILIKE IS NON CASE SENSATIVE
SELECT  city_name
FROM city
WHERE city_name  ILIKE 'a%';

-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers
SELECT *
FROM park
WHERE area BETWEEN 100 AND 200;


-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900
SELECT *
FROM park
WHERE date_established BETWEEN '1900-01-01' AND '1999-12-31';

SELECT *
FROM park
WHERE date_established < '1/1/1900';
