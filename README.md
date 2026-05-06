**Rewards API – Spring Boot Application**
**Overview**
This project is a Spring Boot RESTful API that calculates reward points for customers based on their purchase transactions.
A retailer offers a rewards program where:

A customer earns 1 point for every dollar spent between $50 and $100
A customer earns 2 points for every dollar spent over $100
Points are calculated per transaction
Rewards are aggregated per customer, per month, and as a total

This application demonstrates clean architecture, Java 8 compatibility, proper exception handling, and unit/integration testing.

**Technology Stack**

Java 8 (Eclipse Temurin)
Spring Boot 2.7.18
Maven
JUnit 5
Spring Boot Test
MockMvc


**Reward Calculation Logic**
For each transaction:

No points are awarded for the first $50
1 point per dollar for amounts between $50 and $100
2 points per dollar for amounts greater than $100

**Example**
A $120 purchase results in:

(120 − 100) × 2 = 40 points
(100 − 50) × 1 = 50 points
Total = 90 points


**API Endpoint**
**Get reward points for a customer**
GET /api/rewards/{customerId}

**Path Parameter**

customerId – Unique identifier of the customer


**Sample Success Response**

{
"customerId": "C1",
"monthlyPoints": {
"JANUARY": 90,
"FEBRUARY": 25,
"MARCH": 250
},
"totalPoints": 365
}
``

**Sample Error Response**


{
"error": "No transactions found for customer: C99"
}

HTTP Status: 400 Bad Request

**Data Source**
The application uses an in‑memory mock repository to simulate transaction data.

Multiple customers
Multiple transactions per customer
Transactions spanning a three‑month period
No database dependency

Months are not hard‑coded and are dynamically derived from LocalDate using Java’s Month enum.

**Project Structure**

src
├── main
│   └── java
│       └── com.rewards.api
│           ├── RewardsApiApplication.java
│           ├── controller
│           │   └── RewardsController.java
│           ├── service
│           │   ├── RewardsService.java
│           │   └── RewardsServiceImpl.java
│           ├── repository
│           │   └── TransactionRepository.java
│           ├── model
│           │   ├── Transaction.java
│           │   └── RewardsResponse.java
│           └── exception
│               ├── InvalidTransactionException.java
│               └── GlobalExceptionHandler.java
└── test
└── java
└── com.rewards.api
├── service
│   └── RewardsServiceTest.java
└── controller
└── RewardsControllerTest.java


**Exception Handling**

Custom runtime exception: InvalidTransactionException
Global exception handling using @RestControllerAdvice
Handles scenarios such as:

Invalid or non‑existent customer ID
Negative transaction amounts



All errors are returned as user‑friendly JSON responses.

**Testing**
The project includes both unit tests and integration tests:

Unit tests validate reward calculation logic
Integration tests validate REST API endpoints using MockMvc
Multiple customers and transactions are covered in tests

**Run Tests**
Using IntelliJ Maven Tool Window:

Run clean
Run test


**How to Run the Application**
**Prerequisites**

Java 8 installed
Maven (or IntelliJ bundled Maven)

**Steps**

Open the project in IntelliJ
Set Project SDK to Java 8
Run RewardsApiApplication
Access the API at:

http://localhost:8080/api/rewards/{customerId}


**Notes**

No target or bin directories are committed
No zip files are uploaded
Java coding standards and formatting are followed
JavaDocs are added at class and method levels


**Author**
Sanjana Sharma
Software Engineer