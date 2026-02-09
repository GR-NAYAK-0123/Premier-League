🏏 Premier League Player Management API

A Spring Boot RESTful API for managing IPL (Indian Premier League) player statistics.
This project allows you to create, read, update, delete, and filter player data using MongoDB as the database.


🚀 Features

Create new player records

Fetch all players

Search players by:

Name (partial match)

Team

Role

Nation

Team + Role (combined filter)

Update existing player details

Delete player by name

MongoDB integration

Swagger UI for API documentation

🛠️ Tech Stack

Java

Spring Boot

Spring Data MongoDB

MongoDB

Lombok

Spring Validation

Swagger (Springdoc OpenAPI)

📁 Project Structure
com.ipl.premier_league
│
├── controller
│   └── PlayerController.java
│
├── model
│   └── Player.java
│
├── repository
│   └── PlayerRepository.java
│
├── service
│   ├── PlayerService.java
│   └── PlayerServiceImpl.java
│
└── PremierLeagueApplication.java

📌 Player Model

Each player contains the following details:

id

name

nation

team

role

age (minimum 18)

active (true / false)

jerseyNumber

centuries

fifties

wickets

bestScore

Validation is applied using Jakarta Validation annotations.

🌐 API Endpoints
🔹 Get Players
GET /api/players

🔹 Filter Players
GET /api/players?name=Virat
GET /api/players?team=RCB
GET /api/players?role=Batsman
GET /api/players?nation=India
GET /api/players?team=Mumbai Indians&role=Bowler

🔹 Add New Player
POST /api/players

🔹 Update Player
PUT /api/players

🔹 Delete Player by Name
DELETE /api/players/{playerName}

📄 Sample JSON Request
{
"name": "Virat Kohli",
"nation": "India",
"team": "Royal Challengers Bengaluru",
"role": "Batsman",
"age": 35,
"active": true,
"jerseyNumber": 18,
"centuries": 8,
"fifties": 55,
"wickets": 4,
"bestScore": "113"
}

🧪 Swagger API Documentation

Swagger UI is enabled.

Access it here:

http://localhost:8080/swagger-ui.html


(or your deployed URL)

⚙️ Configuration
application.properties
spring.application.name=Premier League

server.port=${PORT:8080}
spring.data.mongodb.uri=${MONGO_URI}

springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html

🗄️ Database

MongoDB

Collection Name: players_stats

📦 How to Run the Project

Clone the repository

git clone https://github.com/your-username/premier-league.git


Configure MongoDB URI

Set MONGO_URI as an environment variable
or

Add it directly in application.properties

Run the application

mvn spring-boot:run


Access APIs via Swagger or Postman

🎯 Future Improvements

Pagination and sorting

Exception handling with custom error responses

DTOs and Mapper layer

Authentication & Authorization

MongoDB query optimization using repository methods

👨‍💻 Author

Gyan Ranjan Nayak
Java Backend Developer | Spring Boot | MongoDB