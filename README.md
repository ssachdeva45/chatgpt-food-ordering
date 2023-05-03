# Food Ordering Service


## Requirements
    JDK 8 or later
    MySQL server 5.7 or later


## Setup
1. Clone the repository:
```
git clone https://github.com/<username>/<repository>.git
```
2. Set up the database by running the following SQL script in MySQL:
```
CREATE DATABASE IF NOT EXISTS food_ordering;

USE food_ordering;

CREATE TABLE IF NOT EXISTS orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(255) NOT NULL
);
```
3. Configure the database connection by setting the following properties in application.properties:

```
spring.datasource.url=jdbc:mysql://<host>:<port>/food_ordering?useSSL=false&serverTimezone=UTC
spring.datasource.username=<username>
spring.datasource.password=<password>
```
4. Build and run the application:
```
mvnw spring-boot:run
```

## API
### Create Order

Create a new order.

URL: /orders

Method: POST

Request Body:
```
[  {    "id": 1,    "name": "Pizza",    "description": "Delicious pizza with all your favorite toppings!",    "price": 9.99,    "quantity": 1  },  {    "id": 2,    "name": "Burger",    "description": "Juicy burger with all your favorite toppings!",    "price": 6.99,    "quantity": 2  }]

```

Response

```
{
  "id": 1,
  "message": "Order created successfully"
  "total": 15.93,
  "creationDate": "2023-05-03"
}

```

### Get Order List

Get List of all orders.

URL: /orders

Method: GET


Response

```
[
    {
        "id": 1,
        "message": "Order created successfully",
        "total": 15.93,
        "creationDate": "2023-05-03"
    },
    {
        "id": 2,
        "message": "Order created successfully",
        "total": 9.1,
        "creationDate": "2023-05-03"
    },
    {
        "id": 3,
        "message": "Order created successfully",
        "total": 12.72,
        "creationDate": "2023-05-03"
    }
]

```
