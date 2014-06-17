use quiz_DB;

insert into security_questions (question) value ('');
insert into security_questions (question) value ('are two piglets pig?');
insert into security_questions (question) value ('if it will be freeze will it land?');
insert into security_questions (question) value ('capital of georgia?');
insert into security_questions (question) value ('three times seven?');
insert into security_questions (question) value ('spiderman on margaluri?');
insert into security_questions (question) value ('2*2?');

select * from security_questions;

insert into users(username,pass) values ('zoro','cxeni');
insert into additional_info (userID, email, firstName, lastName, birthday, gender, questionID, answer)
		values ('1', 'zgarbi@udabno.com', 'nika', 'buligini', '1993-08-01', 1, 1, 'ki');
