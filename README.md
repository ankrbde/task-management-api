# Task Management API

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=springboot)
![Build](https://img.shields.io/badge/build-passing-success)
![Tests](https://img.shields.io/badge/tests-junit5%20%7C%20mockito-orange)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

A simple but clean **Task Management REST API** built with Spring Boot.

The goal of this project was not to over-engineer things, but to build a **solid backend foundation** with proper layering, testability, and real-world API structure.

Intentionally structured as a modular monolith so it can evolve to microservices without premature complexity.

```
task-management-api
├── auth module   → login, JWT, security
├── user module   → user lifecycle
├── task module   → task CRUD + assignment
├── common        → exceptions, utils, config
```

```
Controller → Service → Repository → DB
```
---

## Tech Stack

- Java 21
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- Spring Validation
- JUnit 5
- Mockito
- Maven

---

## What this API does

This API lets you manage tasks in a straightforward way:

- Create a task
- Fetch task by ID
- Update task details
- Delete a task
- Update task status
- Assign a user to a task (basic support)

Nothing fancy — just clean backend fundamentals done properly.

---

## API Endpoints

All endpoints are exposed under:

```
/api/tasks
```



### Create a task
```http
POST /api/tasks
```

Get a task by ID
```
GET /api/tasks/{id}
```

Update a task
```
PUT /api/tasks/{id}
```

Delete a task
```
DELETE /api/tasks/{id}
```

### Testing Strategy
```
I kept testing intentionally simple and focused on the layers that matter most:
├── Service Layer Tests
├── Business logic is tested in isolation
├── Uses JUnit + Mockito
├── No Spring context involved (fast and stable)

Controller Tests
├── Uses @WebMvcTest
├── MockMvc for API-level validation
├── Service layer is mocked
├── Covers: success responses and error scenarios (like 404)
```

What is NOT included (on purpose)
No Testcontainers
No full end-to-end integration tests
No Docker-based test environment

This keeps the project lightweight and fast to run locally.

### How to run locally
```
1. Clone the project
git clone <repo-url>
cd task-management-api

2. Run the application
mvn spring-boot:run

App will start at:
http://localhost:8080
```


### How to run tests

To run all tests:

mvn clean test

To run full build + tests:

mvn clean verify

### Current Scope (What’s Done)

This project is roughly 80–90% complete in terms of a real backend service.

Already implemented:
* REST API with full CRUD support
* Clean layered architecture (Controller → Service → Repository)
* DTO-based request/response separation
* Global exception handling
* Proper HTTP status codes
* Unit tests for service layer
* Web layer tests using MockMvc
* Stable Maven build (no external dependencies needed for tests)


### Remaining Work (10–20%)

This is intentionally left out to keep the project simple and focused.

Security
* No authentication (JWT / OAuth2 not implemented)
* No role-based access control

Production Readiness
* No Docker setup
* No CI/CD pipeline (GitHub Actions not added)
* No database migration tool (Flyway / Liquibase)

Advanced Testing
* No Testcontainers-based integration tests
* No real DB integration test suite

Observability
* No metrics or monitoring (Micrometer / Prometheus)
* No structured logging setup

Design Philosophy

This project was intentionally kept simple.

The focus was on:
* Keeping the architecture clean and readable
* Avoiding unnecessary infrastructure complexity
* Making it easy to run locally without setup headaches
* Ensuring tests are fast and stable

It’s meant to be a solid backend foundation, not a production system.

Status

* Fully functional backend API
* Stable test suite
* Clean architecture
* Ready for extension into a production-grade system

### What’s next (if extended)

If I revisit this project later, it would evolve into:

* Secure task system (JWT authentication)
* Multi-user task assignment
* Dockerized deployment
* CI/CD pipeline
* Event-driven architecture (Kafka or RabbitMQ)
