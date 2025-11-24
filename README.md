# Distributed Order Management System (Microservices Project)
This project is a microservices based Distributed Order Management System built using Spring Boot, Spring Cloud, Kafka, and PostGreSql. It demonstrates how real world retail systems handle orders across multiple services in a scalable and reliable way.

🚀 **Project Overview**
The system is designed using event riven architecture and Saga choreography to manage the full lifecycle of an order:

1. OrderPlaced
2. InventoryReserved / InventoryFailed
3. PaymentCompleted / PaymentFailed
4. OrderCompleted / OrderCancelled
5. InventoryFinalized / InventoryReleased

Each of the above event is handled by Kafka events.

**Microservices Included**

API Gateway : Routes secure requests to backend services
Auth Service : Validates login and generates JWT tokens
Customer Service : Stores customer profile information
Order Service : Creates orders and publishes OrderPlaced events
Inventory Service : Reserves/cancels stock based on events
Payment Service : Simulates payment processing

📬 **Event-Driven Communication**

All services communicate using following Kafka topics. The system uses Outbox Pattern for reliable event publishing and manual offset commits for exactly once processing.
order.events
inventory.events
payment.events
order.inventory.events

🛠️ **Tech Stack**

Java 17+

Spring Boot, Spring Security, Spring JPA, Spring REST

Kafka messaging

PostgreSQL

Docker Compose

JWT Authentication
