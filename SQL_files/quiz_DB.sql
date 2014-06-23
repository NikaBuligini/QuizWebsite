drop database if exists quiz_DB;
create database quiz_DB;

use quiz_DB;

create table users(
	ID int auto_increment not null primary key,
	email  varchar(30),
	pass nvarchar(60)
);


create table security_questions (
	ID int auto_increment not null primary key,
	question varchar(50)
);


create table additional_info (
    userID int,
    firstName varchar(20),
    lastName varchar(30),
    gender int,
    questionID int,
    answer varchar(30),
	image varchar(30),
    PRIMARY KEY (userID),
    FOREIGN KEY (userID)
        REFERENCES users (ID)
        ON DELETE CASCADE,
    FOREIGN KEY (questionID)
        REFERENCES security_questions (ID)
        ON DELETE CASCADE
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
);


create table achievements(
	ID int auto_increment not null primary key,
	description varchar(60),
	name varchar(30),
	imagefile CHAR(100)
);


create table achievementsAndUsers(
	userID int,
	achievementID int,
	foreign key FK_achievementsAndUsers_users(userID) references users(ID),	
	foreign key FK_achievementsAndUsers_achievements(achievementID) references achievements(ID)
);

create table quizCategories(
	ID int auto_increment not null primary key,
	category varchar(30)
);

create table categories(
	ID int auto_increment not null primary key,
	type varchar(30)
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

create table challenges(
	ID int auto_increment not null primary key,
	fromID int,
	toID int,
	message varchar (60),
	quizID int,
	foreign key FK_challenges_quizzes(quizID) references quizzes(ID),
	foreign key FK_challenges_users(fromID) references users(ID)	

);

create table friendRequest(
	ID int auto_increment not null primary key,
	fromID int,
	toID int,
	foreign key FK_friendRequest_users(fromID) references users(ID)

);

create table messages(
	ID int auto_increment not null primary key,
	fromID int,
	toID int,
	text varchar(90),
	foreign key FK_messages_users(fromID) references users(ID)
);





create table quizzesAndUsers(
	quizID int,
	userID int,
	foreign key FK_quizzesAndUsers_users(userID) references users(ID),
	foreign key FK_quizzesAndUsers_quizzes(quizID) references quizzes(ID)
);

create table usersAndMadeQuizes(
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