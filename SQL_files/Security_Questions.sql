use quiz_DB;

insert into security_questions (question) value ('ორი გოჭი ღორია?');
insert into security_questions (question) value ('რომ მოყინოს დადებს?');
insert into security_questions (question) value ('საქართველოს დედაქალაქი?');
insert into security_questions (question) value ('სამჯერ შვიდი?');
insert into security_questions (question) value ('სპაიდერმენი მეგრულად?');
insert into security_questions (question) value ('2*2?');

select * from additional_info;

insert into additional_info (userID, email, firstName, lastName, birthday, gender, questionID, answer)
		values ('3', 'zgarbi@udabno.com', 'nika', 'buligini', '1993-08-01', 1, 1, 'ki');