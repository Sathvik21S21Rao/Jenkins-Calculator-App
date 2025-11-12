# Calculator App

This is a modular calculator application with separate backend, frontend, and operations modules. The backend exposes REST APIs, the frontend serves a web UI, and the operations module contains core mathematical logic.

## Prerequisites

- Java 17+
- Maven
- Docker and Docker Compose

## Build Instructions

1. Clone the repository.
2. Build all modules:
   ```
   mvn clean package
   ```

## Running Without Jenkins

1. Build Docker images:
   ```
   docker compose build
   ```
2. Start the application:
   ```
   docker compose up
   ```
3. Access the frontend at [http://localhost:8000](http://localhost:8000).

## Adding New Operations

- Add your new operation class in operations.
- Register the new operation in `operationFactory.java` within the same directory.

## Deployment

Deployment is automated using Ansible scripts in the ansible directory. See `deploy.yml` for details.