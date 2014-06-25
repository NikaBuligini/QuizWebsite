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
		values ('3', 'noe', 'buligini', 1, 6, 'ki');

insert into categories(type) value ('sport');
insert into categories(type) value ('skami');
insert into categories(type) value ('zoro');

select * from additional_info;
select * from users;
select * from quizzes;
select * from categories;

SET FOREIGN_KEY_CHECKS=1;

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

insert into playedQuizes(userID,quizID) values (1,1);
insert into playedQuizes(userID,quizID) values (1,1);
insert into playedQuizes(userID,quizID) values (1,1);
insert into playedQuizes(userID,quizID) values (1,1);
insert into playedQuizes(userID,quizID) values (1,1);

insert into achievementsAndUsers(userID,achievementID) values (1,1);
insert into achievementsAndUsers(userID,achievementID) values (1,2);
insert into achievementsAndUsers(userID,achievementID) values (1,3);
insert into achievementsAndUsers(userID,achievementID) values (1,4);
insert into achievementsAndUsers(userID,achievementID) values (1,5);

select * from achievementsAndUsers;
select * from achievements;
select * from users;

select * from quizzes join friends on friends.friendID = quizzes.creatorID where friends.userID = 1 order by quizzes.date asc limit 5;


insert into newsFeed (userID,text,subjectID,objectID) values (1, " misalma " , 2, 3);
insert into newsFeed (userID,text,subjectID,objectID) values (2, " gamarjobao " , 1, 3);