create table PROJECT
(
	ID int not null,
    PRO_NAME char(50) not null,
    BUDGET int not null,
    constraint pro_1 primary key(ID)
);

create table EMPLOYEE
(
	ID int not null,
    EMP_NAME char(100) not null,
    EMAIL varchar(100) not null,
    PID int,
    constraint emp_1 primary key(ID), foreign key(PID) references PROJECT(ID)
);

insert into PROJECT values(1,"att", 1000);
insert into PROJECT values(2,"linkedin", 3000);
insert into PROJECT values(3,"att", 1000);
insert into PROJECT values(4, "att",1000);

insert into EMPLOYEE values(1, "user1","abc@xyz.in",1);
insert into EMPLOYEE values(2, "user2", "sdK@xyz.in", 2);
insert into EMPLOYEE values(3,"user3","bch@xyz.in", 3);
insert into EMPLOYEE values(4, "user4", "sdhf@abc.in", 4);

select e.id, e.EMP_NAME, e.email, p.id, p.PRO_NAME
from EMPLOYEE as e, PROJECT as p
where e.PID = p.ID;

select *
from EMPLOYEE as e inner join PROJECT as p 
on e.PID = p.ID;