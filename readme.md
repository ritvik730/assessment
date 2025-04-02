Time To Words Service

Overview

The Time To Words Service is a Spring Boot microservice that converts a given 24-hour formatted time into its word representation.
For example, 08:34 will be converted to "It's eight thirty four".

Features

Converts any valid 24-hour format time (HH:mm) to words.

Handles special cases like Midday (12:00) and Midnight (00:00).

Provides a REST API to retrieve current time in words.

Swagger UI for API documentation and testing.

Proper Exception Handling for invalid inputs.

Unit Tests for service and controller methods.

Technologies Used

Java 8+

Spring Boot (Web, Validation)

Swagger (Springdoc OpenAPI)

JUnit 5 & Mockito (for Unit Testing)

Maven (for Dependency Management)

Installation & Setup

Prerequisites

Install Java 8 or later

Install Maven

Steps to Build and Run

Clone the repository:

git clone https://github.com/your-repo/time-to-words.git
cd time-to-words

Build the project using Maven:

mvn clean install

Run the Spring Boot application:

mvn spring-boot:run

API Endpoints

Convert Specific Time to Words

Endpoint: GET /api/time/convert/{time}

Example Request:

GET http://localhost:8080/api/time/convert/11:25

Example Response:

"It's eleven twenty five"

Get Current Time in Words

Endpoint: GET /api/time/current

Example Request:

GET http://localhost:8080/api/time/current

Example Response:

"It's ten forty five"

Swagger Documentation

Once the application is running, you can access Swagger UI at:

http://localhost:8080/swagger-ui/index.html

Running Unit Tests

To run unit tests, execute:

mvn test

Error Handling

If an invalid time format is provided, the service returns an appropriate error message.

Example Request:

GET http://localhost:8080/api/time/convert/25:00

Example Response:

{
  "error": "Invalid hour value. Hour should be between 00 and 23."
}

