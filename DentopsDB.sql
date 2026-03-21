CREATE database DentopsDB;

USE DentopsDB;

CREATE table Client(
	idUser int auto_increment not null,
    email varchar(50),
    password varchar(50),
    primary key(idUser)
);

USE DentopsDB;

select *from Client

select email from user;

insert into user(email, password) values('mihaelamoga23@gmail.com', 'Pacific2027!');