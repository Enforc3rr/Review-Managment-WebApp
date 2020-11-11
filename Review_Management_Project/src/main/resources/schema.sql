create table IF NOT EXISTS user_entity(
user_id bigint primary key NOT NULL auto_increment ,
username varchar(255) NOT NULL , 
first_name varchar(255) NOT NULL ,
last_name varchar(255) NOT NULL ,
email varchar(255) NOT NULL,
password varchar(255) NOT NULL ,
phone_number varchar(255) NOT NULL ,
user_role VARCHAR(255) ,
enabled BOOLEAN
);
CREATE TABLE IF NOT EXISTS book_entity(
bookid bigint primary key NOT NULL AUTO_INCREMENT,
book_name VARCHAR(255),
book_genre VARCHAR(255),
author VARCHAR(255) ,
addedBy VARCHAR(255)
);
	
CREATE TABLE IF NOT EXISTS book_addition(
book_addition_id BIGINT PRIMARY KEY not null AUTO_INCREMENT ,
book_id BIGINT ,
user_id BIGINT ,
FOREIGN KEY (book_id) REFERENCES book_entity(bookid) ,
FOREIGN KEY (user_id) REFERENCES user_entity(user_id) 
);