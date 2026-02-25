# Weather Data API (Spring Boot)

## 📌 Project Overview

This project processes weather data from a CSV file, stores it in a database, and exposes REST APIs to access, filter, and sort the data.

Developed as part of the **Java Developer Internship Assessment**.

---

## ⚙️ Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* H2 Database (In-Memory)
* Maven
* REST API

---

## 🚀 Features

✅ Load weather data from CSV file
✅ Store records into database automatically
✅ REST API endpoints to fetch data
✅ Filtering support
✅ Sorting support

---

## ▶️ How to Run the Project

1. Clone repository:

```
git clone https://github.com/Karthi10-coder/WeatherApi.git
```

2. Open in IntelliJ IDEA

3. Run:

```
WeatherApiApplication.java
```

4. Server starts at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### Get All Weather Data

```
GET /weather
```

Example:

```
http://localhost:8080/weather
```

---

### Filter by Condition

```
GET /weather/filter?condition=Smoke
```

---

### Sort by Temperature

```
GET /weather/sort?field=temperature
```

---

## 🗄 Database

* H2 in-memory database
* Table automatically created using JPA
* CSV data loaded at application startup

---

## 👨‍💻 Author

Karthi Kishor P
