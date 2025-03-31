# My Spring Starter

A simple Spring application with PostgreSQL designed to teach Spring fundamentals, including controllers, services, DTOs, DAOs, and repositories.
- Spring uses the `inversion of control` design, which lets spring handle the object creation and makes it event-driven (sort of).
- It uses `Autowiring` to achieve dependency injection (i.e. it creates the objects and passes them into the correct contructors at runtime)
## Files and Directories

- **`pom.xml`**: Maven project configuration file with dependencies and plugins.
- **`extras/prepare-db.sh`**: Shell script for setting up a Postgres database in Docker and populating it with mock data.
- **`src/`**: Source code of the application.
    - **`src/main/java/com/example/app/`**: Contains the main application code.
        - **`Application.java`**: Entry point for the Spring Boot application.
        - **`controllers/`**: Defines the REST API endpoints for handling HTTP requests.
        - **`dao/`**: Contains methods for interacting with the database.
        - **`dto/`**: Defines data transfer objects used to move data between layers.
        - **`repository/`**: Contains the actual database queries and CRUD operations.
        - **`service/`**: Contains business logic that handles requests from the controller.
    - **`src/main/resources/application.yml`**: Configuration file for Spring Boot settings.
    - **`src/test/java/com/example/app/`**: Contains unit tests for the application.

## Application Flow

1. **Spring Boot Application**: The application starts and initializes the beans.
2. **Controller Layer**: Defines REST endpoints and communicates with the service layer.
3. **DTO (Data Transfer Object)**: Moves data between controller and service layers.
4. **Service Layer**: Contains the business logic and interacts with the DAO layer.
5. **DAO (Data Access Object)**: Interacts with the database using JPA.
6. **Repository Layer**: Executes the database queries and provides CRUD operations.

## What are these fancy terms?

- **DTO**: A simple object used to transfer data between layers, typically with getter/setter methods.
- **DAO**: Responsible for database interactions, abstracting the details of the queries.
- **Service**: Contains the business logic and is called by the controller.
- **Repository**: Directly interacts with the database for CRUD operations.

## Running the Application locally

1. **Set up the Database**: Run the `prepare-db.sh` script to set up a Docker container with Postgres and mock data.
   ```bash
   ./extras/prepare-db.sh
2. **Run the Application**: Go to `edit run configurations` in IntelliJ and add these environment variables
   ```
   DB_HOST=localhost;DB_PORT=5432;DB_NAME=studentdb;DB_USERNAME=testusername;DB_PASSWORD=testpassword;PORT=8080
    ```
    Make sure to replace these values as needed

## Deployment/Production Setup

1. Dockerizing is the recommended way to deploy a spring application.
2. Implement CI/CD such that the version in pom.xml gets updated every time you create a release