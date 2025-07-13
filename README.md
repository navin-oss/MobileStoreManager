# MobileStoreManager

A Java-based console application for managing users, mobile phones, and orders using JDBC and MySQL. This project demonstrates core concepts of Java programming, user authentication, and database CRUD operations in a text-based interface.

## 🚀 Features

- User registration and secure login
- Add and display mobile phones
- Place orders and view order history
- JDBC integration with MySQL
- Clean object-oriented design using entities like `User`, `Mobile`, and `Order`

## 🛠 Technologies Used

- Java (JDK 8 or above)
- MySQL
- JDBC (Java Database Connectivity)
- Eclipse IDE (or any Java IDE)
- Git & GitHub

## 📂 Project Structure


MobileStoreManager/
├── src/
│   ├── entity/
│   │   └── User.java
│   │   └── Mobile.java
│   ├── Program.java
├── .gitignore
├── LICENSE
├── README.md

## 🔧 Setup Instructions

1. Clone the repository or download the ZIP
2. Open the project in your Java IDE (e.g., Eclipse)
3. Set up MySQL and create the required tables (`user`, `mobile`, `orders`)
4. Update your `DbUtil.java` with your DB credentials
5. Run `Program.java` to start the application

## 📌 Notes

- Make sure MySQL server is running before starting the app.
- All database interactions are done using **PreparedStatements** for security.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

