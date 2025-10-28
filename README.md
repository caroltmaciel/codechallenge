# SpringBoot Application

A SpringBoot 3.5 application with Java 18 using PostgreSQL as database.

## Prerequisites

- Java 18
- SpringBoot 3.5
- PostgreSQL database

## Setup Instructions

1. **Database Configuration**
    - Ensure PostgreSQL is running
    - The application will automatically create the necessary tables
    - If needed, configure the database connection in `application.properties`:
      ```properties
      spring.datasource.url=YOUR_DATABASE_URL
      spring.datasource.username=YOUR_USERNAME
      spring.datasource.password=YOUR_PASSWORD
      ```

## API Endpoints

### Client Management

- **POST** `/clients` - Create a customer or company
- **DELETE** `/clients/{id}` - Delete a customer or company
- **GET** `/clients/{id}` - Get a customer or company by ID
- **PUT** `/clients/{id}` - Update a customer or company

### Contract Management

- **POST** `/clients/{id}/contracts` - Create a contract for a customer or company
- **GET** `/clients/{id}/contracts` - Get all contracts for a customer or company
- **GET** `/clients/{id}/contracts/sum` - Calculate the sum of valid contracts for a customer or company
- **PATCH** `/clients/{id}/contracts/{contractId}` - Update a specific contract

## Postman Collection

A Postman collection with examples for each request is available [here](postman/codechallenge.postman_collection.json).

## Potential Improvements

- Create a Docker file with PostgreSQL configuration for better development environment setup, eliminating the need to
  modify `application.properties`
- Add unit tests to ensure code quality