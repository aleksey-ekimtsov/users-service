#!/usr/bin/env sh
./wait-for-it.sh users-db-mysql:3306 -t 15
java -Djava.security.egd=file:/dev/./urandom -jar app.jar
