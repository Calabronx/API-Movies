CREATE TABLE IF NOT EXISTS Movies (
MovieID int,
MovieTitles varchar(255)
);

DELETE FROM Movies;

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (1, 'Gladiador');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (2, 'Superman');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (3, 'Batman');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (4, 'El Padrino');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (5, 'La naranja Mecanica');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (6, 'El Resplandor');

INSERT INTO MOVIES(MovieID, MovieTitles)
VALUES (7, 'Misery');

SELECT MovieTitles from Movies;