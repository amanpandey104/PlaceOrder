# PlaceOrder API

A backend API to place and process orders using Java, Spring Boot, MySQL, and a simulated in-memory queue.

## Features

- Place orders with validation
- View all orders (paginated)
- View and update order status
- Async order processing

DB Queries Used -

CREATE DATABASE orderdb;

USE orderdb;

CREATE TABLE orders (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255) NOT NULL,
items VARCHAR(1000) NOT NULL,
total_amount DOUBLE NOT NULL,
order_time DATETIME NOT NULL,
status VARCHAR(100) NOT NULL
);

SELECT \* FROM orders;

Payload -

#Place Order#
URL(POST) - http://localhost:8080/api/orders/place
Body(JSON) -
{
"customerName": "Aman Pandey",
"items": "Pizza, Coke",
"totalAmount": 350.0,
"orderTime": "2025-07-22T14:30:00",
"status": "PENDING"
}

#Fetch All Order in Page#
URL(GET) - http://localhost:8080/api/orders/fetch --this will give result in default page size of 10
URL(GET) - http://localhost:8080/api/orders/fetch?page=1&size=2 --this will give result of Page 1 having Size 2

#Fetch Order Status#
URL(GET) - http://localhost:8080/api/orders/1/status

#Update Status of an Order#
URL(PUT) - http://localhost:8080/api/orders/1/status?status=FAILED
