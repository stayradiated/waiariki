create table employee (
	
	id int identity(1,1) not null,
	firstname varchar(20) not null,
	lastname varchar(20) not null,
	salary float not null,
	department char(1) not null,
	
	constraint pk_employee primary key (id)

);

create table employee_del (
	
	id int identity(1,1) not null,
	firstname varchar(20) not null,
	lastname varchar(20) not null,
	salary float not null,
	department char(1) not null,
	
	constraint pk_employee_del primary key (id)

);

create table audit_salary (
	id int identity(1,1) not null,
	employee_id int null,
	username varchar(16) null,
	date datetime null,
	salary_old float null,
	salary_new float null,
	constraint pk_audit_salary primary key (id)
);

set identity_insert employee_del on;
set identity_insert employee on;

create trigger delete_employee on employee after delete as
begin
	insert into employee_del (id, firstname, lastname, salary, department) select * from deleted
end

create trigger update_salary
on employee after update
as if update(salary)
begin
	declare @salary_old float
	declare @salary_new float
	declare @employee int
	
	select @salary_old = (select salary from deleted)
	select @salary_new = (select salary from inserted)
	select @employee   = (select id from deleted)
	
	insert into audit_salary (employee_id, username, date, salary_old, salary_new)
	values (@employee, user_name(), getdate(), @salary_old, @salary_new)
end