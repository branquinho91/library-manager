# 📚 Library Manager

A simple library management system developed in Java 17 using JDBC and PostgreSQL.

This project was created as a learning exercise to practice object-oriented programming, layered architecture, exception handling, JDBC, and database persistence before moving to Spring Boot and JPA/Hibernate.

---

## Features

- Register books
- List all books
- Find books by ID
- Borrow books
- Return books
- Remove books
- Data persistence with PostgreSQL

---

## Technologies

- Java 17
- Maven
- JDBC
- PostgreSQL

---

## Project Structure

```text
com.branquinho.librarymanager
├── dao
├── database
├── exception
├── model
├── service
└── Main
```

### Layers

#### Model

Represents the application's domain entities.

Example:

- Book

#### DAO (Data Access Object)

Responsible for all database operations.

Example:

- Save books
- Search books
- Update books
- Delete books

#### Service

Contains business rules and coordinates communication between the application and persistence layer.

Examples:

- Borrowing a book
- Returning a book
- Validating existence before operations

#### Exceptions

Custom exceptions for business rules.

Examples:

- BookNotFoundException
- BookAlreadyBorrowedException
- BookAlreadyReturnedException

#### Database

Contains database connection configuration and management.

---

## Database

Example table structure:

```sql
CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    page_count INTEGER NOT NULL,
    publication_year INTEGER NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE
);
```

---

## Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/branquinho91/library-manager.git
```

### 2. Configure PostgreSQL

Create a database:

```sql
CREATE DATABASE library_manager;
```

Create the books table using the script above.

### 3. Configure connection

Update the connection settings in:

```java
ConnectionFactory.java
```

Example:

```java
private static final String URL =
        "jdbc:postgresql://localhost:5432/library_manager";

private static final String USER = "your_username";

private static final String PASSWORD = "your_password";
```

### 4. Run the application

Execute:

```bash
mvn clean compile
mvn exec:java
```

or run the Main class directly from IntelliJ IDEA.

---

## Example Menu

```text
===== Library Manager =====

1 - Register book
2 - List books
3 - Borrow book
4 - Return book
5 - Remove book
0 - Exit
```

---

## Learning Objectives

This project was built to practice:

- Object-Oriented Programming (OOP)
- Layered Architecture
- Exception Handling
- JDBC
- SQL
- PostgreSQL Integration
- Maven
- Clean Code principles

---

## Future Improvements

- REST API with Spring Boot
- Spring Data JPA / Hibernate
- DTOs
- Bean Validation
- Unit Tests
- Search and filtering features

---

## 👨‍💻 Author

**Gustavo Branquinho**
