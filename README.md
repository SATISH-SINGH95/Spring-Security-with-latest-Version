
# Spring Security with Authentication and Authorization - Java Backend Project

# Overview

This project is a Java backend application that demonstrates the implementation of Spring Security for both authentication and authorization. Built using the latest versions of Spring Boot and Spring Security, this application provides a robust foundation for securing your web applications.



## Features

- **Spring Boot Integration**: Utilizes the latest version of Spring Boot for ease of setup and configuration.
- **Spring Security Integration:** Implements the latest version of Spring Security for handling authentication and authorization.
- **Role-Based Access Control:** Demonstrates role-based access control for fine-grained authorization.
- **Custom User Details Service:** Implements a custom UserDetailsService to load user-specific data.
- **Secure Endpoints:** Protects RESTful endpoints with appropriate security measures.
- **Password Encryption:** Uses BCryptPasswordEncoder for secure password hashing.

## Prerequisites

- **Java 17 or higher:** Ensure you have Java Development Kit (JDK) 17 or later installed.
- **Maven:** Make sure you have Apache Maven installed for managing project dependencies and building the project.
## Getting Started
- **Clone the Repository**
```bash
git clone https://github.com/your-username/spring-security-auth.git cd spring-security-auth
```

## Configure application.properties file
Update the **application.properties** file in the **src/main/resources** directory with your database configuration.

```bash
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

## Build Project
```bash
mvn clean install
```
## Run the application
```bash
mvn spring-boot:run
```
The application will start on http://localhost:9999

## Usage
### Authentication Endpoints
- **Register a new user:**
    - **`POST /signup/createUser**
    - **Request Body:** 
    ```bash
    {
    "username": "Dhiraj",
    "password": "dhiraj",
    "email": "dhiraj@gmail.com",
    "phoneNumber": "2222222222"
    }
    ```

- **Public Endpoints:**
    - **`GET** /public/greet/{username}
    - **`GET** /public/home/dashboard

- **Protected Endpoints:**
    - **`GET** /admin/greet/{username}  -> can be access by only ADMIN role
    - **`GET** /user/greet/{username} -> can be access by only USER role


## Example Requests
### Register a new user

```bash
curl -X POST http://localhost:9999/signup/auth/createUser \
  -H "Content-Type: application/json" \
  -d '{"username": "Dhiraj","password": "dhiraj","email": "dhiraj@gmail.com","phoneNumber": "2222222222"}'

```

## Dependencies
- **spring-boot-starter-web**
- **spring-boot-starter-data-jpa**
- **spring-boot-devtools**
- **mysql-connector-jb**
- **lombok**
- **spring-boot-starter-tomcat**
- **spring-boot-starter-security**
- **spring-boot-starter-oauth2-client**
- **spring-boot-starter-validatio**
- **springdoc-openapi-starter-webmvc-ui**
    
## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## Contact
For questions or feedback, please contact sk95satish@gmail.com.


    
