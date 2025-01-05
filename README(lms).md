
# Lead Management System (LMS)

## Description
Lead Management System (LMS) is a Spring Boot application designed to manage leads, interactions and track performances. The application provides functionalities to calculate and retrieve the best and worst performing accounts based on various metrics.

## Features
- Add new restaurants, orders, contacts, interactions etc and keep a track record.
- Calculate restaurant performance metrics such as total orders, total revenue, average order value, and order frequency.
- Retrieve the best and worst performing restaurants.

## Prerequisites
- Java 17 or higher
- Maven 3.9.9 or higher
- PostgreSQL database





## Run Locally

Build the project

```bash
  ./mvnw clean install
```

Run the application

```bash
  ./mvnw spring-boot:run
```


## API Reference

The application provides REST endpoints to retrieve required information related to leads, interactions, orders, and individual performances. You can use tools like Postman or curl to interact with the API.
Please note that the application needs to be running for the following endpoints to work. For more information about how to run the application, please refer to run the application section.

Select Basic Authorization in Postman
| Parameter | Value     | 
| :-------- | :------- | 
| `username` | `string` |
| `password` | `string` |

#### Get All Restaurants

```http
  GET /api/restaurants/all
```

#### Get Restaurant By Id

```http
  GET /api/restaurants/{id}
```

#### Add  Restaurant

```http
  POST /api/restaurant
```
Similar API implementations for every entity to manage basic CRUD operations around them.





## Running Tests

To run tests, run the following command

```bash
  ./mvnw test
```

The command will execute the tests defined in project and provide the results in the console.

