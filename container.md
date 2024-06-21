### Docker Compose Configuration

**Version**: `3.8`

#### Networks:
- `product-management-network`: Bridge network for inter-service communication

#### Services:
1. **product-db**:
   - **Build context**: `./datasource`
   - **Container name**: `product-db`
   - **Environment Variables**:
     - `POSTGRES_DB`: (Defined in `.env`)
     - `POSTGRES_USER`: (Defined in `.env`)
     - `POSTGRES_PASSWORD`: (Defined in `.env`)
   - **Ports**: `5432:5432`
   - **Networks**: `product-management-network`

2. **product-app**:
  - **Build context**: `.`
  - **Container name**: `product-app`
  - **Environment Variables**:
    - `PRODUCT_DB_CONTAINER`: `product-db`
  - **Ports**: `8080:8080`
  - **Depends on**: `product-db`
  - **Networks**: `product-management-network`