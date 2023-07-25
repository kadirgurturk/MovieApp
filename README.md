# MovieApp


### MovieApp is a Java Spring Boot application used to manage information about movie directors and their films. The application utilizes a PostgreSQL database and enhances performance using Redis cache.
### This project was assigned as a homework for the [C System Programmers Association ](https://csystem.org/) Java II course 

## Features

- Add, edit, and delete directors and their films.
- Manage the relationship between directors and films.
- Filter films by their name, IMDB rating, and director's name.
- Pagination and sorting features are available.
- Data is stored in a PostgreSQL database, and performance is improved using Redis cache.

## Getting Started

### Prerequisites

- Java 11 or above
- PostgreSQL database
- Redis

### Installation

1. Copy the project files to your computer.
2. Create your PostgreSQL database and update the database connection details in the `application.properties` file.
3. Start the Redis server and update the Redis connection details in the `application.properties` file.
4. Run the application: `./mvnw spring-boot:run`

### Usage

Once the application is successfully running, you can test the APIs using the following URLs:

- List directors: `GET /api/directors`
- View director details: `GET /api/directors/{id}`
- Add a director: `POST /api/directors`
- Update a director: `PUT /api/directors/{id}`
- Delete a director: `DELETE /api/directors/{id}`

- List movies: `GET /api/movies`
- View movie details: `GET /api/movies/{id}`
- Add a movie: `POST /api/movies`
- Update a movie: `PUT /api/movies/{id}`
- Delete a movie: `DELETE /api/movies/{id}`

- View movies associated with a director: `GET /api/directors/{id}/movies`
- View directors associated with a movie: `GET /api/movies/{id}/directors`


