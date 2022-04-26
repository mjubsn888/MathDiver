
#table 3: test

drop table if exists test;

create table test
(
user_id int
,user_name varchar(100) not null default ''
,test_id varchar(100) not null default ''
,subject varchar(100) not null default ''
,level varchar(10) not null default ''
,correct int not null default 0
,total int not null default 0
,percent decimal(12,2) not null default 0.0
);
   
insert into test (user_id,user_name,subject,level, test_id)
(
select distinct a.user_id,a.user_name,b.subject,b.level, b.test_id from user as a cross join subject as b 
); 

select * from test