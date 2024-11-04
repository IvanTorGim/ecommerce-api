# Ecommerce API

## Overview

The Ecommerce API is a powerful and flexible application designed to facilitate the management of an ecommerce platform.
This API allows developers to interact with various aspects of an online store, including products, orders, user
accounts, and addresses. Built with Spring Boot, the API supports both public and private endpoints, maintaining
different levels of access based on user roles.

## Deployment

The API is deployed on AWS and accessible through the following URL:

[Swagger UI Documentation](http://52.55.179.15:8080/swagger-ui/index.html)

This link provides a user-friendly interface to explore available endpoints, methods, parameters, and responses. The
documentation includes examples, making it easier for developers to understand how to interact with the API.

## Project Structure

The API is organized into several key components:

- **User Management**:
    - Handles user registration, authentication, and role assignment. Users can be classified as either `ADMIN` or
      `USER`, where admins have full access to manage resources while users can only interact with public endpoints.

- **Product Management**:
    - Allows for the creation, updating, retrieval, and deletion of products. Admin users can manage the entire product
      catalog, ensuring the store inventory is always up-to-date.

- **Order Management**:
    - Users can create orders for products, and both admins and users can retrieve orders. Admin users have the
      additional capability to delete orders as necessary, providing a comprehensive order management solution.

- **Address Management**:
    - Enables users to manage their shipping addresses, which can be associated with their orders. Users can create,
      update, and delete addresses as needed.

## Role-Based Access Control

The API implements role-based access control to restrict access to certain endpoints based on the user's role:

- **ADMIN**:
    - Has access to all endpoints, including those that manage products and orders. Admins can perform any action on
      resources within the API, essential for maintaining the ecommerce platform.

- **USER**:
    - Can access public endpoints, allowing them to browse products, create orders, and manage their addresses. Their
      access is limited to ensure security on sensitive operations.

## Security

To ensure secure access, the API uses JWT (JSON Web Tokens) for authentication. Users must obtain a token upon
successful login and include it in the Authorization header for subsequent requests. The API verifies the provided token
to determine if the user has the required permissions for specific endpoints.

## Conclusion

The Ecommerce API serves as a robust foundation for building and managing an online store. With its focus on user roles,
comprehensive management features, and secure access, it provides the necessary tools for developers to create a
seamless ecommerce experience.

## Contact

For any questions or feedback, please reach out via the contact information below.

- **Name**: Ivan Tortosa Gimeno
- **Email**: [itortosagimeno@gmail.com](mailto:itortosagimeno@gmail.com)
