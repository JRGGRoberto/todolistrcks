<h1 align="center">
    <span style="background-color: green; border-radius: 18px; padding: 8px; marging: 2px;">ToDoList BackEnd Rest </span>
</h1>


<div align="center">

<img src="https://img.shields.io/github/languages/count/JRGGRoberto/todolistrcks">
<img src="https://img.shields.io/github/repo-size/JRGGRoberto/todolistrcks">
<img src="https://img.shields.io/github/last-commit/JRGGRoberto/todolistrcks"> <img src="https://img.shields.io/github/issues/JRGGRoberto/todolistrcks">

</div>


> **Warning** This project is under development.


## Technologies

This project is being developed with the following technologies::

* Java 17
* Maven
* Docker
* Spring Boot
* H2 Database

## Project

Creating Back-end API using Spring Boot 2.0 and Java 17.

## Routes


Method    |  Object  | For    | Query           | JSON                                         | Basic Auth
----------| :-----|:---------:|:---------------:|:--------------------------------------------:|:---------------:
POST      | USER  | create    | host/user       | name, username, password                     |              |
POST      | TASK  | create    | host/tasks      | description, title, priority, startAt, endAt | ✔️             |
GET       | TASK  | list all  | host/tasks      |                                              | ✔️             |
PUT       | TASK  | update    | host/tasks/{id} | <fields you want to change >                 | ✔️             |


