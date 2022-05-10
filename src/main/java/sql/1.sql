drop table if exists user;

create table user
(
 user_id int 
,user_name varchar(100) not null default ''
,password varchar(100) not null default ''
);
		
insert into user (user_name,password) values ('user1','user1');
    
update 
user as a
inner join (
   select (dense_rank() over (order by user_name)) as user_id,user_name from user
) as x 
on a.user_name=x.user_name  
set a.user_id=x.user_id;

drop table if exists standard;

create table standard
(
subject varchar(100) not null default ''
,level varchar(10) not null default ''
,test_id varchar(100) not null default ''
);
   
insert into standard (subject,level,test_id) 
values 
('addition','k1','1a'), ('subtraction','k1','1s'), ('counting','k1','1c')
,('multiplication','23','2m'), ('division','23','2d'), ('sequence','23','2s') 
,('fraction','4','4f'), ('decimal','4','4d'), ('shape','4','4s');

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
);
   
insert into test (user_id,user_name,subject,level, test_id)
(
select distinct a.user_id,a.user_name,b.subject,b.level, b.test_id from user as a cross join standard as b 
); 

#select * from test

#table 4: practice

drop table if exists practice;

create table practice
(
user_id int
,user_name varchar(100) not null default ''
,test_id varchar(100) not null default ''
,subject varchar(100) not null default ''
,level varchar(10) not null default ''
,correct int not null default 0
,total int not null default 0
);
      
insert into practice
(user_id,user_name,test_id,subject,level)
(
select user_id,user_name,test_id,subject,level
from test
);

#select * from practice

#update practice 
#set correct=correct+2, total=total+3
#where user_name="xyz" and test_id="k1-sub";

drop table if exists reward;

create table reward
(
 user_id int
,user_name varchar(100) not null default ''
,level varchar(10) not null default ''
,reward_1 int not null default 0
,reward_2 int not null default 0
,reward_3 int not null default 0
,reward_4 int not null default 0
,reward_5 int not null default 0
);
   
insert into reward (user_id,user_name,level)
(
select distinct a.user_id,a.user_name,b.level
from user as a
cross join standard as b 
);

#select * from reward;