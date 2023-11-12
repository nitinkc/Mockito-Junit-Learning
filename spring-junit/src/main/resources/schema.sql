--CREATE DATABASE 'restful_webservice' /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION=''N'' */;

DROP TABLE IF EXISTS messages;
create table messages
(
    id integer not null,
    author varchar(60) not null,
    message varchar(100) not null,
    create_dt DATETIME not null,
    primary key(id)
);