# SpendWise
This project, developed during NEUEDA's training in collaboration with Citibank, is a Personal Financial Management (PFM) application. FinanceTracker API helps users manage their finances by enabling budgeting, expense tracking, and financial goal setting. Users can register, login, add transactions, and set budgets with ease.

## Features

- User registration and login
- Add and retrieve transactions
- Set and get budget status
- Expense categorization
- Budget alerts

## Technologies Used

- Java
- Spring Boot
- Maven
- H2 Database
- HTML, CSS (for frontend)
- JavaScript

## Endpoints

### User Management

- **Register User**: `POST /api/register`

- **Login User**: `POST /api/login`

- **Get User**: `GET /api/user/{id}`

### Transactions

- **Add Transaction**: `POST /api/transactions`

- **Get Transactions**: `GET /api/transactions/{customerId}`
 
### Budget

- **Set Budget**: `POST /api/budget`

- **Get Budget Status**: `GET /api/budget/{customerId}`


## Running the Application

To run the application, use the following command:

```sh
mvn spring-boot:run
