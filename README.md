# Business Management Web Application

A **Spring Boot** based web application for managing business operations like customers, products, orders, and user access.

> **Created by Sourav Ghosh**

---

## 📌 About This Project

This is a **Business Management Web Application** built using **Java Spring Boot**. It provides a complete system to manage:

- **Products** — Add, update, delete, and view all products in inventory
- **Users / Customers** — Register and manage customer accounts
- **Orders** — Place orders and track them with automatic total calculation
- **Admins** — Admin panel to control all operations
- **Authentication** — Separate login for Admin and Users with role-based access

The application uses **Thymeleaf** for server-side HTML templates and supports both **H2 (in-memory)** and **MySQL** databases.

---

## ✨ Features

| Feature | What it does |
|---------|-------------|
| Product Management | Add, update, delete products with name, price, description |
| User Management | Register users, update profiles, delete accounts |
| Order Management | Place orders with quantity, auto-calculate total amount |
| Admin Dashboard | Full control panel to manage everything |
| User Dashboard | Browse products, search, and place orders |
| Secure Login | Separate login for Admin and Users |
| Product Search | Search products by name |
| H2 + MySQL Support | Works with H2 in development, MySQL in production |

---

## 🖼️ Screenshots

Place your screenshots in the `src/main/resources/static/Images/` folder and update the file names below.

### Home Page
![Home Page](src/main/resources/static/Images/home-page.png)

### Products Page
![Products Page](src/main/resources/static/Images/products-page.png)

### Location Page
![Location Page](src/main/resources/static/Images/location-page.png)

### About Page
![About Page](src/main/resources/static/Images/about-page.png)

### Login Page
![Login Page](src/main/resources/static/Images/login-page.png)

---

## 🛠️ Technologies Used

- **Java 17** — Programming language
- **Spring Boot 3.1.3** — Backend framework
- **Spring Data JPA** — Database operations
- **Spring MVC** — Web layer
- **Thymeleaf** — HTML template engine
- **H2 Database** — In-memory database (default for development)
- **MySQL** — Production database (optional)
- **Apache Maven** — Build tool
- **Spring Tool Suite 4 / Eclipse** — Recommended IDE

---

## 🚀 How to Run This Project

### Prerequisites

Make sure you have these installed on your system:

1. **Java Development Kit (JDK) 17** or higher
   - Download from: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
   - Check installation: `java -version`

2. **Apache Maven** (or use the included Maven Wrapper)
   - Download from: https://maven.apache.org/download.cgi
   - Check installation: `mvn -version`

3. **Spring Tool Suite 4** (Recommended) or any Java IDE
   - Download from: https://spring.io/tools

---

### Step 1: Download the Project

Download or clone the project to your computer.

If using Git:
```bash
git clone <your-repository-url>
cd Business_Management_Project
```

Or simply download the ZIP file and extract it.

---

### Step 2: Import into IDE

**If using Spring Tool Suite 4 / Eclipse:**

1. Open **Spring Tool Suite 4** or **Eclipse**
2. Go to `File` → `Import`
3. Select `Maven` → `Existing Maven Projects`
4. Click **Browse** and select the project folder
5. Click **Finish**

The IDE will download all dependencies automatically.

---

### Step 3: Configure Database (Optional)

The project uses **H2 in-memory database** by default — no setup needed.

If you want to use **MySQL**, open `src/main/resources/application.properties` and replace the database settings with your MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

> **Note:** Create the database first in MySQL: `CREATE DATABASE your_database_name;`

---

### Step 4: Run the Application

**Option 1 — From IDE:**
- Find the file `BusinessProjectApplication.java` inside `src/main/java/com/business/`
- Right-click on it → `Run As` → `Spring Boot App`

**Option 2 — From Command Line (Project folder):**

On Windows:
```bash
mvnw.cmd spring-boot:run
```

On Mac / Linux:
```bash
./mvnw spring-boot:run
```

Or if Maven is installed globally:
```bash
mvn spring-boot:run
```

---

### Step 5: Open in Browser

Once the application starts, open your browser and go to:

```
http://localhost:2330/home
```

You should see the **Home Page** of the application.

---

### Step 6: Add Admin Account (Important!)

The application creates tables automatically when it runs for the first time. But you need to add an **Admin account manually** to log in.

**Method 1 — Using H2 Console (Default Database):**

1. Go to: `http://localhost:2330/h2-console`
2. JDBC URL: `jdbc:h2:mem:businessproject`
3. Username: `sa`
4. Password: *(leave empty)*
5. Click Connect
6. Run this SQL:
```sql
INSERT INTO admin (admin_name, admin_email, admin_password, admin_number) 
VALUES ('Admin', 'admin@example.com', '1234', '1234567890');
```

