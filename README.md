# User Authentication System (Java + JDBC + MySQL + Swing)

## Project Overview

This project is a GUI-based User Authentication System developed using Core Java, JDBC, MySQL, and Swing. It allows users to register and login, and provides an admin panel to manage users.

---

## Features

* User Registration
* User Login
* Role-Based Access (USER / ADMIN)
* View All Users (Admin Only)
* Update User Password (Admin Only)
* Delete Users (Admin Only)
* GUI using Java Swing

---

## Technologies Used

* Java (Core Java)
* JDBC (Java Database Connectivity)
* MySQL
* Swing (GUI)

---

## Project Structure

```
UserAuthSystem/
│
├── src/
│   ├── model/
│   │     └── User.java
│   │
│   ├── dao/
│   │     ├── UserDao.java
│   │     └── UserDaoImpl.java
│   │
│   ├── util/
│   │     └── DBConnection.java
│   │
│   ├── ui/
│   │     ├── LoginFrame.java
│   │     ├── RegisterFrame.java
│   │     └── ViewUsersFrame.java
│   │
│   └── Main.java
│
├── database/
│   └── auth_db.sql
│
├── lib/
│   └── mysql-connector-j.jar
│
└── README.md
```

---

## Database Setup

1. Open MySQL Workbench
2. Open the file: `database/auth_db.sql`
3. Execute the script

This will:

* Create the database `auth_db`
* Create the table `users`
* Insert a default admin user

---

## Default Admin Login

```
Username: admin
Password: admin123
Role: ADMIN
```

---

## How to Run

1. Import the project into Eclipse
2. Add the MySQL Connector JAR to the build path
3. Update database credentials in `util/DBConnection.java`
4. Run `Main.java`

---

## Key Concepts Used

* Object-Oriented Programming (OOP)
* DAO Design Pattern
* JDBC Connectivity
* Swing GUI Development
* Role-Based Authentication

---

## Future Enhancements

* Password encryption
* Improved user interface
* Email verification
* Forgot password feature

---

## Author

Shwetha Shalom S

---

## Conclusion

This project demonstrates a desktop application using Java with database connectivity and GUI, implementing user authentication and role-based access control.
