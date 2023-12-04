# Spring-Boot-Programming-Languages-Course-Application

This project represents a Spring Boot backend application structured as follows:

- **business**: This component houses the business logic, incorporating the service layer.

- **core.utilities.mappers**: Within this package, there is a Model Mapper interface (service), along with its implementation, the Model Mapper Manager.

- **dtos**: This package implements the Response-Request pattern, containing the Data Transfer Objects (DTOs).

- **dataAccess**: The data access layer includes the repositories.

- **entities**: Entity classes, representing the database tables.

- **webApi**: The web API layer encompasses the controllers responsible for handling HTTP requests.

## CRUD Operations

This project supports fundamental CRUD (Create, Read, Update, Delete) operations. The corresponding endpoints are as follows:

- **CREATE (Create)**: `POST /api/programmingLanguages`
- **READ (Read)**: `GET /api/programmingLanguages/getById/{id}`
- **UPDATE (Update)**: `PUT /api/programmingLanguages/update`
- **DELETE (Delete)**: `DELETE /api/programmingLanguages/delete/{id}`


## N-Layered Architecture

The project adopts the principles of N-Layered architecture:

1. **Controller Layer**: Responsible for handling HTTP requests and providing responses.
2. **Service Layer**: Responsible for executing the business logic and handling exceptions.
3. **Repository Layer**: Performs database operations.
4. **DTO Layer**: Implements Data Transfer Objects for seamless data exchange.
5. **Entity Layer**: Contains entity classes representing database tables.

This layered structure enhances code readability and maintainability.

## Model Mapper

The project utilizes the Model Mapper library to facilitate seamless conversion between entities and DTOs. This simplifies data transfer between the database and API.

## Spring Data JPA Entity Mapping

Spring Data JPA automates the mapping between database tables and Java classes. Entity classes serve as representations of tables and are managed units by JPA.

## Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- Model Mapper

## Getting Started

1. Clone the project to your local machine.
2. Open the project in an IDE (IntelliJ IDEA, Eclipse, etc.).
3. Perform necessary configuration checks, such as verifying database configurations or any external dependencies.
4. Run the `Application.java` class to start the application.
5. Visit `http://localhost:8080/swagger-ui.html` in your browser to explore and test the API. (Alternatively, you can use Postman if you are familiar with it.)
