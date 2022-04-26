
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
cross join subject as b 
);

select * from reward;
        