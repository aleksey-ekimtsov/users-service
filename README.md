users-service
-
users-service is demo project that includes a following technologies and frameworks:
* maven
* spring-boot
* jpa
* liquibase
* swagger-ui
* docker
* docker compose
* IT using docker


To build and run project you need installed JDK8, Docker and Maven. Start Docker, execute:
    
    mvn clean install

mysql/mysql-server:5.7 and users-app images will be pulled to your local Docker repository. 
then go to  `src/main/docker` directory and execute: 

    docker-compose up -d
    
users-db-mysql and users-app containers will be executed on your docker.

Swagger UI will available on http://localhost:8080/swagger-ui.html or on http://YOUR_DOCKER_HOST:8080/swagger-ui.html if you use Docker Toolbox 
    
