create database testdb;
use testdb;
create table users(user_id bigint auto_increment,
email varchar(100) not null,
password varchar(200) not null,
username varchar(30) not null,
primary key(user_id));

create table saved_stocks(stock_id bigint auto_increment,
stock_rank int,
company_name varchar(150) not null,
nse decimal,
bse decimal,
percent_profit decimal,
buy_from varchar(10),
user_id bigint ,
primary key(stock_id),
foreign key(user_id) references users(user_id));