

## Overview

This project consists of a Spring Boot backend for parsing and storing news from a website and a JavaFX frontend for displaying the news. The application fetches news every 30 minutes, stores it in a MySQL or H2 database, and allows users to browse and filter the news through a JavaFX interface.

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
  - [Backend (Spring Boot)](#backend-spring-boot)
  - [Frontend (JavaFX)](#frontend-javafx)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Endpoints](#endpoints)

## Requirements

- Java 17
- Spring Boot
- MySQL (for production)
- Gradle
- H2 (for testing)


## Setup

### Backend (Spring Boot)

1. Clone the repository:

    ```sh
    git clone <repository-url>
    cd news-parser
    ```

2. Update `application.properties`:

    For MySQL:
    
    ```properties
    # MySQL Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/news_db
    spring.datasource.username=
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

    For H2 (for testing):
    
    ```properties
    # H2 Configuration
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.h2.console.enabled=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
    ```

3. Run the application:

    ```sh
    ./gradlew bootRun
    ```

## Running the Application

1. Ensure the Spring Boot backend is running.
2. Run the JavaFX frontend to view the news.
