
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
,percent decimal(12,2) not null default 0.0
);
      
insert into practice
(user_id,user_name,test_id,subject,level)
(
select user_id,user_name,test_id,subject,level
from test
)

#select * from practice