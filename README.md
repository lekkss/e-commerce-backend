# E-commerce Platform API

This project is a fully-functional E-commerce Platform API developed using Spring Boot, Spring Data JPA, MySQL, and Lombok. It covers key functionalities essential for any online shopping platform, including user management, product catalog, shopping cart, and order management. This project demonstrates how to integrate Spring Boot with database management using JPA and MySQL, along with clean and efficient code structure aided by Lombok.

# Features

1. User Management:
User registration, authentication, and profile management.
Support for multiple addresses and payment methods for each user.
2. Product Management:
Products organized into categories with discounts and inventory tracking.
CRUD operations for products, categories, and inventory management.
3. Shopping Cart:
A user can add, update, and remove products from their shopping cart.
Shopping sessions are created for users during checkout.
4. Order Management:
Users can place orders, view their order history, and payment details.
Detailed order items and payment tracking.
5. Discount Management:
Apply discounts to products with configurable percentage values and expiration.
6. Payment Integration:
Payment information is securely stored and linked with orders.

# Technologies Used

1. Spring Boot: For creating a robust and scalable backend API.
Spring Data JPA: For object-relational mapping and interaction with the MySQL database.
2. MySQL: A reliable relational database for storing users, products, orders, and more.
3. Lombok: Reduces boilerplate code such as getters, setters, and constructors.

# Database Structure

The project follows a well-structured relational database design, including the following key tables:

1. Users, User Address, User Payment: For user information and their associated addresses and payment details.
2. Product, Product Category, Product Inventory: To manage the product catalog, their categories, and inventory levels.
3. Shopping Session, Cart Item: For managing users' shopping carts and ongoing sessions.
4. Order Details, Order Items, Payment Details: To store and track orders placed by users and their respective payment details.
5. Discount: For applying promotional discounts to products.

# Prerequisites

Before running the project, ensure you have the following installed:

Java 17+ (for Spring Boot) \
Maven (for project dependencies) \
MySQL (or any relational database supported by JPA)
