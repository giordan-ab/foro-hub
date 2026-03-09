🚀 Foro Hub API - Challenge Alura
Foro Hub is a RESTful API designed to manage forum operations. 
It enables users to register and manage topics, track discussions, and navigate content efficiently through pagination and sorting.
The project implements a robust security layer using Spring Security and JWT (JSON Web Tokens) to ensure that only authenticated users can interact with the data.



🛠️ Technologies & Tools
Java 17
Spring Boot 3.x
Spring Data JPA (Hibernate)
Spring Security 6 (Stateless Authentication)
Auth0 JWT (Token generation and validation)
Flyway (Database Migrations)
MySQL (Relational Database)
Lombok (Boilerplate code reduction)
Maven (Dependency Management)



📌 Features
Full CRUD for Topics: Create, Read, Update, and Delete forum topics.
Authentication & Security:
Stateless authentication via JWT.
Password encryption using BCrypt.
Role-based access control (RBES).
Database Management: Automated schema versioning with Flyway.
Validations: Strict data integrity using Bean Validation (@Valid).



⚙️ Installation & Setup
Clone the repository:

git clone https://github.com


Configure Database:
Update src/main/resources/application.properties with your MySQL credentials:

properties
spring.datasource.url=jdbc:mysql://localhost/foro_hub
spring.datasource.username=your_user
spring.datasource.password=your_password
api.security.token.secret=your_super_secret_key


Run Migrations:
Flyway will automatically create the tables upon the first run.


Launch the Application:
Run ForoApplication.java from your IDE or via terminal:

mvn spring-boot:run



🔐 API Documentation (Endpoints)
Authentication
POST /login - Receives login and contrasena. Returns a Bearer Token.

Topics (Requires Token)
GET /topicos - Lists all topics.
POST /topicos - Creates a new topic.
PUT /topicos/{id} - Updates a specific topic.
DELETE /topicos/{id} - Removes a topic.



📝 Usage Note
To test the endpoints in tools like Insomnia or Postman:

Authenticate via /login to obtain the JWT.
Add the token in the Authorization Header as Bearer <your_token>.
