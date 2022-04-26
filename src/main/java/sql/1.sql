#table 1: login

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

#select * from user