**Method 2 — Using MySQL (if configured):**

Use your MySQL client to run:
```sql
INSERT INTO admin (admin_name, admin_email, admin_password, admin_number) 
VALUES ('Admin', 'admin@example.com', '1234', '1234567890');
```

**Default Login Credentials:**
- Email: `admin@example.com`
- Password: `1234`

---

## 📖 How to Use

### For Admin

| Action | Steps |
|--------|-------|
| Login | Go to `http://localhost:2330/login` → Enter Admin email & password → Click Login |
| View Dashboard | After login you will see the Admin Panel with all data |
| Add Product | Click "Add Product" → Fill details → Submit |
| Update Product | Click "Update" next to any product → Edit → Save |
| Delete Product | Click "Delete" next to any product |
| Add User | Click "Add User" → Fill details → Submit |
| Add Admin | Click "Add Admin" → Fill details → Submit |

### For Regular Users

| Action | Steps |
|--------|-------|
| Register | Go to `http://localhost:2330/Add_User` → Fill details → Register |
| Login | Go to `http://localhost:2330/login` → Enter User email & password |
| Browse Products | Go to `http://localhost:2330/products` |
| Search Product | Type product name in search box → Click Search |
| Place Order | Click "Buy" on a product → Enter quantity → Confirm order |

---

## 📂 Project Structure

```
Business_Management_Project/
│
├── src/main/java/com/business/
│   ├── BusinessProjectApplication.java    ← Main class (run this)
│   ├── Exceptions.java                     ← Error handling
│   │
│   ├── controllers/                        ← Request handlers
│   │   ├── HomeController.java             ← Home, Products, Login pages
│   │   ├── AdminController.java            ← Admin login & dashboard
│   │   ├── UserController.java             ← User operations
│   │   ├── ProductController.java          ← Product operations
│   │   └── OrderController.java            ← Order operations
│   │
│   ├── entities/                           ← Database models
│   │   ├── Admin.java
│   │   ├── User.java
│   │   ├── Product.java
│   │   └── Orders.java
│   │
│   ├── repositories/                       ← Database queries
│   │   ├── AdminRepository.java
│   │   ├── UserRepository.java
│   │   ├── ProductRepository.java
│   │   └── OrderRepository.java
│   │
│   ├── services/                           ← Business logic
│   │   ├── AdminServices.java
│   │   ├── UserServices.java
│   │   ├── ProductServices.java
│   │   └── OrderServices.java
│   │
│   ├── basiclogics/
│   │   └── Logic.java                      ← Price calculation logic
│   │
│   └── loginCredentials/
│       ├── AdminLogin.java
│       └── UserLogin.java
│
├── src/main/resources/
│   ├── application.properties               ← Configuration file
│   ├── templates/                           ← HTML pages (Thymeleaf)
│   │   ├── Home.html
│   │   ├── Login.html
│   │   ├── Products.html
│   │   ├── Admin_Page.html
│   │   ├── BuyProduct.html
│   │   ├── Order_success.html
│   │   └── ... (other templates)
│   │
│   └── static/
│       ├── css/
│       ├── Images/                          ← Add your screenshots here
│       └── JavaScript/
│
├── pom.xml                                  ← Maven dependencies
├── mvnw / mvnw.cmd                          ← Maven wrapper
└── README.md                                ← This file
```

---

## 🗺️ Database Design

The application has **4 tables**:

| Table | Fields | Description |
|-------|--------|-------------|
| **admin** | adminId, adminName, adminEmail, adminPassword, adminNumber | Admin login credentials |
| **user** | u_id, uname, uemail, upassword, unumber | Customer/user accounts |
| **product** | pid, pname, pprice, pdescription | Product inventory |
| **orders** | oId, oName, oPrice, oQuantity, orderDate, totalAmmout, user_u_id | Customer orders linked to users |

**Relationships:**
- One **User** can have many **Orders**
- Each **Order** belongs to one **User**
- **Admin** and **Product** are standalone tables

---

## 🌐 Quick Links

| Page | URL |
|------|-----|
| Home | http://localhost:2330/home |
| Products | http://localhost:2330/products |
| Login | http://localhost:2330/login |
| Location | http://localhost:2330/location |
| About | http://localhost:2330/about |
| H2 Console | http://localhost:2330/h2-console |

---

## 📝 Notes

- The application runs on **port 2330** by default (configured in `application.properties`)
- 5 sample products are automatically added when the application starts for the first time
- Make sure to add at least one **Admin** manually before trying to log in
- All database tables are created automatically — no manual SQL setup needed

---

## 🧑‍💻 Author

**Sourav Ghosh**

---

## 📄 License

This project is for educational and business management purposes.