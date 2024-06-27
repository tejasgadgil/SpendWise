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

## Getting Started

### Prerequisites

- JDK 8 or higher
- Maven

### Installation

1. Clone the repository:

    ```bash
    git clone [https://github.com/your-username/spendwise.git](https://github.com/tejasgadgil/SpendWise.git)
    cd spendwise
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## Usage

1. Use Postman or any other API client to interact with the REST API.
2. The API endpoints available are:

- **Customer**:
  - `POST /customers`: Add a new customer
  - `GET /customers/{id}`: Get a customer by ID

- **Budget**:
  - `POST /budgets`: Add a new budget
  - `GET /budgets/{id}`: Get a budget by ID

- **Transaction**:
  - `POST /transactions`: Add a new transaction
  - `GET /transactions/{id}`: Get a transaction by ID


