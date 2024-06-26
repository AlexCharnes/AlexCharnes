-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

SELECT title
FROM collection
JOIN movie ON movie.collection_id = collection.collection_id
JOIN person ON person.person_id = movie.director_id
WHERE collection_name ILIKE 'Star Wars Collection' AND person_name != 'George Lucas'
ORDER BY title;