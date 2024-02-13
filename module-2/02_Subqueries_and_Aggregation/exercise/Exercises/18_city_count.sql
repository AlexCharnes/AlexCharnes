-- 18. The count of the number of cities (name column 'num_cities') 
-- and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)

SELECT state_abbreviation, COUNT(city_name) AS num_cities
FROM city
WHERE state_abbreviation IN (SELECT state_abbreviation
										 FROM state
										 WHERE state_abbreviation NOT IN ('DC')
										) 

GROUP BY state_abbreviation
ORDER BY state_abbreviation;

