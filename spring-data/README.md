# Spring Data

![JDK](https://img.shields.io/badge/JDK-17-yellow.svg?style=flat-square&logo=Java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.1-brightgreen.svg?style=flat-square&logo=springboot)
---
## The project

Maven project to showcase how Spring Data works with different databases.

## How to run

H2 database: 
- Run with `maven clean install` command.

MySQL: 

- Change `spring.profiles.active: h2` to `spring.profiles.active: mysql`
- Run MySQL database (on port `3306`)
- Create database named `simple`
- Run `maven clean install`
