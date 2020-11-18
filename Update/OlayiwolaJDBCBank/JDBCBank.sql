create schema if not exists kittenland authorization busayomi;

select * from public."customer";

create schema if not exists pokemanland authorization busayomi;
--TO SWITCH schema
set search_path to kittenland;

create schema if not exists jdbcbank authorization busayomi;

set search_path to jdbcbank;



create table users(
firstName varchar(20),
lastName varchar(20),
userName varchar(20),
password varchar(20),
driverLicense varchar(20),
age int,
usersId serial primary key
);

insert into Users (firstName,lastName,userName,password,driverLicense,age)values('yomi','ola','olab','bola','888b',30);
insert into Users (firstName,lastName,userName,password,driverLicense,age)values('david','jones','jonesD','DAVIDj','568b',40);
insert into Users (firstName,lastName,userName,password,driverLicense,age)values('seyi','baba','babaS','Bseyi','555c',45);
insert into Users (firstName,lastName,userName,password,driverLicense,age)values('jone','gold','Gjones','Jgold','655c',25);




delete users set usersId=1 where account = null;

select * from account where accountId = 3;
update Users set firstName ='michelle' where usersId = 1;

insert into account (balance,accountType)values(60, 'checkings');
insert into account (balance,accountType)values(50, 'savings');
insert into account (balance,accountType)values(40, 'checkings');
insert into account (balance,accountType)values(100, 'savings');

insert into account (accountId) values(1);

select firstName from Users where firstName ='david';

select accountId from Account where accountId =1;
select usersId from users where usersId =5;

create table account(
accountId serial primary key,
balance numeric,
withdraw numeric,
deposit numeric,
accountType varchar(20) 
);

delete from account where balance =100;

update account set deposit = 100;

create table usersAccount(
accountId int,
usersId int,
foreign key (usersId) references users(usersId) on delete cascade,
foreign key (accountId) references account(accountId) on delete cascade
);




select * from users;
select * from account;

--select * from usersAccount;



--drop table account;
--drop table users;
--drop table usersAccount;
