# TO-DO
#  Full Stack Todo Application  
### Spring Boot (Port 8081) + React + H2 Database

A simple full-stack Todo application built using Spring Boot and React.  
This project demonstrates CRUD operations and frontend-backend integration using REST APIs.

---

##  Tech Stack

### 🔹 Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Maven
- Runs on: **http://localhost:8081**

### 🔹 Frontend
- React
- Axios
- Runs on: **http://localhost:3000**

---

## 📌 Features

-  Add new todo
-  View all todos
-  Mark todo as complete/incomplete
-  Delete todo
-  Real-time updates
-  In-memory H2 database
-

---

##  Architecture

React (Frontend - Port 3000)  
⬇ REST API  
Spring Boot (Backend - Port 8081)  
⬇  
H2 Database (In-Memory)

---

## 📂 Project Structure

todo-backend/
 ├── controller/
 ├── model/
 ├── repository/
 ├── TodoApplication.java
 └── application.properties

todo-frontend/
 ├── src/
 │    ├── App.js
 │    └── index.js
 └── package.json


---

# ▶️ How To Run Locally

---

Backend:

mvn clean install

mvn spring-boot:run


Frontend:

npm install

npm start
