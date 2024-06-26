-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT title
FROM movie
JOIN person ON person.person_id = movie.director_id
WHERE person_name ILIKE 'James Cameron'
ORDER BY title