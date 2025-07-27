
# 🌐 REST API Practice Project — Spring Boot web flux_blackjack

[![Render Status](https://img.shields.io/badge/Render-Deployed-success)](https://your-render-url.onrender.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Blackjack game API developed with Java Spring Boot, MongoDB and MySQL, deployed in Render.


## 🧾 Project Overview

- Game management
- Complete blackjack logic
- Storage in MongoDB Atlas (games) and MySQL (users)
- Automatic deployment with CI/CD



## 🚀 Technologies Shared 

- Java 19 ☕  
- Spring Boot  (core backend)
- Spring Web flux (reactive programming)  
- Swagger (Springdoc OpenAPI)  
- Gradle  
- MongoDB Atlas (NoSQL Database)
- MySQL (Railway) (relational database)
- Render (deployment platform)
- Docker (containerization)


## 🚀 Haw to Deploy

- [Render](https://render.com)
- [MongoDB Atlas](https://www.mongodb.com/atlas)
- [Railway](https://railway.app) (optional for MySQL)



### Deployment Steps


**Environment Variables**: Set these variables in Render:


```env
SPRING_DATA_MONGODB_URI=mongodb+srv://usuario:contraseña@cluster.mongodb.net/dbblackjack?retryWrites=true&w=majority
SPRING_DATASOURCE_URL=jdbc:mysql://...
SPRING_R2DBC_PASSWORD=your_mysql_password
SPRING_PROFILES_ACTIVE=prod


```

### Automatic Deployment:


```bash
Connect your GitHub repository to Render

Set up auto-deploy on the main branch

Manual Deployment:

mvn clean package

java -jar target/blackjack/app.jar

```


### 🧑‍💻 Local Development


```bash
Clone the repository:
git clone https://github.com/FlavioKde/s05t01n01-blackjack.git

Configure local databases (optional):
docker-compose -f docker-compose.yml up

Run the application:
mvn spring-boot:run -Dspring-boot.run.profiles=dev


```


### 📚 Api Documentation 


The API includes Swagger UI available at:


```bash
https://your-render-url.onrender.com/swagger-ui.html

Example endpoints:

POST /game/new - New game

GET /player/getAll - Get all player

POST /statistics/player{id} - Player Statistics

```


### Test Section


### 🃏 Request Example (New game)


```json
POST /game/new
{
  "playerId": "123",
  "betAmount": 50,
  "....."
}
```


### 🛡️ Project Structure 


```text
src/
├── main/
│   ├── java/
│   │   └── cat/itacademy/s05/blackjack/
│   │       ├── config/        # General project configuration
│   │       ├── controller/    # REST Controllers (handle HTTP requests)
│   │       ├── domain/        # Business logic and domain models
│   │       ├── dto/           # Data Transfer Objects
│   │       ├── exception/     # Custom error and exception handling
│   │       ├── model/         # Database entities
│   │       ├── repository/    # Data access interfaces (CRUD operations)
│   │       └── services/      # Business logic implementation
│   └── resources/
│       ├── mongodb/           # MongoDB-related files (queries, scripts, etc.)
│       ├── mysql/             # MySQL-related files (queries, scripts, etc.)
│       ├── application.yml    # Main Spring Boot configuration
│       └── application.properties # Production configuration

```


### 🤝 How to Contribute


```text

Fork the proyect

Create your branch (git checkout -b feature/awesome-feature)

Commit your changes (git commit -m 'Add awesome feature')

Push to the branch (git push origin feature/awesome-feature)

Open a Pull Request

```


### Made with ❤️ for https://github.com/FlavioKde
