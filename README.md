# User Management System (Spring Boot)

##  Features
- JWT Authentication
- Role-Based Authorization (ADMIN / USER)
- CRUD APIs
- Pagination, Sorting, Search
- DTO & Validation
- Global Exception Handling

## 🛠 Tech Stack
- Java
- Spring Boot
- Spring Security
- JPA / Hibernate
- MySQL

## Authentication Flow
- Login API generates JWT token
- Token is passed in Authorization header
- Protected APIs validate token

## APIs

### Auth
- POST /auth/login

### User
- GET /users
- POST /users
- GET /users/{id}
- DELETE /users/{id}
- GET /users/page?page=0&size=2
- GET /users/search?name=thor

### Admin
- GET /admin/test

##  How to Run
1. Clone the repository
2. Configure database in application.properties
3. Run the application

##  Author
Subhajit Roy
