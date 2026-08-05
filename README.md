Web-Based Subscription & Billing System
Project Overview

The Web-Based Subscription & Billing System is a full-stack web application developed to help organizations manage customers, subscription plans, subscriptions, invoices, payments, and notifications. The application provides secure authentication using JWT, role-based access control, invoice generation, payment processing through Razorpay, and email verification using OTP.

Objectives
Manage organizations and users
Maintain customer records
Manage subscription plans
Handle customer subscriptions
Generate invoices automatically
Process online payments
Send notifications to users
Secure APIs using JWT Authentication
Technologies Used
Backend
Java
Spring Boot
Spring Security
Spring Data JPA
Hibernate
PostgreSQL
JWT Authentication
Flyway
Maven
Frontend
React
Vite
Bootstrap
Axios
Database
PostgreSQL
Payment Gateway
Razorpay
API Documentation
Swagger UI
Modules
Authentication Module
User Registration
User Login
Email Verification
OTP Generation
OTP Verification
Refresh Token
Logout
User Module
View Profile
Update Profile
Change Password
Organization Module
Create Organization
View Organization
Update Organization
Delete Organization
Generate Invitation Link
Super Admin Module
View Pending Organizations
Approve Organization
Reject Organization
Suspend Organization
Customer Module
Add Customer
View Customers
Update Customer
Delete Customer
Subscription Plan Module
Create Subscription Plan
View Subscription Plans
Update Subscription Plan
Delete Subscription Plan
Subscription Module
Create Subscription
View Subscriptions
Update Subscription
Delete Subscription
Invoice Module
Generate Invoice
Download Invoice PDF
Update Invoice Status
Payment Module
Create Payment
Create Razorpay Order
Verify Payment
Update Payment Status
Notification Module
View Notifications
Mark Notification as Read
Customer Notifications
Project Workflow
User registers an account.
OTP is generated and sent to the registered email.
User verifies the OTP.
User logs in using email and password.
JWT Access Token and Refresh Token are generated.
User creates an organization.
Organization remains in Pending status.
Super Admin approves or rejects the organization.
Approved organizations create subscription plans.
Customers are added to the organization.
Subscriptions are assigned to customers.
Invoice is generated automatically.
Customer completes payment through Razorpay.
Payment is verified.
Invoice status changes to Paid.
Subscription becomes Active.
Notifications are generated.
Invoice PDF can be downloaded.
Security Features
JWT Authentication
BCrypt Password Encryption
Spring Security
Role-Based Access Control (RBAC)
Refresh Token Authentication
Protected REST APIs
Database Tables
Users
Roles
Organizations
Organization Users
Customers
Subscription Plans
Subscriptions
Invoices
Payments
Notifications
OTP Verification
Refresh Tokens
REST APIs
Authentication APIs
Register
Login
Verify Email
Refresh Token
Logout
OTP APIs
Generate OTP
Verify OTP
Resend OTP
User APIs
Get Profile
Update Profile
Change Password
Delete Profile
Organization APIs
Create Organization
Get Organization
Update Organization
Delete Organization
Super Admin APIs
Get Pending Organizations
Approve Organization
Reject Organization
Suspend Organization
Customer APIs
Add Customer
Get Customers
Update Customer
Delete Customer
Subscription Plan APIs
Create Plan
Get Plans
Update Plan
Delete Plan
Subscription APIs
Create Subscription
Get Subscriptions
Update Subscription
Delete Subscription
Invoice APIs
Generate Invoice
Download Invoice
Update Invoice Status
Payment APIs
Create Payment
Create Razorpay Order
Verify Payment
Notification APIs
View Notifications
Mark Notification as Read
Project Structure
Web-Based-Subscription-and-Billing-System

backend
│
├── auth
├── customer
├── invoice
├── notification
├── organization
├── payment
├── role
├── subscription
├── subscriptionplan
├── security
└── common

frontend
│
├── src
├── components
├── pages
├── services
└── assets
How to Run the Project
Backend
Open the backend project in Spring Tool Suite (STS) or IntelliJ IDEA.
Configure PostgreSQL database credentials in application.properties.
Run Flyway migrations.
Start the Spring Boot application.
Frontend
Open the frontend folder in Visual Studio Code.
Install dependencies using npm install.
Start the frontend using npm run dev.
Future Improvements
Dashboard and Analytics
Docker Support
CI/CD Pipeline
Email Templates
SMS Notifications
Multi-Tenant Support
Payment Reports
Cloud Deployment
Author

Piyush Sahu
