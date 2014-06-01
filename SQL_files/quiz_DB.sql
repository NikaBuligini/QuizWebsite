drop database if exists quiz_DB;
create database quiz_DB;

use quiz_DB;

create table users(
	ID int auto_increment not null primary key,
	userName  varchar(20) unique,
	pass nvarchar(60)
);


create table security_questions (
	ID int auto_increment not null primary key,
	question varchar(50)
);


create table additional_info(
	userID int,
	email varchar(40),
	firstName varchar(20),
	lastName varchar(40),
	birthday date,
	gender int,
	questionID int,
	answer varchar(30),
	PRIMARY KEY (userID),
	FOREIGN KEY (userID) REFERENCES users (ID) ON DELETE CASCADE,
	FOREIGN KEY (questionID) REFERENCES security_questions (ID),
	UNIQUE (email)
);


create table cookies (
    cookie_value varchar(60),
    userID int,
    PRIMARY KEY (cookie_value),
    FOREIGN KEY (userID)
        REFERENCES users (ID)
        ON DELETE CASCADE
);


create table friends(
	userID int,
	friendID int,
	foreign key FK_friends_users(userID) references users(ID)
	#foreign key FK_Friends_Users(UserID) references Users(ID)
);


create table achivements(
	ID int auto_increment not null primary key,
	description varchar(60),
	name varchar(30),
	imagefile CHAR(60)
);


create table achivementsAndUsers(
	userID int,
	achivementID int,
	foreign key FK_achivementsAndUsers_users(userID) references users(ID),	
	foreign key FK_achivementsAndUsers_achivements(achivementID) references achivements(ID)
);

create table quizCategories(
	ID int auto_increment not null primary key,
	category varchar(30)
);


create table quizzes(
	ID int auto_increment not null primary key,
	quizName varchar(30),
	description varchar(60),
	date datetime,
	creatorID int,
	categoryID int,
	foreign key FK_quizzes_users(creatorID) references users(ID),
	foreign key FK_quizzes_quizCategories(categoryID) references quizCategories(ID)
);


create table quizzesAndUsers(
	quizID int,
	userID int,
	foreign key FK_quizzesAndUsers_users(userID) references users(ID),
	foreign key FK_quizzesAndUsers_quizzes(quizID) references quizzes(ID)
);


create table questions(
	ID int auto_increment not null primary key,
	question varchar(90),
	quizID int,
	foreign key FK_questions_quizzes(quizID) references quizzes(ID)
);

create table answers(
	ID int auto_increment not null primary key,
	answer varchar(90),
	score int,
	questionID int,
	authorID int,
	foreign key FK_answers_users(authorID) references users(ID),
	foreign key FK_answers_questions(questionID) references questions(ID)
);

create table scores(
	score int,
	date datetime,
	userID int,
	quizID int,
	foreign key FK_scores_users(userID) references users(ID),
	foreign key FK_scores_quizzes(quizID) references quizzes(ID)
);