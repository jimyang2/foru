
drop table questions if exists ; 

create table questions(
	id int primary key auto_increment,
	number int,
	question varchar(250),
	QA varchar(250),
	anum varchar(250),
	score varchar(250),
	seq varchar(250)
	);