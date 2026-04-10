# task-management-api
Spring Boot REST API for team task CRUD with JWT auth, pagination, TDD, and Dockerized Postgres.

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

