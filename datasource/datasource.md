### Container Description

**Base image**: `postgres:16.1`

#### Files:
- `schema.sql`: Initial database schema

#### Environment Variables:
Defined in `docker-compose.yml`:
- `POSTGRES_DB`: Name of the database
- `POSTGRES_USER`: Database user
- `POSTGRES_PASSWORD`: User password

#### Commands:
- Default command: `CMD ["postgres"]`

#### Ports:
- Exposed: `5432`