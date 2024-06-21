# Product Application

## Description
This application allows you to manage products by providing functionalities to register and list products. It uses Docker Compose for container orchestration.

## Requirements
- Docker
- Docker Compose

## Setup

1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Build and run the containers using Docker Compose:**
    ```sh
    docker-compose up --build
    ```

## Accessing the Application

- **API Documentation:**
    - Swagger: `{url}/docs/swagger`
    - OpenAPI: `{url}/docs/openapi`

## Project Functionalities

### Product Registration

- **Form Fields:**
    - **Product Name**: Text field
    - **Product Description**: Text field
    - **Product Price**: Value field
    - **Available for Sale**: Option field with two choices: Yes / No

## Note
Ensure to define the following environment variables in your `.env` file or directly in the `docker-compose.yml`:

- `POSTGRES_DB`
- `POSTGRES_USER`
- `POSTGRES_PASSWORD`