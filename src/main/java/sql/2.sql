
#table 2: subject

#do not drop
drop table if exists subject;

create table subject
(
subject varchar(100) not null default ''
,level varchar(10) not null default ''
,test_id varchar(100) not null default ''
);
   
insert into subject (subject,level) 
values 
('addition','k1'), ('subtraction','k1'), ('counting','k1')
,('multiplication','k23'), ('division','k23'), ('sequence','k23') 
,('fraction','k4'), ('decimal','k4'), ('shape','k4');

update subject set test_id=concat(level, '-', left(subject,3));

#select * from subject
