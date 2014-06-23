use quiz_DB;

insert into security_questions (question) value ('are two piglets pig?');
insert into security_questions (question) value ('if it will be freeze will it land?');
insert into security_questions (question) value ('capital of georgia?');
insert into security_questions (question) value ('three times seven?');
insert into security_questions (question) value ('spiderman on margaluri?');
insert into security_questions (question) value ('2*2?');

select * from security_questions;

insert into users(email,pass) values ('meme','cxeni');
insert into users(email,pass) values ('zoro','cxeni');
insert into users(email,pass) values ('zoroscxeni','cxeni');

insert into friends(userID,friendID) values(1,2);

insert into additional_info (userID, firstName, lastName, gender, questionID, answer)
		values ('1', 'nika', 'buligini', 1, 6, 'ki');

insert into additional_info (userID, firstName, lastName, gender, questionID, answer)
		values ('2', 'nika', 'buligini', 1, 6, 'ki');
insert into additional_info (userID, firstName, lastName, gender, questionID, answer)
		values ('3', 'nika', 'buligini', 1, 6, 'ki');

select * from additional_info;
select * from users;

insert into quizzes(quizName) value ('opa');
insert into quizzes(quizName) value ('opasd');
insert into quizzes(quizName) value ('odaa');
insert into quizzes(quizName) value ('da');
insert into quizzes(quizName) value ('opada');

insert into quizzesandusers(userID,quizID) values (1,1);
insert into quizzesandusers(userID,quizID) values (1,1);
insert into quizzesandusers(userID,quizID) values (1,1);
insert into quizzesandusers(userID,quizID) values (1,1);
insert into quizzesandusers(userID,quizID) values (1,1);

insert into usersAndMadeQuizes(userID,quizID) values (1,1);
insert into usersAndMadeQuizes(userID,quizID) values (1,1);
insert into usersAndMadeQuizes(userID,quizID) values (1,1);
insert into usersAndMadeQuizes(userID,quizID) values (1,1);
insert into usersAndMadeQsuizes(userID,quizID) values (1,1);

insert into achievementsAndUsers(userID,achievementID) values (1,1);
insert into achievementsAndUsers(userID,achievementID) values (1,2);
insert into achievementsAndUsers(userID,achievementID) values (1,3);
insert into achievementsAndUsers(userID,achievementID) values (1,4);
insert into achievementsAndUsers(userID,achievementID) values (1,5);

select * from achievementsAndUsers;
select * from achievements;

