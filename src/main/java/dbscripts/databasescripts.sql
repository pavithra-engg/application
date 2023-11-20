create table users(userid serial,username varchar(50),password varchar(50),levelsflag varchar(2))
go
select * from users order by levelsflag
go
insert into users(username,password,levelsflag) values('Aarav','guest','1')
go
insert into users(username,password,levelsflag) values('Priya','guest','2')
go
insert into users(username,password,levelsflag) values('Rajesh','guest','3')
go
insert into users(username,password,levelsflag) values('Sunita','guest','4')
go
insert into users(username,password,levelsflag) values('Mohan','guest','5')
go
create table studentsdata(studentid serial,studentname varchar(50),levelsflag  varchar(2) default  '1' ,userid varchar(20) default  'Aarav' )
go
insert into studentsdata(studentname) values('Pavithra')
go
insert into studentsdata(studentname) values('Divya')
go
insert into studentsdata(studentname) values('Lavanya')
go
insert into studentsdata(studentname) values('Swathi')
go
insert into studentsdata(studentname) values('Babu')
go
insert into studentsdata(studentname) values('Jyothi')
go
//Login againt student details
select * from studentsdata where userid='Priya'
//Arav Approved Jyothi Levelsflag and UserId Need to Update
go
//arav to priya 
select levelsflag from users where cast(levelsflag as integer) > cast(1 as integer) order by levelsflag limit 1
go
select username from users where cast(levelsflag as integer) > cast(1 as integer) order by levelsflag limit 1 
go
// Leve1 Approved or Recject , Level2 ,Level3 ,
create table studentsdataapproval (studentid int,levelsflag varchar(2),levelsstatus varchar(20),userid varchar(20) )
go
select * from studentsdataapproval
go
insert into studentsdataapproval(studentid,levelsflag,levelsstatus,userid) values('6','1','Y','Aarav')
go
update studentsdata set levelsflag='2',userid='Priya' where studentid='6'
go
select * from studentsdata
go
select  from users
go

go

go

